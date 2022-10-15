package com.unsri.userappgithub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {
    private ArrayList<Kage> listKage;

    public RecyclerViewAdapter(ArrayList<Kage> list){
        this.listKage = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Kage kage = listKage.get(position);
        holder.imgPhoto.setImageResource(kage.getFotoKage());
        holder.kageNama.setText(kage.getNamaKage());
        holder.kageJapan.setText(kage.getJapanKage());
        holder.kageTingkatan.setText(kage.getTingkatanKage());
    }

    @Override
    public int getItemCount() {
        return listKage.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView imgPhoto;
        TextView kageNama, kageJapan, kageTingkatan;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.view_image_kage);
            kageNama = itemView.findViewById(R.id.view_nama_kage);
            kageJapan = itemView.findViewById(R.id.view_japan_nama);
            kageTingkatan = itemView.findViewById(R.id.view_tingkatan_kage);
        }
    }
}
