package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);

        btnClick.setOnClickListener(v ->
                Toast.makeText(
                        MainActivity.this,
                        "Welcome to Android!",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}