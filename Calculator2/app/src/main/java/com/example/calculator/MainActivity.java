package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        txtMessage = findViewById(R.id.txtMessage);

        btnShow.setOnClickListener(view -> {

//            txtMessage.setText("Hello Divyasai!");
            txtMessage.setTextColor(
                    ContextCompat.getColor(this, R.color.black)
            );

        });
    }
}