package com.example.myawesomequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myawesomequiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String CREATE_STUDENT_TABLE = "CREATE TABLE " +
                Student.TABLE_NAME + " ( " +
                Student.USN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student.NAME + " TEXT, " +
                Student.EMAIL + " TEXT, " +
                Student.USERNAME + " TEXT, " +
                Student.PASSWORD + " TEXT, " +
                Student.ATTEMPTS + " INTEGER " +
                ")";
        db.execSQL(CREATE_STUDENT_TABLE);
        db = getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
        onCreate(db);
    }
}
