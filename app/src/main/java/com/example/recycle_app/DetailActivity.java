package com.example.recycle_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycle_app.Model.ModelHargaBarang;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailActivity extends AppCompatActivity {

    Button btnJualBarang;
    ImageView ivImage;
    TextView tvnamaTempat;
    TextView tvOwner;

    TextView tvHargaKertas,tvHargaPlastik,tvHargaLogam,tvHargaAluminium,tvHargaBotolKaca,tvHargaKardus;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImage = (ImageView)findViewById(R.id.ivImage);
        tvnamaTempat = (TextView)findViewById(R.id.tvnamaTempat);
        tvOwner = (TextView)findViewById(R.id.tvOwner);

        tvHargaKertas = findViewById(R.id.tvHargaKertas);
        tvHargaPlastik = findViewById(R.id.tvHargaPlastik);
        tvHargaLogam = findViewById(R.id.tvHargaLogam);
        tvHargaAluminium = findViewById(R.id.tvHargaAluminium);
        tvHargaBotolKaca = findViewById(R.id.tvHargaBotolKaca);
        tvHargaKardus = findViewById(R.id.tvHargaKardus);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();
        getdata();

        btnJualBarang = (Button)findViewById(R.id.btnJualBarang);
        btnJualBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityJualBarang.class);
                startActivity(intent);
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
                tvHargaAluminium.setText(hargaBarang.getHarga_aluminium());
                tvHargaBotolKaca.setText(hargaBarang.getHarga_botol_kaca());
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
}