package com.example.registerationform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etMobile;
    private RadioGroup rgGender;
    private CheckBox cbAndroid, cbJava;
    private Spinner spinnerCourse;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        rgGender = findViewById(R.id.rgGender);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbJava = findViewById(R.id.cbJava);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });
    }

    private void registerStudent() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedGenderId);
            gender = selectedRadioButton.getText().toString();
        }

        StringBuilder skills = new StringBuilder();
        if (cbAndroid.isChecked()) {
            skills.append("Android ");
        }
        if (cbJava.isChecked()) {
            skills.append("Java ");
        }

        String selectedCourse = spinnerCourse.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || mobile.isEmpty()) {
            Toast.makeText(this, "Please fill in all text fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedCourse.equals("Select Course")) {
            Toast.makeText(this, "Please select a valid course", Toast.LENGTH_SHORT).show();
            return;
        }

        String displayMsg = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Mobile: " + mobile + "\n" +
                "Gender: " + (gender.isEmpty() ? "None" : gender) + "\n" +
                "Skills: " + (skills.length() == 0 ? "None" : skills.toString().trim()) + "\n" +
                "Course: " + selectedCourse;

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Registration Successful")
                .setMessage(displayMsg)
                .setPositiveButton("OK", null)
                .show();
    }
}