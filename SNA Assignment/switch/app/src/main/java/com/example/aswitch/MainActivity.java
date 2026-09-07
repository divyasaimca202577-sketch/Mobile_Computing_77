package com.example.aswitch;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgWifi;
    Switch switchWifi;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWifi = findViewById(R.id.imgWifi);
        switchWifi = findViewById(R.id.switchWifi);
        txtStatus = findViewById(R.id.txtStatus);

        switchWifi.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        txtStatus.setText("Wi-Fi Enabled");
                    } else {
                        txtStatus.setText("Wi-Fi Disabled");
                    }
                });
    }
}
