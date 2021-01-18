package com.example.recycle_app.User.Model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ModelMyOrder {
    public String hargaKertas, hargaPlastik, hargaLogam, hargaKaca, hargaAlmu, hargaKardus, jumlahKertas, jumlahPlastik, jumlahLogam, jumlahKaca, jumlahAlmu, jumlahKerdus;
    public String nama, alamat, noHp, subtotal,proses,longitude,latitude,key, id_transaksi;

    public ModelMyOrder() {
    }

    public ModelMyOrder(String hargaKertas, String hargaPlastik, String hargaLogam, String hargaKaca, String hargaAlmu, String hargaKardus, String jumlahKertas, String jumlahPlastik, String jumlahLogam, String jumlahKaca, String jumlahAlmu, String jumlahKerdus, String nama, String alamat, String noHp, String subtotal, String proses, String longitude, String latitude, String key, String id_transaksi) {
        this.hargaKertas = hargaKertas;
        this.hargaPlastik = hargaPlastik;
        this.hargaLogam = hargaLogam;
        this.hargaKaca = hargaKaca;
        this.hargaAlmu = hargaAlmu;
        this.hargaKardus = hargaKardus;
        this.jumlahKertas = jumlahKertas;
        this.jumlahPlastik = jumlahPlastik;
        this.jumlahLogam = jumlahLogam;
        this.jumlahKaca = jumlahKaca;
        this.jumlahAlmu = jumlahAlmu;
        this.jumlahKerdus = jumlahKerdus;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.subtotal = subtotal;
        this.proses = proses;
        this.longitude = longitude;
        this.latitude = latitude;
        this.key = key;
        this.id_transaksi = id_transaksi;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("proses", proses);
        result.put("hargaKertas", hargaKertas);
        result.put("hargaLogam", hargaLogam);
        result.put("hargaPlastik",hargaPlastik);
        result.put("hargaKaca",hargaKaca);
        result.put("hargaAlmu",hargaAlmu);
        result.put("hargaKardus",hargaKardus);
        result.put("jumlahKertas",jumlahKertas);
        result.put("jumlahLogam",jumlahLogam);
        result.put("jumlahPlastik",jumlahPlastik);
        result.put("jumlahKaca",jumlahKaca);
        result.put("jumlahAlmu",jumlahAlmu);
        result.put("jumlahKardus",jumlahKerdus);
        result.put("nama",nama);
        result.put("alamat",alamat);
        result.put("longitude",longitude);
        result.put("latitude",latitude);
        result.put("noHp",noHp);
        result.put("subtotal",subtotal);
        result.put("key",key);
        result.put("id_transaksi",id_transaksi);
        return result;
    }
}
