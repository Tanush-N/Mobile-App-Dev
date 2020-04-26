//after adding student table
/*
package com.example.myquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myquiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="MyQuiz.db";
    private static final int DATABASE_VERSION=2;
    private  SQLiteDatabase db;
    private static final String TABLE= "STUDENT";

    public QuizDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_CREATE_QUESTIONS_TABLE="CREATE TABLE "+
                QuestionsTable.TABLE_NAME + " ( "+
                QuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER " +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
	final String CREATE_STUDENT_TABLE = "CREATE TABLE " +
                TABLE + " (
                USN INTEGER PRIMARY KEY AUTOINCREMENT,
                NAME TEXT,
                EMAIL TEXT,
                USERNAME TEXT,
                PASSWORD TEXT,
                ATTEMPTS INTEGER,
                MARKS INTEGER
                )";
        db.execSQL(CREATE_STUDENT_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
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
        Cursor c=db.rawQuery("SELECT * FROM "+ TABLE + "WHERE" + USN + "=" +usn,null);
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
        String query="SELECT * FROM " + TABLE + "WHERE" + USN + "=" +psw+ "AND" + NAME + "=" + user;
        Cursor c=db.rawQuery(query,null);
        if(c.getCount()>=0){
            //intetnt and move to next page -- login successful
            return true;
        }
        else{
            //invalid login
            return false;
        }

    private void fillQuestionsTable(){
        Question q1=new Question("Who invented python programming language?","Guido van Rossum","Charles Babbage","James Gosling",1                );
        addQuestion(q1);
        Question q2=new Question("Which is the largest river in the world?","Amazon","Nile","Ganga",2);
        addQuestion(q2);
        Question q3=new Question("How many islands are there in the group of lakshadweep?","34","35","36",3);
        addQuestion(q3);
        Question q4=new Question("The Gulf of Mannar is situated on the banks of which river?","Ganga","Yamuna","Brahmaputra",3);
        addQuestion(q4);
        Question q5=new Question("How many main() functions can we have in a c program?","only 1","more than 1","no need of main() function",1);
        addQuestion(q5);
        Question q6=new Question("2+2*2/2=?","6","4","8",2);
        addQuestion(q6);
        Question q7=new Question("9%2*0?","4.5","0","1",2);
        addQuestion(q7);
        Question q8=new Question("_________ method cannot be overridden?","private","final","static",3);
        addQuestion(q8);
        Question q9=new Question("If log(1/8) to the base x = -3/2, then x=?","-4","4","1/4",2);
        addQuestion(q9);
        Question q10=new Question("In java arrays are _________.","object reference","object","data type",2);
        addQuestion(q10);
    }
    private  void addQuestion(Question question){
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }
    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question>questionList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME,null);

        if(c.moveToFirst()){
            do{
                Question question =new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
}

 */
package com.example.myquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myquiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="MyQuiz.db";
    private static final int DATABASE_VERSION=2;
    private SQLiteDatabase db;

    public QuizDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_CREATE_QUESTIONS_TABLE="CREATE TABLE "+
                QuestionsTable.TABLE_NAME + " ( "+
                QuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER " +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1=new Question("Who invented python programming language?","Guido van Rossum","Charles Babbage","James Gosling",1                );
        addQuestion(q1);
        Question q2=new Question("Which is the largest river in the world?","Amazon","Nile","Ganga",2);
        addQuestion(q2);
        Question q3=new Question("How many islands are there in the group of lakshadweep?","34","35","36",3);
        addQuestion(q3);
        Question q4=new Question("The Gulf of Mannar is situated on the banks of which river?","Ganga","Yamuna","Brahmaputra",3);
        addQuestion(q4);
        Question q5=new Question("How many main() functions can we have in a c program?","only 1","more than 1","no need of main() function",1);
        addQuestion(q5);
        Question q6=new Question("2+2*2/2=?","6","4","8",2);
        addQuestion(q6);
        Question q7=new Question("9%2*0?","4.5","0","1",2);
        addQuestion(q7);
        Question q8=new Question("_________ method cannot be overridden?","private","final","static",3);
        addQuestion(q8);
        Question q9=new Question("If log(1/8) to the base x = -3/2, then x=?","-4","4","1/4",2);
        addQuestion(q9);
        Question q10=new Question("In java arrays are _________.","object reference","object","data type",2);
        addQuestion(q10);
    }
    private void addQuestion(Question question){
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }
    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question>questionList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME,null);

        if(c.moveToFirst()){
            do{
                Question question =new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
