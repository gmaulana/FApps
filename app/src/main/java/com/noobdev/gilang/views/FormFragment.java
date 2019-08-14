package com.noobdev.gilang.views;
//Tanggal : 12 agustus 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.noobdev.gilang.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FormFragment extends Fragment implements View.OnClickListener{
    Button btnSimpan, btnTampil;
    EditText nim, nama, kelas, telepon, email, sosmed;
    String sNama, sNim, sKelas, sTelepon, sEmail, sSosmed;
    Realm realm;
    RealmHelper realmHelper;
    friend temanModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_fragment, container, false);

        //Inisialisasi
        btnSimpan = view.findViewById(R.id.btnSimpan);
        btnTampil = view.findViewById(R.id.btnTampil);
        nim = view.findViewById(R.id.nim);
        nama = view.findViewById(R.id.nama);
        kelas = view.findViewById(R.id.kelas);
        telepon = view.findViewById(R.id.telepon);
        email = view.findViewById(R.id.email);
        sosmed = view.findViewById(R.id.sosmed);


        //Set up Realm
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = nim.getText().toString();
            sNama = nama.getText().toString();
            sKelas = kelas.getText().toString();
            sEmail = email.getText().toString();
            sTelepon = telepon.getText().toString();
            sSosmed = sosmed.getText().toString();

            if (!sNim.equals("") && !sNama.isEmpty() && !sKelas.isEmpty() && !sEmail.isEmpty() && !sTelepon.isEmpty() && !sSosmed.isEmpty() ){
                temanModel = new friend();
                temanModel.setNim(sNim);
                temanModel.setNama(sNama);
                temanModel.setKelas(sKelas);
                temanModel.setEmail(sEmail);
                temanModel.setTelepon(sTelepon);
                temanModel.setSosmed(sSosmed);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(temanModel);

                Toast.makeText(this.getActivity(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
                kelas.setText("");
                email.setText("");
                telepon.setText("");
                sosmed.setText("");

            }else {
                Toast.makeText(this.getActivity(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,
                    new FriendFragment()).commit();
        }

    }

}
