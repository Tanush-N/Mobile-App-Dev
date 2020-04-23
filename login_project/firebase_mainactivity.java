package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button butt;
DatabaseReference reff;
Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        butt=(Button)findViewById(R.id.button);
        member=new Member();
        reff=FirebaseDatabase.getInstance().getReference().child("Member");
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b=Integer.parseInt(e2.getText().toString());
                member.setName(e1.getText().toString());
                member.getAge(b);

                reff.push().setValue(member);
                //Toast.makeText(datainsert.this,text:"data inserted",Toast.LENGTH_LONG).show();
            }


        });
    }
/*
    Toast.makeText(MainActivity.this,text:"success",Toast.LENGTH_LONG).show();
     Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    myRef.setValue("Hello, World!");
    */

}
