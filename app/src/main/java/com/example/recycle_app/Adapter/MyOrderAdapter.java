package com.example.recycle_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_app.R;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder> {

    private Context context;

    ArrayList<String> mKonfrimasi = new ArrayList<>();
    ArrayList<String> mTanggalTransaksi = new ArrayList<>();
    ArrayList<String> mIdTransaksi = new ArrayList<>();
    ArrayList<String> mNama = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();
    ArrayList<String> mTotalHarga = new ArrayList<>();

    public MyOrderAdapter(Context context, ArrayList<String> mKonfrimasi, ArrayList<String> mTanggalTransaksi, ArrayList<String> mIdTransaksi, ArrayList<String> mNama, ArrayList<String> mAlamat, ArrayList<String> mTotalHarga) {
        this.context = context;
        this.mKonfrimasi = mKonfrimasi;
        this.mTanggalTransaksi = mTanggalTransaksi;
        this.mIdTransaksi = mIdTransaksi;
        this.mNama = mNama;
        this.mAlamat = mAlamat;
        this.mTotalHarga = mTotalHarga;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myorder,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.txt_konfirmasi.setText(mKonfrimasi.get(position));
        holder.txt_tanggal_transaksi.setText(mTanggalTransaksi.get(position));
        holder.txt_idTransaki.setText(mIdTransaksi.get(position));
        holder.txt_nama.setText(mNama.get(position));
        holder.txt_alamat.setText(mAlamat.get(position));
        holder.txt_totalHarga.setText(mTotalHarga.get(position));
    }

    @Override
    public int getItemCount() {
        return mKonfrimasi.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        //views item_recycler_view
        RelativeLayout recyclerview_item;
        TextView txt_konfirmasi, txt_tanggal_transaksi, txt_idTransaki, txt_nama, txt_alamat,txt_totalHarga;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //koneksi ke itemview
            recyclerview_item = itemView.findViewById(R.id.item_myorder);
            txt_konfirmasi = itemView.findViewById(R.id.txt_konfirmasi);
            txt_tanggal_transaksi = itemView.findViewById(R.id.txt_tanggal_transaksi);
            txt_idTransaki = itemView.findViewById(R.id.txt_idTransaki);
            txt_nama = itemView.findViewById(R.id.txt_nama);
            txt_alamat = itemView.findViewById(R.id.txt_alamat);
            txt_totalHarga = itemView.findViewById(R.id.txt_totalHarga);
        }
    }


}
