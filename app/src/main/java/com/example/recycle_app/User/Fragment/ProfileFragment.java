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
import com.example.recycle_app.User.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    private TextView txtNama, txtNoHp, txtAlamat, txtEmail;
    private DatabaseReference database;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;

    Button btnLogout, btKePengepul;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLogout = view.findViewById(R.id.logout);
        btKePengepul = view.findViewById(R.id.btKePengepul);

        btKePengepul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PengepulLoginActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView NamaTextView = (TextView) view.findViewById(R.id.getNama);
        final TextView NohpTextView = (TextView) view.findViewById(R.id.getNoHp);
        final TextView AlamatTextView = (TextView) view.findViewById(R.id.getAlamat);
        final TextView EmailTextView = (TextView) view.findViewById(R.id.getEmail);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String Nama = userProfile.namauser;
                    String Nohp = userProfile.nohp;
                    String Alamat = userProfile.alamat;
                    String Email = userProfile.emailId;

                    NamaTextView.setText(Nama);
                    NohpTextView.setText(Nohp);
                    AlamatTextView.setText(Alamat);
                    EmailTextView.setText(Email);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Sesuatu yang salah Terjadi", Toast.LENGTH_LONG).show();
            }
        });

        // inisialisasi fields
        txtNama = (TextView) view.findViewById(R.id.getNama);
        txtNoHp = (TextView) view.findViewById(R.id.getNoHp);
        txtAlamat = (TextView) view.findViewById(R.id.getAlamat);
        txtEmail = (TextView) view.findViewById(R.id.getEmail);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        return view;

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
