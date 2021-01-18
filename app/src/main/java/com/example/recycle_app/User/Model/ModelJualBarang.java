package com.example.recycle_app.User.Model;

public class ModelJualBarang {
    private String HargaKertas, HargaPlastik, HargaLogam, HargaKaca, HargaAlmu, HargaKardus, JumlahKertas, JumlahPlastik, JumlahLogam, JumlahKaca, JumlahAlmu, JumlahKerdus;
    private String Nama, Alamat, NoHp, Subtotal,Proses,Longitude,Latitude;
    private String id_pengepul,id_pengguna, id_transaksi;

    public ModelJualBarang() {
    }

    public ModelJualBarang(String hargaKertas, String hargaPlastik, String hargaLogam, String hargaKaca, String hargaAlmu, String hargaKardus, String jumlahKertas, String jumlahPlastik, String jumlahLogam, String jumlahKaca, String jumlahAlmu, String jumlahKerdus, String nama, String alamat, String noHp, String subtotal, String proses, String longitude, String latitude, String id_pengepul, String id_pengguna, String id_transaksi) {
        HargaKertas = hargaKertas;
        HargaPlastik = hargaPlastik;
        HargaLogam = hargaLogam;
        HargaKaca = hargaKaca;
        HargaAlmu = hargaAlmu;
        HargaKardus = hargaKardus;
        JumlahKertas = jumlahKertas;
        JumlahPlastik = jumlahPlastik;
        JumlahLogam = jumlahLogam;
        JumlahKaca = jumlahKaca;
        JumlahAlmu = jumlahAlmu;
        JumlahKerdus = jumlahKerdus;
        Nama = nama;
        Alamat = alamat;
        NoHp = noHp;
        Subtotal = subtotal;
        Proses = proses;
        Longitude = longitude;
        Latitude = latitude;
        this.id_pengepul = id_pengepul;
        this.id_pengguna = id_pengguna;
        this.id_transaksi = id_transaksi;
    }

    public String getHargaKertas() {
        return HargaKertas;
    }

    public void setHargaKertas(String hargaKertas) {
        HargaKertas = hargaKertas;
    }

    public String getHargaPlastik() {
        return HargaPlastik;
    }

    public void setHargaPlastik(String hargaPlastik) {
        HargaPlastik = hargaPlastik;
    }

    public String getHargaLogam() {
        return HargaLogam;
    }

    public void setHargaLogam(String hargaLogam) {
        HargaLogam = hargaLogam;
    }

    public String getHargaKaca() {
        return HargaKaca;
    }

    public void setHargaKaca(String hargaKaca) {
        HargaKaca = hargaKaca;
    }

    public String getHargaAlmu() {
        return HargaAlmu;
    }

    public void setHargaAlmu(String hargaAlmu) {
        HargaAlmu = hargaAlmu;
    }

    public String getHargaKardus() {
        return HargaKardus;
    }

    public void setHargaKardus(String hargaKardus) {
        HargaKardus = hargaKardus;
    }

    public String getJumlahKertas() {
        return JumlahKertas;
    }

    public void setJumlahKertas(String jumlahKertas) {
        JumlahKertas = jumlahKertas;
    }

    public String getJumlahPlastik() {
        return JumlahPlastik;
    }

    public void setJumlahPlastik(String jumlahPlastik) {
        JumlahPlastik = jumlahPlastik;
    }

    public String getJumlahLogam() {
        return JumlahLogam;
    }

    public void setJumlahLogam(String jumlahLogam) {
        JumlahLogam = jumlahLogam;
    }

    public String getJumlahKaca() {
        return JumlahKaca;
    }

    public void setJumlahKaca(String jumlahKaca) {
        JumlahKaca = jumlahKaca;
    }

    public String getJumlahAlmu() {
        return JumlahAlmu;
    }

    public void setJumlahAlmu(String jumlahAlmu) {
        JumlahAlmu = jumlahAlmu;
    }

    public String getJumlahKerdus() {
        return JumlahKerdus;
    }

    public void setJumlahKerdus(String jumlahKerdus) {
        JumlahKerdus = jumlahKerdus;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getNoHp() {
        return NoHp;
    }

    public void setNoHp(String noHp) {
        NoHp = noHp;
    }

    public String getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(String subtotal) {
        Subtotal = subtotal;
    }

    public String getProses() {
        return Proses;
    }

    public void setProses(String proses) {
        Proses = proses;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getId_pengepul() {
        return id_pengepul;
    }

    public void setId_pengepul(String id_pengepul) {
        this.id_pengepul = id_pengepul;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
}
