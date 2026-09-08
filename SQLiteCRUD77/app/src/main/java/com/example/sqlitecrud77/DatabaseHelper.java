package com.example.sqlitecrud77;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "StudentDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE student (" +
                        "id INTEGER PRIMARY KEY, " +
                        "name TEXT, " +
                        "course TEXT)"
        );
    }

    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public boolean insertStudent(
            int id,
            String name,
            String course) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id", id);
        values.put("name", name);
        values.put("course", course);

        long result = db.insert(
                "student",
                null,
                values
        );

        return result != -1;
    }

    public Cursor getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM student",
                null
        );
    }

    public boolean updateStudent(
            int id,
            String name,
            String course) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("course", course);

        int result = db.update(
                "student",
                values,
                "id=?",
                new String[]{String.valueOf(id)}
        );

        return result > 0;
    }

    public boolean deleteStudent(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(
                "student",
                "id=?",
                new String[]{String.valueOf(id)}
        );

        return result > 0;
    }
}