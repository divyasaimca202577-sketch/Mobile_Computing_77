package com.example.sharedpreferences77;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSave, btnDisplay;
    TextView txtResult;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnSave = findViewById(R.id.btnSave);
        btnDisplay = findViewById(R.id.btnDisplay);
        txtResult = findViewById(R.id.txtResult);

        sharedPreferences =
                getSharedPreferences("StudentData", MODE_PRIVATE);

        btnSave.setOnClickListener(v -> {

            String name = edtName.getText().toString();

            SharedPreferences.Editor editor =
                    sharedPreferences.edit();

            editor.putString("student_name", name);

            editor.apply();
        });

        btnDisplay.setOnClickListener(v -> {

            String name =
                    sharedPreferences.getString(
                            "student_name",
                            "No Data Found"
                    );

            txtResult.setText("Student Name: " + name);
        });
    }
}