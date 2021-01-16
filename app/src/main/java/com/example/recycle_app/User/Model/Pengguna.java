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
        public String getFirstName() {

            return etFirstName;

        }

        public String getEmail() {

            return etEmail;

        }

        public void setKey(String key) {
            this.key = key;
        }
    }



