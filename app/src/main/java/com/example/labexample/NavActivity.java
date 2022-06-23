package com.example.labexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout =findViewById(R.id.drawer);
        navView = findViewById(R.id.nav_view);
//        setting toolbar
        setSupportActionBar(toolbar);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.close, R.string.open);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.db:
                        Intent i = new Intent(getApplicationContext(),SqLiteActivity.class);
                        startActivity(i);
                        break;
                    case R.id.action:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new DateTimePickerFrag(),"Date Time Frag").commitAllowingStateLoss();
                         break;
                }

                return true;
            }
        });

    }
}
