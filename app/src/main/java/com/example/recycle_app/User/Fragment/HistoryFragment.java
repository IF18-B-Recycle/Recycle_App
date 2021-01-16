package com.example.recycle_app.User.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycle_app.User.Adapter.HistoryAdapter;
import com.example.recycle_app.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    ArrayList<String> mIdTransaksi = new ArrayList<>();
    ArrayList<String> mTanggalPesan = new ArrayList<>();
    ArrayList<String> mTanggaljemput = new ArrayList<>();
    ArrayList<String> mNama = new ArrayList<>();
    ArrayList<String> mPengepul = new ArrayList<>();
    ArrayList<String> mBarang = new ArrayList<>();
    ArrayList<String> mJumlahBarang = new ArrayList<>();
    ArrayList<String> mSubTotal = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_history, container, false);
        mIdTransaksi.add("000001");
        mTanggalPesan.add("18/12/2020");
        mTanggaljemput.add("20/12/2020");
        mNama.add("Luky Rafi");
        mPengepul.add("Toko 1");
        mBarang.add("Kertas");
        mJumlahBarang.add("2");
        mSubTotal.add("Rp. 40.000");
        mAlamat.add("Pekuncen");

        mIdTransaksi.add("000002");
        mTanggalPesan.add("21/12/2020");
        mTanggaljemput.add("23/12/2020");
        mNama.add("Galih");
        mPengepul.add("Toko 2");
        mBarang.add("Plastik");
        mJumlahBarang.add("1");
        mSubTotal.add("Rp. 30.000");
        mAlamat.add("Purwokerto");

        mIdTransaksi.add("000003");
        mTanggalPesan.add("10/12/2020");
        mTanggaljemput.add("12/12/2020");
        mNama.add("melinia");
        mPengepul.add("Toko 3");
        mBarang.add("Logam");
        mJumlahBarang.add("3");
        mSubTotal.add("Rp. 10.000");
        mAlamat.add("Purwokerto");

        mIdTransaksi.add("000004");
        mTanggalPesan.add("18/12/2020");
        mTanggaljemput.add("20/12/2020");
        mNama.add("Faiz");
        mPengepul.add("Toko 4");
        mBarang.add("Botol Beling");
        mJumlahBarang.add("2");
        mSubTotal.add("Rp. 15.000");
        mAlamat.add("Purwokerto");

        mIdTransaksi.add("000005");
        mTanggalPesan.add("12/12/2020");
        mTanggaljemput.add("14/12/2020");
        mNama.add("Awal");
        mPengepul.add("Toko 5");
        mBarang.add("Elektronik Rusak");
        mJumlahBarang.add("4");
        mSubTotal.add("Rp. 25.000");
        mAlamat.add("Purwokerto");



        //koneksikan dengan adapter
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        HistoryAdapter adapter = new HistoryAdapter(getContext(), mIdTransaksi, mTanggalPesan, mTanggaljemput, mNama,
                mPengepul, mBarang, mJumlahBarang, mSubTotal, mAlamat);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }
}