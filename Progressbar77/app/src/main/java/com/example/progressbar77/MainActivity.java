package com.example.progressbar77;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnStart;
    TextView txtProgress;

    int progress = 0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);
        txtProgress = findViewById(R.id.txtProgress);

        btnStart.setOnClickListener(v -> {

            progress = 0;

            progressBar.setProgress(0);

            txtProgress.setText("0%");

            handler.postDelayed(new Runnable() {

                @Override
                public void run() {

                    if (progress <= 100) {

                        progressBar.setProgress(progress);

                        txtProgress.setText(progress + "%");

                        if (progress == 100) {

                            txtProgress.setText("Process Completed");

                            return;
                        }

                        progress = progress + 10;

                        handler.postDelayed(this, 500);
                    }
                }

            }, 500);
        });
    }
}