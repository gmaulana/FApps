package com.noobdev.gilang.views;
//Tanggal : 21 mei 2019
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

import com.noobdev.gilang.R;
import com.noobdev.gilang.model.friend;
import com.noobdev.gilang.presenter.AdapterMahasiswa;

import java.util.ArrayList;

public class FriendFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterMahasiswa adapter;
    private ArrayList<friend> mhsArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);



        addData();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        adapter = new AdapterMahasiswa(mhsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }

    private void addData() {
        mhsArrayList = new ArrayList<>();
        mhsArrayList.add(new friend("Gilang Maulana", "101734644", "08976363554"));
        mhsArrayList.add(new friend("Udins", "101173643", "098973737474"));
        mhsArrayList.add(new friend("Iskandar", "10117564643", "09474664"));
        mhsArrayList.add(new friend("Jaenab", "10116474646", "085675746"));
        mhsArrayList.add(new friend("Sartono", "1011648555", "103947846"));
        mhsArrayList.add(new friend("Junaedi", "1011756644", "086757464"));
        mhsArrayList.add(new friend("Nugraha", "1011649485", "0327374758"));
        mhsArrayList.add(new friend("Adi", "10116354764", "039476364"));
        mhsArrayList.add(new friend("Maulana Kohar", "1011644947", "083663535"));
        mhsArrayList.add(new friend("Ryan ucup", "1011610485", "0898457474"));
        mhsArrayList.add(new friend("Wisnu", "1011837548", "0857574875"));
        mhsArrayList.add(new friend("Dudin", "1011746474", "086452532534"));
    }
}
