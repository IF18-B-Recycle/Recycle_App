package com.example.recycle_app.Pengepul;

import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recycle_app.R;
import com.example.recycle_app.User.Model.ModelJualBarang;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Button btJemputSekarang, btRincianTransaksi;

    Location myLocation = null;
    ModelJualBarang modelJualBarang = new ModelJualBarang();
    String alamat = modelJualBarang.getAlamat();
    String nama = modelJualBarang.getNama();

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btJemputSekarang = findViewById(R.id.btJemputSekarang);
        btRincianTransaksi = findViewById(R.id.btRincianTransaksi);

        database = FirebaseDatabase.getInstance().getReference();

        btRincianTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // menampikan activity rincian transaksi
                //isinya rincian transaksi semua yang ada di child transaksi tampilkan
            }
        });


        btJemputSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ubah data Transaksi pada bagian proses jadi "dalam penjemputan"

                modelJualBarang.setProses("Dalam Penjemputan");
                updateTransaksi(modelJualBarang);

                //kalo bisa langsung tampilkan rute untuk menuju ke tempat penjemputan


            }
        });
    }

    private void dialogJemput(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Penjemputan Barang Rongsok");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Anda Sedang menjemput " + nama +"/n" +
                        "Lokasi di " + alamat)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do something
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    //Proses Update data yang sudah ditentukan
    private void updateTransaksi(ModelJualBarang modelJualBarang){
        String id_transaksi = modelJualBarang.getId_transaksi();
        database.child("Transaksi")
                .child(id_transaksi)
                .setValue(modelJualBarang)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dialogJemput();
                        finish();
                    }
                });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle extras = getIntent().getExtras();
        String longitude = extras.getString("longitude");
        String latitude = extras.getString("latitude");

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latLng.latitude, latLng.longitude)).zoom(16).build();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

                myLocation=location;
                LatLng ltlng=new LatLng(location.getLatitude(),location.getLongitude());
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                        ltlng, 16f);

            }
        });
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Location"));

    }


}