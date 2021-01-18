package com.example.recycle_app.Pengepul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.Pengepul.Model.ModelHargaBarang;
import com.example.recycle_app.R;
import com.example.recycle_app.User.Model.ModelJualBarang;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RincianTransaksiActivity extends AppCompatActivity {

    TextView tvNamaRinci, tvAlamatRinci, tvNoHpRinci;
    TextView tvHargaKertas, tvHargaPlastik, tvHargaLogam, tvHargaKaca, tvHargaAlmu, tvHargaKardus;
    TextView tvJmlKertas, tvJmlPlastik, tvJmlLogam, tvJmlKaca, tvJmlAlmu, tvJmlKardus;
    TextView tvTotalBarang, tvTotalHarga;
    Button btnProses;


    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    String id_transaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian_transaksi);

        tvHargaKertas = findViewById(R.id.tvHargaKertas);
        tvHargaPlastik = findViewById(R.id.tvHargaPlastik);
        tvHargaLogam = findViewById(R.id.tvHargaLogam);
        tvHargaKaca = findViewById(R.id.tvHargaKaca);
        tvHargaAlmu = findViewById(R.id.tvHargaAlmu);
        tvHargaKardus = findViewById(R.id.tvHargaKardus);

        tvJmlKertas = findViewById(R.id.tvJmlKertas);
        tvJmlPlastik = findViewById(R.id.tvJmlPlastik);
        tvJmlLogam = findViewById(R.id.tvJmlLogam);
        tvJmlKaca = findViewById(R.id.tvJmlKaca);
        tvJmlAlmu = findViewById(R.id.tvJmlAlmu);
        tvJmlKardus = findViewById(R.id.tvJmlKardus);

        tvNamaRinci = findViewById(R.id.tvNamaRinci);
        tvAlamatRinci = findViewById(R.id.tvAlamatRinci);
        tvNoHpRinci = findViewById(R.id.tvNoHpRinci);

        tvTotalBarang = findViewById(R.id.tvTotalBarang);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);

        btnProses = findViewById(R.id.btnProses);

        Bundle extras = getIntent().getExtras();
        id_transaksi = extras.getString("id_transaksi");

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();
        getdata();


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTransaksi();
                Toast.makeText(RincianTransaksiActivity.this, "Transaksi Telah Selesai", Toast.LENGTH_SHORT).show();
                Toast.makeText(RincianTransaksiActivity.this, "Terimakasih Kerjasamanya", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getdata() {

        getRefenence.child("Transaksi")
                .child(id_transaksi)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Mengambil daftar item dari database, setiap kali ada turunannya
                        ModelJualBarang modelJualBarang = snapshot.getValue(ModelJualBarang.class);
                        tvNamaRinci.setText(modelJualBarang.getNama());
                        tvAlamatRinci.setText(modelJualBarang.getAlamat());
                        tvNoHpRinci.setText(modelJualBarang.getNoHp());

                        tvHargaKertas.setText(modelJualBarang.getHargaKertas());
                        tvHargaPlastik.setText(modelJualBarang.getHargaPlastik());
                        tvHargaLogam.setText(modelJualBarang.getHargaAlmu());
                        tvHargaKaca.setText(modelJualBarang.getHargaKaca());
                        tvHargaAlmu.setText(modelJualBarang.getHargaAlmu());
                        tvHargaKardus.setText(modelJualBarang.getHargaKardus());

                        tvJmlKertas.setText(modelJualBarang.getJumlahKertas());
                        tvJmlPlastik.setText(modelJualBarang.getJumlahPlastik());
                        tvJmlLogam.setText(modelJualBarang.getJumlahLogam());
                        tvJmlKaca.setText(modelJualBarang.getJumlahKaca());
                        tvJmlAlmu.setText(modelJualBarang.getJumlahAlmu());
                        tvJmlKardus.setText(modelJualBarang.getJumlahKerdus());

                        tvTotalHarga.setText(modelJualBarang.getSubtotal());

                        Integer jumlahKertas = Integer.parseInt(modelJualBarang.getJumlahKertas());
                        Integer jumlahPlastik = Integer.parseInt(modelJualBarang.getJumlahPlastik());
                        Integer jumlahLogam = Integer.parseInt(modelJualBarang.getJumlahLogam());
                        Integer jumlahKaca = Integer.parseInt(modelJualBarang.getJumlahKaca());
                        Integer jumlahAlmu = Integer.parseInt(modelJualBarang.getJumlahAlmu());
                        Integer jumlahKardus = Integer.parseInt(modelJualBarang.getJumlahKerdus());
                        Integer subtotalBarang = jumlahKertas + jumlahPlastik + jumlahLogam + jumlahKaca + jumlahAlmu + jumlahKardus;

                        String totalBarang = String.valueOf(subtotalBarang);

                        tvTotalBarang.setText(totalBarang);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    //Proses Update data yang sudah ditentukan
    private void updateTransaksi(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Transaksi")
                .child(id_transaksi);

        reference.child("proses").setValue("Transaksi Selesai")
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(RincianTransaksiActivity.this, "Transaksi Berhasil" +id_transaksi, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}