package com.noobdev.gilang.views;

//Tanggal : 20 mei 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.noobdev.gilang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button btnphone = (Button) view.findViewById(R.id.call);
        Button btnige = (Button) view.findViewById(R.id.igeh);
        Button btnfec = (Button) view.findViewById(R.id.faceb);
        Button btnmails = (Button) view.findViewById(R.id.mails);
        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.gils);
                String dial = "tel:" + phone;
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
                startActivity(intent);
            }
        });
        btnfec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlface ="https://www.facebook.com/kein.hiroyama";
                Intent openface=new Intent(Intent.ACTION_VIEW);
                openface.setData(Uri.parse(urlface));
                startActivity(openface);
            }
        });
        btnmails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailsIntent = new Intent(Intent.ACTION_SENDTO);
                mailsIntent.putExtra(Intent.EXTRA_SUBJECT, "Isi Sesuai Kebutuhan Anda");
                mailsIntent.putExtra(Intent.EXTRA_TEXT, "Assallammualikum");
                mailsIntent.setData(Uri.parse("mailto:gmaulana9969@gmail.com"));
                startActivity(Intent.createChooser(mailsIntent, "Choose App"));
            }
        });
        btnige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urligeh ="https://www.instagram.com/gilangmau_/";
                Intent openige=new Intent(Intent.ACTION_VIEW);
                openige.setData(Uri.parse(urligeh));
                startActivity(openige);
            }
        });
        return view;
    }
}
