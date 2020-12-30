package com.example.recycle_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_app.Model.ItemData;
import com.example.recycle_app.Model.ModelMyOrder;
import com.example.recycle_app.R;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.ViewHolder {

    public TextView proses, id_transaksi, id_pengguna, id_pengepul,nama_barang, jumlah_barang, sub_total, tanggal, alamat;

    public MyOrderAdapter(@NonNull View itemView) {
        super(itemView);
        proses = itemView.findViewById(R.id.txt_proses);
        id_transaksi = itemView.findViewById(R.id.txt_idTransaki);
        id_pengguna = itemView.findViewById(R.id.txt_nama);
        id_pengepul = itemView.findViewById(R.id.txt_pengepul);
        nama_barang = itemView.findViewById(R.id.txt_barang);
        jumlah_barang = itemView.findViewById(R.id.txt_jumlahBarang);
        sub_total = itemView.findViewById(R.id.txt_subTotal);
        tanggal = itemView.findViewById(R.id.txt_tanggalTransaksi);
        alamat = itemView.findViewById(R.id.txt_alamat);
    }

    public void bindtoItemOrder(ModelMyOrder modelMyOrder){
        proses.setText(modelMyOrder.proses);
        id_transaksi.setText(modelMyOrder.id_transaksi);
        id_pengguna.setText(modelMyOrder.id_pengguna);
        id_pengepul.setText(modelMyOrder.id_pengepul);
        nama_barang.setText(modelMyOrder.nama_barang);
        jumlah_barang.setText(modelMyOrder.jumlah_barang);
        sub_total.setText(modelMyOrder.sub_total);
        tanggal.setText(modelMyOrder.tanggal);
        alamat.setText(modelMyOrder.alamat);
    }
    }
