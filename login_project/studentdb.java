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
    //private static final String TABLE_NAME= "STUDENT";

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
                Student.MARKS + "INTEGER" +
                ")";
        db.execSQL(CREATE_STUDENT_TABLE);
        insert_record();
        //db = getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
        onCreate(db);
    }

    public void insert_record(){
        String query1="INSERT INTO Student VALUES (100,'abc','abc@gmail.com','abc','100',0,0);";
        String query2="INSERT INTO Student VALUES (101,'def','def@gmail.com','def','101',0,0);";
        String query3="INSERT INTO Student VALUES (102,'xyz','xyz@gmail.com','xyz','102',0,0);";
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
    }

    public void UpdateRecord(int usn,String name,String mail){
        db=getReadableDatabase();
        db=getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+ Student.TABLE_NAME + "WHERE" + Student.USN + "=" +usn,null);
        if(c.getCount()<=0)
        {
            String query="INSERT INTO Student VALUES (usn,name,mail);";
            c.close();
        }
        else{
            String query="UPDATE Student SET NAME="+name+", EMAIL="+mail+" WHERE USN="+usn+" ;";
            c.close();
        }

    }

    public Boolean VerifyStudent(String user,int psw){
        db=getReadableDatabase();
        String query="SELECT * FROM " + Student.TABLE_NAME + "WHERE" + Student.USN + "=" +psw+ "AND" + Student.NAME + "=" + user;
        Cursor c=db.rawQuery(query,null);
        if(c.getCount()>=0){
            //intetnt and move to next page -- login successful
            return true;
        }
        else{
            //invalid login
            return false;
        }
        
    }
}
