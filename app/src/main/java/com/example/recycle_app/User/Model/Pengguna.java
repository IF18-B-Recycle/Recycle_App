package com.example.recycle_app.User.Model;

public class  Pengguna {
        public String etFirstName,etLastName,etEmail,etPassword;
        private String key;

    public Pengguna(){
        }

    public  Pengguna(String firstname, String lastname,String email , String pwd){
            this.etFirstName = firstname;
            this.etLastName= lastname ;
            this.etEmail= email ;
            this.etPassword = pwd;
    }

    public String getEtFirstName() {
        return etFirstName;
    }

    public void setEtFirstName(String etFirstName) {
        this.etFirstName = etFirstName;
    }

    public String getEtLastName() {
        return etLastName;
    }

    public void setEtLastName(String etLastName) {
        this.etLastName = etLastName;
    }

    public String getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(String etEmail) {
        this.etEmail = etEmail;
    }

    public String getEtPassword() {
        return etPassword;
    }

    public void setEtPassword(String etPassword) {
        this.etPassword = etPassword;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}



