package com.example.recycle_app.User.Model;

public class ModelHargaBarang {
    private String harga_aluminium,harga_botol_kaca,harga_kerdus,harga_kertas,harga_logam,harga_plastik;

    public ModelHargaBarang() {
    }

    public ModelHargaBarang(String harga_aluminium, String harga_botol_kaca, String harga_kerdus, String harga_kertas, String harga_logam, String harga_plastik) {
        this.harga_aluminium = harga_aluminium;
        this.harga_botol_kaca = harga_botol_kaca;
        this.harga_kerdus = harga_kerdus;
        this.harga_kertas = harga_kertas;
        this.harga_logam = harga_logam;
        this.harga_plastik = harga_plastik;
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

    public String getHarga_kerdus() {
        return harga_kerdus;
    }

    public void setHarga_kerdus(String harga_kerdus) {
        this.harga_kerdus = harga_kerdus;
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
}
