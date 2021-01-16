package com.example.recycle_app.Pengepul.Model;

public class Pengepul {
    public String firstName,lastName,email,password,nama_toko,id_pengepul;

    public Pengepul() {
    }

    public Pengepul(String firstName, String lastName, String email, String password, String nama_toko, String id_pengepul) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.nama_toko = nama_toko;
        this.id_pengepul = id_pengepul;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getId_pengepul() {
        return id_pengepul;
    }

    public void setId_pengepul(String id_pengepul) {
        this.id_pengepul = id_pengepul;
    }

}
