package com.unsri.userappgithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKage;
    private ArrayList<Kage> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKage = findViewById(R.id.rv_kage);
        rvKage.setHasFixedSize(true);

        list.addAll(getListKage());
        showRecyclerList();

        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvKage.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvKage.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    public ArrayList<Kage> getListKage(){
        String[] dataNamaKage = getResources().getStringArray(R.array.data_namaKage);
        String[] dataJapanKage = getResources().getStringArray(R.array.data_japanKage);
        String[] dataTingkatanKage = getResources().getStringArray(R.array.data_tingkatanKage);
        TypedArray dataFotoKage = getResources().obtainTypedArray(R.array.data_fotoKage);

        ArrayList<Kage> listKage = new ArrayList<>();
        for (int i = 0; i < dataNamaKage.length; i++){
            Kage kage = new Kage();
            kage.setNamaKage(dataNamaKage[i]);
            kage.setJapanKage(dataJapanKage[i]);
            kage.setTingkatanKage(dataTingkatanKage[i]);
            kage.setFotoKage(dataFotoKage.getResourceId(i, -1));

            listKage.add(kage);
        }

        return listKage;
    }

    private void showRecyclerList(){
        rvKage.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter RecyclerViewAdapter = new RecyclerViewAdapter(list);
        rvKage.setAdapter(RecyclerViewAdapter);

        RecyclerViewAdapter.setOnItemClickCallback(new RecyclerViewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kage kage) {
                Intent moveIntent = new Intent( MainActivity.this, DetailActivity.class);
                moveIntent.putExtra(DetailActivity.ITEM_EXTRA, kage);
                startActivity(moveIntent);
            }
        });
    }
}