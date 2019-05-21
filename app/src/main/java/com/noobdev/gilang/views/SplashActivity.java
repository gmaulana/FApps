package com.noobdev.gilang.views;

//Tanggal : 18 mei 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.noobdev.gilang.R;
import com.noobdev.gilang.views.ViewPager.MainSlider;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading=2000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent i =new Intent(SplashActivity.this, MainSlider.class);
                startActivity(i);
                finish();

            }
        },waktu_loading);
    }
}
