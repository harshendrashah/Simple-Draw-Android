package com.example.harshendra.simpledraw;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationToolbar;
    SimpleDrawingView simpleDrawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationToolbar = findViewById(R.id.navigationToolbar);

        navigationToolbar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.appBarSave:
                        openCaptureDialog();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void openCaptureDialog() {

        Bitmap bmMyView = simpleDrawingView.getCanvasBitmap();

        //Save in file
        //String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        FileOutputStream outputStream;
        //File file = new File(extStorageDirectory, "test.jpg");

        try {
            outputStream = openFileOutput("drawing.jpg", Context.MODE_PRIVATE);
            bmMyView.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

            outputStream.flush();
            outputStream.close();
            Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

        //

        AlertDialog.Builder captureDialog = new AlertDialog.Builder(MainActivity.this);
        captureDialog.setTitle("Canvas Captured");

        ImageView bmImage = new ImageView(MainActivity.this);

        bmImage.setImageBitmap(bmMyView);

        LayoutParams bmImageLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        bmImage.setLayoutParams(bmImageLayoutParams);

        LinearLayout dialogLayout = new LinearLayout(MainActivity.this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);
        dialogLayout.addView(bmImage);
        captureDialog.setView(dialogLayout);

        captureDialog.setPositiveButton("OK", null);
        captureDialog.show();

    }

}
