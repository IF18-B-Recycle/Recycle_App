package com.example.recycle_app.Model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ModelMyOrder {
    public String proses;
    public String id_transaksi;
    public String id_pengguna;
    public String id_pengepul;
    public String nama_barang;
    public String jumlah_barang;
    public String sub_total;
    public String tanggal;
    public String alamat;

    public ModelMyOrder() {
    }

    public ModelMyOrder(String proses, String id_transaksi, String id_pengguna, String id_pengepul, String nama_barang, String jumlah_barang, String sub_total, String tanggal, String alamat) {
        this.proses = proses;
        this.id_transaksi = id_transaksi;
        this.id_pengguna = id_pengguna;
        this.id_pengepul = id_pengepul;
        this.nama_barang = nama_barang;
        this.jumlah_barang = jumlah_barang;
        this.sub_total = sub_total;
        this.tanggal = tanggal;
        this.alamat = alamat;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("proses", proses);
        result.put("id_transaksi", id_transaksi);
        result.put("id_pengguna", id_pengguna);
        result.put("id_pengepul", id_pengepul);
        result.put("nama_barang", nama_barang);
        result.put("jumlah_barang", jumlah_barang);
        result.put("sub_total", sub_total);
        result.put("tanggal", tanggal);
        result.put("alamat", alamat);
        return result;
    }
}
