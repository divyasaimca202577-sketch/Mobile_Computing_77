package com.example.filehandling77_new;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtRollNo;
    Button btnSave, btnRead;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtRollNo = findViewById(R.id.edtRollNo);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        txtResult = findViewById(R.id.txtResult);

        btnSave.setOnClickListener(v -> {

            String name = edtName.getText().toString();
            String rollNo = edtRollNo.getText().toString();

            String data = "Student Name: " + name +
                    "\nRoll No: " + rollNo;

            try {

                FileOutputStream fos =
                        openFileOutput("student.txt", MODE_PRIVATE);

                fos.write(data.getBytes());

                fos.close();

                Toast.makeText(
                        MainActivity.this,
                        "Data Saved Successfully",
                        Toast.LENGTH_SHORT
                ).show();

            } catch (Exception e) {

                e.printStackTrace();

            }
        });

        btnRead.setOnClickListener(v -> {

            try {

                FileInputStream fis =
                        openFileInput("student.txt");

                StringBuilder data = new StringBuilder();

                int ch;

                while ((ch = fis.read()) != -1) {
                    data.append((char) ch);
                }

                fis.close();

                txtResult.setText(data.toString());

            } catch (Exception e) {

                txtResult.setText("No data found");

            }
        });
    }
}