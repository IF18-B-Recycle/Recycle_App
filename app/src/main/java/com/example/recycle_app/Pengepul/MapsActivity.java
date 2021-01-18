package com.example.recycle_app.Pengepul;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recycle_app.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Button btToast;

    Location myLocation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btToast = findViewById(R.id.btToast);




        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String longitude = extras.getString("longitude");
                String latitude = extras.getString("latitude");

                Toast.makeText(MapsActivity.this, longitude, Toast.LENGTH_SHORT).show();
                Toast.makeText(MapsActivity.this, latitude, Toast.LENGTH_SHORT).show();
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