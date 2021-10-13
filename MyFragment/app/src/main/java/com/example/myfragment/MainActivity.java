package com.example.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //Deklarasi buttom navigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Menu()).commit();
        }

        bottomNavigation = findViewById(R.id.bottom_navigation);

        //Menjadikan fragment Home() sebagai fragment default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();

        //Memberikan action pada button
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Membuat objek baru dari fragment
                Fragment selectedFragment = null;

                //Digunakan untuk menentukan apa yang dipilih oleh user sesuai dengan item yang ada di file bottom_navigatipn.xml
                switch (item.getItemId()) {
                    //Case berdasarkan item yang ada di file bottom_navigation.xml
                    case R.id.nav_home:
                        selectedFragment = new Home();
                        break;
                    case R.id.nav_menu_minuman:
                        selectedFragment = new Menu();
                        break;
                    case R.id.nav_akun:
                        //Memanggil fragment yang disimpan dalam objek selectedFragment
                        selectedFragment = new Account();
                        break;
                }
                //Memanggil fungsi untuk mengubah setiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }
}