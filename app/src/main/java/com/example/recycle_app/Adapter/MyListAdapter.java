package com.example.recycle_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_app.DetailActivity;
import com.example.recycle_app.Model.ItemData;
import com.example.recycle_app.R;

import java.util.List;

public class MyListAdapter extends RecyclerView.ViewHolder {

    public TextView tvNama;
    public TextView tvOwner;

    public MyListAdapter(@NonNull View itemView) {
        super(itemView);
        tvNama = itemView.findViewById(R.id.NamaTempat);
        tvOwner = itemView.findViewById(R.id.Owner);
    }


    public void bindToPerusahaan(ItemData itemData){
        tvNama.setText(itemData.nama_toko);
        tvOwner.setText(itemData.owner);
    }
}