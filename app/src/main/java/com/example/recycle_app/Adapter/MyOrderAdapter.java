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

    public TextView txt_proses, txt_nama, txt_alamat, txt_noHp,txt_subTotal;
    public RelativeLayout relativeLayout;
    public MyOrderAdapter(@NonNull View itemView) {
        super(itemView);
        txt_proses = itemView.findViewById(R.id.txt_proses);
        txt_nama = itemView.findViewById(R.id.txt_nama);
        txt_alamat = itemView.findViewById(R.id.txt_alamat);
        txt_noHp = itemView.findViewById(R.id.txt_noHp);
        txt_subTotal = itemView.findViewById(R.id.txt_subTotal);
        relativeLayout = itemView.findViewById(R.id.item_myorder);
    }

    public void bindtoItemOrder(ModelMyOrder modelMyOrder){
        txt_proses.setText(modelMyOrder.proses);
        txt_nama.setText(modelMyOrder.nama);
        txt_alamat.setText(modelMyOrder.alamat);
        txt_noHp.setText(modelMyOrder.noHp);
        txt_subTotal.setText(modelMyOrder.subtotal);

    }
}
