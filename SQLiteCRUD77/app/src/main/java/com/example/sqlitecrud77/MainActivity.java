package com.example.sqlitecrud77;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtCourse;

    Button btnInsert, btnView, btnUpdate, btnDelete;

    TextView txtResult;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtCourse = findViewById(R.id.edtCourse);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        txtResult = findViewById(R.id.txtResult);

        databaseHelper = new DatabaseHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {

            int id = Integer.parseInt(
                    edtId.getText().toString()
            );

            String name = edtName.getText().toString();

            String course = edtCourse.getText().toString();

            boolean result =
                    databaseHelper.insertStudent(
                            id,
                            name,
                            course
                    );

            if (result) {

                Toast.makeText(
                        this,
                        "Student Inserted",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        this,
                        "Insertion Failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // VIEW
        btnView.setOnClickListener(v -> {

            Cursor cursor =
                    databaseHelper.getAllStudents();

            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {

                data.append("ID: ")
                        .append(cursor.getInt(0))
                        .append("\n");

                data.append("Name: ")
                        .append(cursor.getString(1))
                        .append("\n");

                data.append("Course: ")
                        .append(cursor.getString(2))
                        .append("\n\n");
            }

            cursor.close();

            if (data.length() == 0) {

                txtResult.setText("No Students Found");

            } else {

                txtResult.setText(data.toString());
            }
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {

            int id = Integer.parseInt(
                    edtId.getText().toString()
            );

            String name = edtName.getText().toString();

            String course = edtCourse.getText().toString();

            boolean result =
                    databaseHelper.updateStudent(
                            id,
                            name,
                            course
                    );

            if (result) {

                Toast.makeText(
                        this,
                        "Student Updated",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        this,
                        "Update Failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {

            int id = Integer.parseInt(
                    edtId.getText().toString()
            );

            boolean result =
                    databaseHelper.deleteStudent(id);

            if (result) {

                Toast.makeText(
                        this,
                        "Student Deleted",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        this,
                        "Delete Failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}