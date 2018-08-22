package com.example.harshendra.simpledraw;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottomAppbar);
        setSupportActionBar(bottomAppBar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appBarSave:
                Toast.makeText(this, "Save clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarColor:
                Toast.makeText(this, "Color clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarClear:
                Toast.makeText(this, "Clear clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarShapes:
                Toast.makeText(this, "Shapes clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarUndo:
                Toast.makeText(this, "Undo clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        return true;
    }
}
