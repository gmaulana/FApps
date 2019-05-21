package com.noobdev.gilang.views;

//Tanggal : 18 mei 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.noobdev.gilang.R;
import com.noobdev.gilang.presenter.CustomPagerAdapter;


public class MainActivity extends AppCompatActivity {
//        BottomNavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bn_main);
            bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            Fragment selecteFragment = null;

            switch (Item.getItemId()){
                case R.id.home_menu:
                    selecteFragment = new HomeFragment();
                    break;
                case R.id.me:
                    selecteFragment = new ProfileFragment();
                    break;
                case R.id.friend:
                    selecteFragment = new FriendFragment();
                    break;
                case R.id.contact:
                    selecteFragment = new ContactFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,
                    selecteFragment).commit();
            return true;
        }
    };


//    private boolean loadFragment(Fragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fl_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
//
//    // method listener untuk logika pemilihan
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment fragment = null;
//        switch (item.getItemId()){
//            case R.id.home_menu:
//                fragment = new HomeFragment();
//                break;
//            case R.id.me:
//                fragment = new ProfileFragment();
//                break;
//            case R.id.friend:
//                fragment = new FriendFragment();
//                break;
//            case R.id.contact:
//                fragment = new ContactFragment();
//                break;
//        }
//        return loadFragment(fragment);
//    }
}
