package com.example.recycle_app.Pengepul.PengepulFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycle_app.Pengepul.Model.ModelHargaBarang;
import com.example.recycle_app.R;
import com.example.recycle_app.User.ActivityJualBarang;
import com.example.recycle_app.User.Model.ModelJualBarang;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class PengepulBarangFragment extends Fragment {

    EditText etHargaKertas,etHargaAluminium,etHargaBotolKaca,etHargaKardus,etHargaLogam,etHargaPlastik;
    Button btnHargaBarang;

    FirebaseAuth auth;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengepul_barang, container, false);

        etHargaKertas = view.findViewById(R.id.etHargaKertas);
        etHargaAluminium = view.findViewById(R.id.etHargaAluminium);
        etHargaBotolKaca = view.findViewById(R.id.etHargaBotolKaca);
        etHargaKardus = view.findViewById(R.id.etHargaKardus);
        etHargaLogam = view.findViewById(R.id.etHargaLogam);
        etHargaPlastik = view.findViewById(R.id.etHargaPlastik);

        btnHargaBarang = view.findViewById(R.id.btnHargaBarang);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        //Untuk atuhentikasi user yang login
        auth = FirebaseAuth.getInstance();

        btnHargaBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hargaBarang();
            }
        });

        return view;
    }

    private void hargaBarang(){

        //Mendapatkan UserID dari pengguna yang Terautentikasi
        String getUserID = auth.getCurrentUser().getUid();

        //Mendapatkan Instance dari Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference getReference;

        //Menyimpan Data yang diinputkan User kedalam Variable
        String getHarga_kertas = etHargaKertas.getText().toString();
        String getHarga_aluminium = etHargaAluminium.getText().toString();
        String getHarga_botol_kaca = etHargaBotolKaca.getText().toString();
        String getHarga_kardus = etHargaKardus.getText().toString();
        String getHarga_logam = etHargaLogam.getText().toString();
        String getHarga_plastik = etHargaPlastik.getText().toString();
        String getId_pengepul = getUserID;

        getReference = database.getReference(); // Mendapatkan Referensi dari Database

        getReference.child("Barang").child(getUserID)
                .setValue(new ModelHargaBarang(getHarga_kertas,getHarga_aluminium,getHarga_botol_kaca,getHarga_kardus,getHarga_logam,getHarga_plastik,getId_pengepul))
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}