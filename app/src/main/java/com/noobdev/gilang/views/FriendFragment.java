package com.noobdev.gilang.views;
//Tanggal : 12 agustus 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.noobdev.gilang.R;
import com.noobdev.gilang.presenter.AdapterMahasiswa;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FriendFragment extends Fragment {
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    AdapterMahasiswa adapterMahasiswa;
    List<friend> temanModel;
    Button btnTambah;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        btnTambah = view.findViewById(R.id.btntambah);
        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        //setup realm
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        temanModel = new ArrayList<>();
        temanModel = realmHelper.getAllMahasiswa();

        btnTambah.setOnClickListener(new View.OnClickListener()
                                     {
                                         @Override
                                         public void onClick(View v) {
                                             getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new FormFragment()).commit();
                                         }
                                     }
        );
        show();
        return view;
    }

    public void show() {
       adapterMahasiswa = new AdapterMahasiswa(this.getActivity(), temanModel);
        recyclerView.setAdapter(adapterMahasiswa);
    }
}
