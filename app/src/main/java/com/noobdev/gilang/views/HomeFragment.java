package com.noobdev.gilang.views;

//Tanggal : 21 mei 2019
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
import android.widget.TextView;

import com.noobdev.gilang.R;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnna = view.findViewById(R.id.button_logoutMain);


        TextView nama = view.findViewById(R.id.tv_namaMain);
        nama.setText(Preferences.getLoggedInUser(getActivity().getBaseContext()));

        btnna.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new
                        Intent(getActivity(),LoginActivity.class));
                getActivity().finish();
            }
    });
        return view;
    }

}
