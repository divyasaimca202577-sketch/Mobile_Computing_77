package com.example.intents77;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);

        btnWebsite.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/divyasaimca202577-sketch")
            );

            startActivity(intent);
        });
    }
}