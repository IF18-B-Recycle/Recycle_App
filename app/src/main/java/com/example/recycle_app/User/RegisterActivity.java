package com.example.recycle_app.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    EditText etFirstName, etLastName, etEmail, etPassword;
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
        final String firstname = etFirstName.getText().toString().trim();
        final String lastname = etLastName.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String pwd = etPassword.getText().toString().trim();


        if (email.isEmpty()) {
            etEmail.setError("Please enter email id");
            etEmail.requestFocus();
            return;
        }

        if (pwd.isEmpty()) {
            etPassword.setError("Please enter Password");
            etPassword.requestFocus();
            return;
        }

        if (firstname.isEmpty()) {
            etFirstName.setError("Please enter Nama");
            etFirstName.requestFocus();
            return;
        }
        if (lastname.isEmpty()) {
            etLastName.setError("Please enter Nama");
            etLastName.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Email anda tidak ditemukan");
            return;
        }
        mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Pengguna user = new Pengguna(firstname, lastname, email, pwd);
                    FirebaseDatabase.getInstance().getReference("Pengguna").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "SignUp successful", Toast.LENGTH_LONG).show();
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
