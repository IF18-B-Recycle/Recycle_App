package com.example.recycle_app.Pengepul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.recycle_app.Pengepul.PengepulFragment.PengepulBarangFragment;
import com.example.recycle_app.Pengepul.PengepulFragment.PengepulHomeFragment;
import com.example.recycle_app.Pengepul.PengepulFragment.PengepulProfileFragment;
import com.example.recycle_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PengepulMainActivity extends AppCompatActivity {

    //Views
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengepul_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PengepulHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment =  new PengepulHomeFragment();
                            break;
                        case R.id.nav_myorder:
                            selectedFragment = new PengepulBarangFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new PengepulProfileFragment();
                            break;
                    }

                    if (selectedFragment != null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }
                    return true;
                }
            };

}