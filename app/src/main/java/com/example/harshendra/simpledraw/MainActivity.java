package com.example.harshendra.simpledraw;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    ActionBar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottomAppbar);

        bottomAppBar.replaceMenu(R.menu.drawing_menu);

        //toolbar = getSupportActionBar();

        //bottomNavigationView = findViewById(R.id.navigationView);

    }
}
