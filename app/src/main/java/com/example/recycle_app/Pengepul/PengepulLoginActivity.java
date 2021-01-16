package com.example.recycle_app.Pengepul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.R;
import com.example.recycle_app.User.LoginActivity;
import com.example.recycle_app.User.MainActivity;
import com.example.recycle_app.User.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PengepulLoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengepul_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btLogin);
        tvSignUp = findViewById(R.id.txtBelumAkun);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(PengepulLoginActivity.this, PengepulRegisterActivity.class);
                startActivity(intSignUp);
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(PengepulLoginActivity.this, " Berhasil Login ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PengepulLoginActivity.this, "Tolong Login Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pwd = etPassword.getText().toString();
                if (email.isEmpty()) {
                    etEmail.setError("Please enter email id");
                    etEmail.requestFocus();
                } else if (pwd.isEmpty()) {
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(PengepulLoginActivity.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(PengepulLoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(PengepulLoginActivity.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intToHome = new Intent(PengepulLoginActivity.this, PengepulMainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(PengepulLoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}