package com.noobdev.gilang.presenter;
//Tanggal : 12 agustus 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noobdev.gilang.R;
import com.noobdev.gilang.views.DetailFragment;
import com.noobdev.gilang.views.friend;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.MahasiswaViewHolder> {

    private List<friend> modelTeman;
    Context context;


    public AdapterMahasiswa(Context context,List<friend> modelTeman) {
        this.modelTeman = modelTeman;
        this.context = context;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_item, parent, false);



        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {

        final friend model = modelTeman.get(position);

        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama().toString());
        holder.kelas.setText(model.getKelas().toString());
        holder.telepon.setText(model.getTelepon().toString());
        holder.email.setText(model.getEmail().toString());
        holder.sosmed.setText(model.getSosmed().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data = new Bundle();
                data.putInt("id",model.getId());
                data.putString("nama", model.getNama());
                data.putString("nim", model.getNim());
                data.putString("kelas", model.getKelas());
                data.putString("telepon", model.getTelepon());
                data.putString("email", model.getEmail());
                data.putString("sosmed", model.getSosmed());
                Fragment fragment = new DetailFragment();
                fragment.setArguments(data);


                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return  modelTeman.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView nim, nama, kelas, telepon, email, sosmed;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            telepon = itemView.findViewById(R.id.tvTelepon);
            email = itemView.findViewById(R.id.tvEmail);
            sosmed = itemView.findViewById(R.id.tvSosmed);
        }
    }
}


