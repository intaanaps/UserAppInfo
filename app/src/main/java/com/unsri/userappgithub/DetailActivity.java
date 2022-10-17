package com.unsri.userappgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView foto_detail = findViewById(R.id.foto_detail);
        TextView detail_name = findViewById(R.id.detail_name);
        TextView detail_japan = findViewById(R.id.detail_japan);
        TextView detail_tingkatan = findViewById(R.id.detail_tingkatan);


        Kage kage = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (kage != null){
            Glide.with(this)
                    .load(kage.getFotoKage())
                    .into(foto_detail);
            detail_name.setText(kage.getNamaKage());
            detail_japan.setText(kage.getJapanKage());
            detail_tingkatan.setText(kage.getTingkatanKage());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Kage");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}