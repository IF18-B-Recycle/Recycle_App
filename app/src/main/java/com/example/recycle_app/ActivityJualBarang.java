package com.example.recycle_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.Adapter.MyOrderAdapter;
import com.example.recycle_app.Model.ModelHargaBarang;
import com.example.recycle_app.Model.ModelJualBarang;
import com.example.recycle_app.Model.ModelMyOrder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ActivityJualBarang extends AppCompatActivity {

    TextView tvHargaKertas, tvHargaPlastik, tvHargaLogam, tvHargaKaca, tvHargaAlmu, tvHargaKardus;
    EditText etJumlahKertas, etJumlahPlastik, etJumlahLogam, etJumlahKaca, etJumlahAlmu, etJumlahKardus;
    EditText etNama, etAlamat, etNoHp;
    Button btnLokasi, btnJual;


    FusedLocationProviderClient fusedLocationProviderClient;
    FirebaseAuth auth;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    public String latitude,longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_barang);
        auth = FirebaseAuth.getInstance();

        tvHargaKertas = findViewById(R.id.tvHargaKertas);
        tvHargaPlastik = findViewById(R.id.tvHargaPlastik);
        tvHargaLogam = findViewById(R.id.tvHargaLogam);
        tvHargaKaca = findViewById(R.id.tvHargaKaca);
        tvHargaAlmu = findViewById(R.id.tvHargaAlmu);
        tvHargaKardus = findViewById(R.id.tvHargaKardus);

        etJumlahKertas = findViewById(R.id.etJumlahKertas);
        etJumlahPlastik = findViewById(R.id.etJumlahPlastik);
        etJumlahLogam = findViewById(R.id.etJumlahLogam);
        etJumlahKaca = findViewById(R.id.etJumlahKaca);
        etJumlahAlmu = findViewById(R.id.etJumlahAlmu);
        etJumlahKardus = findViewById(R.id.etJumlahKardus);

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etNoHp = findViewById(R.id.etNoHp);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();
        getdata();

        btnJual = findViewById(R.id.btnJual);
        btnJual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JualBarang();
            }
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(ActivityJualBarang.this);
        btnLokasi = findViewById(R.id.btnLokasi);
        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DapatkanLokasi();
            }
        });

    }

    private void getdata() {

        getRefenence.child("Barang").addChildEventListener(new ChildEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Mengambil daftar item dari database, setiap kali ada turunannya
                ModelHargaBarang hargaBarang = dataSnapshot.getValue(ModelHargaBarang.class);
                tvHargaAlmu.setText(hargaBarang.getHarga_aluminium());
                tvHargaKaca.setText(hargaBarang.getHarga_botol_kaca());
                tvHargaKardus.setText(hargaBarang.getHarga_kerdus());
                tvHargaKertas.setText(hargaBarang.getHarga_kertas());
                tvHargaPlastik.setText(hargaBarang.getHarga_plastik());
                tvHargaLogam.setText(hargaBarang.getHarga_logam());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //......
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //......
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //.....
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Digunakan untuk menangani kejadian Error
                Log.e("MyListData", "Error: ", databaseError.toException());
            }
        });
    }



    private void DapatkanLokasi() {
        // GET CURRENT LOCATION

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    //initialize location
                    Location location = task.getResult();
                    if (location != null){
                        String ll;
                        try {
                            //initialize geocoder
                            Geocoder geocoder = new Geocoder(ActivityJualBarang.this, Locale.getDefault());

                            //initialize address list
                            List<Address> addresses = geocoder.getFromLocation(
                                    location.getLatitude(),location.getLongitude(),1
                            );
                            latitude = String.valueOf(addresses.get(0).getLatitude());
                            longitude = String.valueOf(addresses.get(0).getLongitude());
                            Toast.makeText(ActivityJualBarang.this, "Lokasi Berhasil di ambil" , Toast.LENGTH_SHORT).show();
                        }catch (IOException e){
                            e.printStackTrace();


                        }

                    }
                }
            });
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

    }


    private void JualBarang(){
        //Mendapatkan UserID dari pengguna yang Terautentikasi
        String getUserID = auth.getCurrentUser().getUid();

        //Mendapatkan Instance dari Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference getReference;

        //Menyimpan Data yang diinputkan User kedalam Variable
        String getHargaKertas = tvHargaKertas.getText().toString();
        String getHargaPlastik = tvHargaPlastik.getText().toString();
        String getHargaLogam = tvHargaLogam.getText().toString();
        String getHargaKaca = tvHargaKaca.getText().toString();
        String getHargaAlmu = tvHargaAlmu.getText().toString();
        String getHargaKardus = tvHargaKardus.getText().toString();

        String getJumlahKertas = etJumlahKertas.getText().toString();
        String getJumlahPlastik = etJumlahPlastik.getText().toString();
        String getJumlahLogam = etJumlahLogam.getText().toString();
        String getJumlahKaca = etJumlahKaca.getText().toString();
        String getJumlahAlmu = etJumlahAlmu.getText().toString();
        String getJumlahKardus = etJumlahKardus.getText().toString();

        String getNama = etNama.getText().toString();
        String getAlamat = etAlamat.getText().toString();
        String getNoHp = etNoHp.getText().toString();

        Integer HargaKertas = Integer.parseInt(getHargaKertas);
        Integer Hargaplastik = Integer.parseInt(getHargaPlastik);
        Integer HargaLogam = Integer.parseInt(getHargaLogam);
        Integer HargaKaca = Integer.parseInt(getHargaKaca);
        Integer HargaAlmu = Integer.parseInt(getHargaAlmu);
        Integer HargaKardus = Integer.parseInt(getHargaKardus);

        Integer JumlahKertas = Integer.parseInt(getJumlahKertas);
        Integer JumlahPlastik = Integer.parseInt(getJumlahPlastik);
        Integer JumlahLogam = Integer.parseInt(getJumlahLogam);
        Integer JumlahKaca = Integer.parseInt(getJumlahKaca);
        Integer JumlahAlmu = Integer.parseInt(getJumlahAlmu);
        Integer JumlahKardus = Integer.parseInt(getJumlahKardus);

        Integer total = ((HargaKertas*JumlahKertas)+(Hargaplastik*JumlahPlastik)+(HargaLogam*JumlahLogam)+(HargaKaca*JumlahKaca)+(HargaAlmu*JumlahAlmu)+(HargaKardus*JumlahKardus));
        String getSubtotal = total.toString();

        String getProses = "dalam_proses";

        String getLongitude = longitude;
        String getLatitude = latitude;

        getReference = database.getReference(); // Mendapatkan Referensi dari Database
/*
        // Mengecek apakah ada data yang kosong
        if(isEmpty(getNIM) && isEmpty(getNama) && isEmpty(getJurusan)){
            //Jika Ada, maka akan menampilkan pesan singkan seperti berikut ini.
            Toast.makeText(MainActivity.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
        }else {

        Jika Tidak, maka data dapat diproses dan meyimpannya pada Database
        Menyimpan data referensi pada Database berdasarkan User ID dari masing-masing Akun
        */
        getReference.child("Transaksi").child(getUserID).push()
                .setValue(new ModelJualBarang(getHargaKertas,getHargaPlastik,getHargaLogam,getHargaKaca,getHargaAlmu,getHargaKardus, getJumlahKertas,getJumlahPlastik,getJumlahLogam,getJumlahKaca,getJumlahAlmu,getJumlahKardus, getNama,getAlamat,getNoHp,getSubtotal,getProses,getLongitude,getLatitude))
                .addOnSuccessListener(this, new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        //Peristiwa ini terjadi saat user berhasil menyimpan datanya kedalam Database
                        Toast.makeText(ActivityJualBarang.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}