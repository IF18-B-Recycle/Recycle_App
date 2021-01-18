package com.example.recycle_app.User.Model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ItemData {
    public String nama_toko;
    public String firstName;
    public String id_pengepul;

    public ItemData() {

    }

    public ItemData(String nama_toko, String firstName) {
        this.nama_toko = nama_toko;
        this.firstName = firstName;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama_toko", nama_toko);
        result.put("firstName", firstName);
        result.put("id_pengepul", id_pengepul);
        return result;
    }
}