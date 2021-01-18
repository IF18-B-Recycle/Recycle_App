package com.example.recycle_app.Pengepul.PengepulFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recycle_app.Pengepul.Model.Pengepul;
import com.example.recycle_app.R;
import com.example.recycle_app.User.Fragment.ProfileFragment;
import com.example.recycle_app.User.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class PengepulProfileFragment extends Fragment {

    TextView tvNamaPengepul, tvEmailPengepul, tvNamaToko;

    Button btKeUser;
    FirebaseAuth auth;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengepul_profile, container, false);

        auth = FirebaseAuth.getInstance();

        tvNamaPengepul = view.findViewById(R.id.tvNamaPengepul);
        tvEmailPengepul = view.findViewById(R.id.tvEmailPengepul);
        tvNamaToko = view.findViewById(R.id.tvNamaToko);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();
        getdata();

        btKeUser = view.findViewById(R.id.btLogout);
        btKeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void getdata(){
        getRefenence.child("Pengepul").addChildEventListener(new ChildEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Pengepul pengepul = dataSnapshot.getValue(Pengepul.class);
                tvNamaPengepul.setText(pengepul.getFirstName());
                tvEmailPengepul.setText(pengepul.getEmail());
                tvNamaToko.setText(pengepul.getNama_toko());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MyListData", "Error: ", error.toException());
            }
        });
    }
}