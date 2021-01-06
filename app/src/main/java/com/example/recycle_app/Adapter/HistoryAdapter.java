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

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyHolder> {
    private Context context;

    ArrayList<String> mIdTransaksi = new ArrayList<>();
    ArrayList<String> mTanggalPesan = new ArrayList<>();
    ArrayList<String> mTanggaljemput = new ArrayList<>();
    ArrayList<String> mNama = new ArrayList<>();
    ArrayList<String> mPengepul = new ArrayList<>();
    ArrayList<String> mBarang = new ArrayList<>();
    ArrayList<String> mJumlahBarang = new ArrayList<>();
    ArrayList<String> mSubTotal = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();

    public HistoryAdapter(Context context, ArrayList<String> mIdTransaksi, ArrayList<String> mTanggalPesan, ArrayList<String> mTanggaljemput,
                          ArrayList<String> mNama, ArrayList<String> mPengepul, ArrayList<String> mBarang,
                          ArrayList<String> mJumlahBarang, ArrayList<String> mSubTotal, ArrayList<String> mAlamat) {
        this.context = context;
        this.mIdTransaksi = mIdTransaksi;
        this.mTanggalPesan = mTanggalPesan;
        this.mTanggaljemput = mTanggaljemput;
        this.mNama = mNama;
        this.mPengepul = mPengepul;
        this.mBarang = mBarang;
        this.mJumlahBarang = mJumlahBarang;
        this.mSubTotal = mSubTotal;
        this.mAlamat = mAlamat;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyHolder holder, int position) {
        holder.txt_idTransaksi.setText(mIdTransaksi.get(position));
        holder.txt_tanggal_pesan.setText(mTanggalPesan.get(position));
        holder.txt_tanggal_jemput.setText(mTanggaljemput.get(position));
        holder.txt_nama.setText(mNama.get(position));
        holder.txt_pengepul.setText(mPengepul.get(position));
        holder.txt_barang.setText(mBarang.get(position));
        holder.txt_jumlahBarang.setText(mJumlahBarang.get(position));
        holder.txt_subTotal.setText(mSubTotal.get(position));
        holder.txt_alamat.setText(mAlamat.get(position));
    }

    @Override
    public int getItemCount() {
        return mIdTransaksi.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        RelativeLayout recyclerview_item;
        TextView txt_idTransaksi, txt_tanggal_pesan, txt_tanggal_jemput, txt_nama, txt_pengepul, txt_barang, txt_jumlahBarang, txt_subTotal, txt_alamat;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //koneksi ke itemview
            recyclerview_item = itemView.findViewById(R.id.item_myorder);
            txt_idTransaksi = itemView.findViewById(R.id.txt_idTransaksi);
            txt_tanggal_pesan = itemView.findViewById(R.id.txt_tanggal_pesan);
            txt_tanggal_jemput = itemView.findViewById(R.id.txt_tanggal_jemput);
            txt_nama = itemView.findViewById(R.id.txt_nama);
            txt_pengepul = itemView.findViewById(R.id.txt_pengepul);
            txt_barang = itemView.findViewById(R.id.txt_barang);
            txt_jumlahBarang = itemView.findViewById(R.id.txt_jumlahBarang);
            txt_subTotal = itemView.findViewById(R.id.txt_subTotal);
            txt_alamat = itemView.findViewById(R.id.txt_alamat);

        }
    }
}
