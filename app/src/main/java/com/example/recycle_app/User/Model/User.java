package com.example.recycle_app.User.Model;


public class User {
    public String namauser,emailId,alamat,nohp;
    private String key;

    public User(){

    }
    public  User(String nama, String email, String alamat, String nohp){

        this.namauser = nama;
        this.nohp=nohp;
        this.alamat=alamat;
        this.emailId= email ;

    }
    public String getNama() {

        return namauser;

    }
    public String getNohp() {

        return nohp;

    }
    public String getAlamat() {

        return alamat;

    }
    public String getEmail() {

        return emailId;

    }

    public void setKey(String key) {
        this.key = key;
    }
}

