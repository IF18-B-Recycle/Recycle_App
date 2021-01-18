package com.example.recycle_app.User.Fragment;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.Pengepul.PengepulLoginActivity;
import com.example.recycle_app.User.LoginActivity;
import com.example.recycle_app.R;
import com.example.recycle_app.User.Model.Pengguna;
import com.example.recycle_app.User.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    TextView NamaTextView,NohpTextView, AlamatTextView, EmailTextView;

    DatabaseReference reference;
    String userID;

    FirebaseUser user;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    Button btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLogout = view.findViewById(R.id.logout);

        NamaTextView = view.findViewById(R.id.getNama);
        NohpTextView = view.findViewById(R.id.getNoHp);
        AlamatTextView = view.findViewById(R.id.getAlamat);
        EmailTextView = view.findViewById(R.id.getEmail);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference();

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();

        getUserdata();

        return view;
    }

    private void getUserdata(){
        reference.child("Pengguna").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Pengguna pengguna  = snapshot.getValue(Pengguna.class);
                if (pengguna != null) {
                    NamaTextView.setText(pengguna.getEtFirstName()+pengguna.getEtLastName());
                    NohpTextView.setText("88888888");
                    AlamatTextView.setText("alamat nya belum ada");
                    EmailTextView.setText(pengguna.getEtEmail());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Sesuatu yang salah Terjadi", Toast.LENGTH_LONG).show();
            }
        });
    }


    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, ProfileFragment.class);
    }

    private void showDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Apakah Anda ingin Logout?")
                .setMessage("Yakin ingin Logout?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intToMain = new Intent(getContext(), LoginActivity.class);
                        startActivity(intToMain);
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

}
