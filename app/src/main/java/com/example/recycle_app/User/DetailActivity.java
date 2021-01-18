package com.example.recycle_app.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.Pengepul.Model.ModelHargaBarang;
import com.example.recycle_app.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailActivity extends AppCompatActivity {

    Button btnJualBarang;
    ImageView ivImage;
    TextView tvnamaTempat;
    TextView tvOwner;

    TextView tvHargaKertas, tvHargaPlastik, tvHargaLogam, tvHargaAluminium, tvHargaBotolKaca, tvHargaKardus;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImage = findViewById(R.id.ivImage);
        tvnamaTempat = findViewById(R.id.tvnamaTempat);
        tvOwner = findViewById(R.id.tvOwner);

        tvHargaKertas = findViewById(R.id.tvHargaKertas);
        tvHargaPlastik = findViewById(R.id.tvHargaPlastik);
        tvHargaLogam = findViewById(R.id.tvHargaLogam);
        tvHargaAluminium = findViewById(R.id.tvHargaAluminium);
        tvHargaBotolKaca = findViewById(R.id.tvHargaBotolKaca);
        tvHargaKardus = findViewById(R.id.tvHargaKardus);

        Bundle extras = getIntent().getExtras();
        String id_pengepul = extras.getString("id_pengepul");
        String nama_toko = extras.getString("nama_toko");
        String owner = extras.getString("owner");

        tvnamaTempat.setText(nama_toko);
        tvOwner.setText(owner);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();
        getdata();


        btnJualBarang = (Button) findViewById(R.id.btnJualBarang);
        btnJualBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityJualBarang.class);
                intent.putExtra("id_pengepul", id_pengepul);
                startActivity(intent);
            }
        });
    }

    private void getdata() {
        Bundle extras = getIntent().getExtras();
        String id_pengepul = extras.getString("id_pengepul");
        getRefenence.child("Barang")
                .child(id_pengepul)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Mengambil daftar item dari database, setiap kali ada turunannya
                        ModelHargaBarang hargaBarang = snapshot.getValue(ModelHargaBarang.class);
                        tvHargaAluminium.setText(hargaBarang.getHarga_aluminium());
                        tvHargaBotolKaca.setText(hargaBarang.getHarga_botol_kaca());
                        tvHargaKardus.setText(hargaBarang.getHarga_kardus());
                        tvHargaKertas.setText(hargaBarang.getHarga_kertas());
                        tvHargaPlastik.setText(hargaBarang.getHarga_plastik());
                        tvHargaLogam.setText(hargaBarang.getHarga_logam());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}