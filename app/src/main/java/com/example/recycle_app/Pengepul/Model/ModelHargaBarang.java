package com.example.recycle_app.Pengepul.Model;

public class ModelHargaBarang {
    public String harga_aluminium,harga_botol_kaca,harga_kardus,harga_kertas,harga_logam,harga_plastik,id_pengepul;

    public ModelHargaBarang() {
    }

    public ModelHargaBarang(String harga_aluminium, String harga_botol_kaca, String harga_kardus, String harga_kertas, String harga_logam, String harga_plastik, String id_pengepul) {
        this.harga_aluminium = harga_aluminium;
        this.harga_botol_kaca = harga_botol_kaca;
        this.harga_kardus = harga_kardus;
        this.harga_kertas = harga_kertas;
        this.harga_logam = harga_logam;
        this.harga_plastik = harga_plastik;
        this.id_pengepul = id_pengepul;
    }

    public String getHarga_aluminium() {
        return harga_aluminium;
    }

    public void setHarga_aluminium(String harga_aluminium) {
        this.harga_aluminium = harga_aluminium;
    }

    public String getHarga_botol_kaca() {
        return harga_botol_kaca;
    }

    public void setHarga_botol_kaca(String harga_botol_kaca) {
        this.harga_botol_kaca = harga_botol_kaca;
    }

    public String getHarga_kardus() {
        return harga_kardus;
    }

    public void setHarga_kardus(String harga_kardus) {
        this.harga_kardus = harga_kardus;
    }

    public String getHarga_kertas() {
        return harga_kertas;
    }

    public void setHarga_kertas(String harga_kertas) {
        this.harga_kertas = harga_kertas;
    }

    public String getHarga_logam() {
        return harga_logam;
    }

    public void setHarga_logam(String harga_logam) {
        this.harga_logam = harga_logam;
    }

    public String getHarga_plastik() {
        return harga_plastik;
    }

    public void setHarga_plastik(String harga_plastik) {
        this.harga_plastik = harga_plastik;
    }

    public String getId_pengepul() {
        return id_pengepul;
    }

    public void setId_pengepul(String id_pengepul) {
        this.id_pengepul = id_pengepul;
    }
}
