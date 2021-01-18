package com.example.recycle_app.Pengepul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.recycle_app.R;

public class RincianTransaksiActivity extends AppCompatActivity {
    TextView tvNamaRinci, tvAlamatRinci, tvNoHpRinci;
    TextView tvHargaKertas, tvHargaPlastik, tvHargaLogam, tvHargaKaca, tvHargaAlmu, tvHargaKardus;
    TextView tvJmlKertas, tvJmlPlastik, tvJmlLogam, tvJmlKaca, tvJmlAlmu, tvJmlKardus;
    TextView tvTotalBarang, tvTotalHarga;
    Button btnProses;

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

    }
}