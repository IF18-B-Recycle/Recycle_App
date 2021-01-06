package com.example.recycle_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button btnJualBarang;
    ImageView ivImage;
    TextView tvnamaTempat;
    TextView tvOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImage = (ImageView)findViewById(R.id.ivImage);
        tvnamaTempat = (TextView)findViewById(R.id.tvnamaTempat);
        tvOwner = (TextView)findViewById(R.id.tvOwner);

        btnJualBarang = (Button)findViewById(R.id.btnJualBarang);
        btnJualBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityJualBarang.class);
                startActivity(intent);
            }
        });
    }
}