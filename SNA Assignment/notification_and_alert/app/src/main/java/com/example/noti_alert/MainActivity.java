package com.example.noti_alert;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNotification;
    Button btnAlert;

    String CHANNEL_ID = "my_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnNotification = findViewById(R.id.btnNotification);
        btnAlert = findViewById(R.id.btnAlert);

        createNotificationChannel();

        btnNotification.setOnClickListener(v -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(
                            this,
                            new String[]{Manifest.permission.POST_NOTIFICATIONS},
                            100
                    );

                    return;
                }
            }

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(
                                    android.R.drawable.ic_dialog_info
                            )
                            .setContentTitle("Mobile Computing Lab")
                            .setContentText(
                                    "This is a notification message."
                            )
                            .setPriority(
                                    NotificationCompat.PRIORITY_DEFAULT
                            )
                            .setAutoCancel(true);

            NotificationManagerCompat notificationManager =
                    NotificationManagerCompat.from(this);

            notificationManager.notify(1, builder.build());
        });

        btnAlert.setOnClickListener(v -> {

            new AlertDialog.Builder(this)
                    .setTitle("Alert Box")
                    .setMessage(
                            "Are you sure you want to continue?"
                    )
                    .setPositiveButton("YES", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNegativeButton("NO", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .show();
        });
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            "My Notification Channel",
                            NotificationManager.IMPORTANCE_DEFAULT
                    );

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);
        }
    }
}