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

    public String getHargaKertas() {
        return hargaKertas;
    }

    public void setHargaKertas(String hargaKertas) {
        this.hargaKertas = hargaKertas;
    }

    public String getHargaPlastik() {
        return hargaPlastik;
    }

    public void setHargaPlastik(String hargaPlastik) {
        this.hargaPlastik = hargaPlastik;
    }

    public String getHargaLogam() {
        return hargaLogam;
    }

    public void setHargaLogam(String hargaLogam) {
        this.hargaLogam = hargaLogam;
    }

    public String getHargaKaca() {
        return hargaKaca;
    }

    public void setHargaKaca(String hargaKaca) {
        this.hargaKaca = hargaKaca;
    }

    public String getHargaAlmu() {
        return hargaAlmu;
    }

    public void setHargaAlmu(String hargaAlmu) {
        this.hargaAlmu = hargaAlmu;
    }

    public String getHargaKardus() {
        return hargaKardus;
    }

    public void setHargaKardus(String hargaKardus) {
        this.hargaKardus = hargaKardus;
    }

    public String getJumlahKertas() {
        return jumlahKertas;
    }

    public void setJumlahKertas(String jumlahKertas) {
        this.jumlahKertas = jumlahKertas;
    }

    public String getJumlahPlastik() {
        return jumlahPlastik;
    }

    public void setJumlahPlastik(String jumlahPlastik) {
        this.jumlahPlastik = jumlahPlastik;
    }

    public String getJumlahLogam() {
        return jumlahLogam;
    }

    public void setJumlahLogam(String jumlahLogam) {
        this.jumlahLogam = jumlahLogam;
    }

    public String getJumlahKaca() {
        return jumlahKaca;
    }

    public void setJumlahKaca(String jumlahKaca) {
        this.jumlahKaca = jumlahKaca;
    }

    public String getJumlahAlmu() {
        return jumlahAlmu;
    }

    public void setJumlahAlmu(String jumlahAlmu) {
        this.jumlahAlmu = jumlahAlmu;
    }

    public String getJumlahKerdus() {
        return jumlahKerdus;
    }

    public void setJumlahKerdus(String jumlahKerdus) {
        this.jumlahKerdus = jumlahKerdus;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getProses() {
        return proses;
    }

    public void setProses(String proses) {
        this.proses = proses;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
}
