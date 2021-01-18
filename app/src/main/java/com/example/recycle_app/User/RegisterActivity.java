package com.example.recycle_app.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycle_app.User.Model.Pengguna;
import com.example.recycle_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etFirstName, etLastName, etEmail, etPassword, etAlamat, etNoHp;
    Button BtnRegister;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAlamat = findViewById(R.id.etAlamat);
        etNoHp = findViewById(R.id.etNoHp);

        BtnRegister = findViewById(R.id.btRegister);
        BtnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btRegister:
                BtnRegister();
                break;

        }
    }

    private void BtnRegister() {
        final String firstName = etFirstName.getText().toString().trim();
        final String lastName = etLastName.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String alamat = etAlamat.getText().toString().trim();
        final String noHp = etNoHp.getText().toString().trim();


        if (email.isEmpty()) {
            etEmail.setError("Please enter email id");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Please enter Password");
            etPassword.requestFocus();
            return;
        }
        if (firstName.isEmpty()) {
            etFirstName.setError("Please enter Nama");
            etFirstName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            etLastName.setError("Please enter Nama");
            etLastName.requestFocus();
            return;
        }
        if (alamat.isEmpty()) {
            etAlamat.setError("Please enter Alamat");
            etAlamat.requestFocus();
            return;
        }
        if (noHp.isEmpty()) {
            etNoHp.setError("Please enter No Hp");
            etNoHp.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Email anda tidak ditemukan");
            return;
        }

        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Pengguna user = new Pengguna(firstName, lastName, email, password, alamat, noHp);
                    FirebaseDatabase.getInstance().getReference("Pengguna").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "SignUp successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}