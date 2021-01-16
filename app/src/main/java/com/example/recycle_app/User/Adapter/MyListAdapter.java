package com.example.recycle_app.User.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_app.User.Model.ItemData;
import com.example.recycle_app.R;

public class MyListAdapter extends RecyclerView.ViewHolder {

    public TextView tvNama;
    public TextView tvOwner;

    public MyListAdapter(@NonNull View itemView) {
        super(itemView);
        tvNama = itemView.findViewById(R.id.NamaTempat);
        tvOwner = itemView.findViewById(R.id.Owner);
    }


    public void bindToToko(ItemData itemData){
        tvNama.setText(itemData.nama_toko);
        tvOwner.setText(itemData.owner);
    }
}