package com.noobdev.gilang.views.ViewPager;

//Tanggal : 18 mei 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.noobdev.gilang.R;
import com.noobdev.gilang.presenter.CustomPagerAdapter;
import com.noobdev.gilang.views.MainActivity;

import java.lang.reflect.Method;


public class MainSlider extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slider);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

   }

    public void mulai (View view) {
        Intent intent = new Intent(MainSlider.this, MainActivity.class);
        startActivity(intent);
    }
}
