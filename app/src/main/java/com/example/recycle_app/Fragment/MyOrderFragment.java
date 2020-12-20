package com.example.recycle_app.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycle_app.Adapter.MyOrderAdapter;
import com.example.recycle_app.R;

import java.util.ArrayList;

public class MyOrderFragment extends Fragment {

    ArrayList<String> mKonfrimasi = new ArrayList<>();
    ArrayList<String> mTanggalTransaksi = new ArrayList<>();
    ArrayList<String> mIdTransaksi = new ArrayList<>();
    ArrayList<String> mNama = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();
    ArrayList<String> mTotalHarga = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        mKonfrimasi.add("Belum Di Accept");
        mTanggalTransaksi.add("18/12/2020");
        mIdTransaksi.add("00001");
        mNama.add("Luky Rafi");
        mAlamat.add("Pekuncen");
        mTotalHarga.add("Rp. 10.000");

        mKonfrimasi.add("Belum Di Accept");
        mTanggalTransaksi.add("18/12/2020");
        mIdTransaksi.add("00002");
        mNama.add("Galih Prasetya");
        mAlamat.add("Purwokerto");
        mTotalHarga.add("Rp. 10.000");

        mKonfrimasi.add("Belum Di Accept");
        mTanggalTransaksi.add("18/12/2020");
        mIdTransaksi.add("00003");
        mNama.add("Awal Rafi");
        mAlamat.add("Purwokerto");
        mTotalHarga.add("Rp. 10.000");

        mKonfrimasi.add("Belum Di Accept");
        mTanggalTransaksi.add("18/12/2020");
        mIdTransaksi.add("00004");
        mNama.add("Melinia");
        mAlamat.add("Cilacap");
        mTotalHarga.add("Rp. 10.000");

        mKonfrimasi.add("Belum Di Accept");
        mTanggalTransaksi.add("18/12/2020");
        mIdTransaksi.add("00005");
        mNama.add("Faiz Nofal");
        mAlamat.add("Purwokerto");
        mTotalHarga.add("Rp. 10.000");

        //koneksikan dengan adapter
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        MyOrderAdapter adapter = new MyOrderAdapter(getContext(), mKonfrimasi, mTanggalTransaksi, mIdTransaksi, mNama, mAlamat, mTotalHarga);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }
}