package com.example.alertdialog77;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Welcome (Divyasai 77)");

                builder.setMessage("Welcome to Android Programming");

                builder.setPositiveButton("OK", null);

                builder.show();
            }
        });
    }
}