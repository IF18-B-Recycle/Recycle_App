package com.example.recycle_app.User.Model;

public class  Pengguna {
    public String FirstName, LastName, Email, Password, Alamat, NoHp;
    private String key;

    public Pengguna() {
    }

    public Pengguna(String firstName, String lastName, String email, String password, String alamat, String noHp) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        Alamat = alamat;
        NoHp = noHp;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}