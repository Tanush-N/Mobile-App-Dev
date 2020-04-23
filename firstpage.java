package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        Button b1=(Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        final EditText un=(EditText) findViewById(R.id.editText6);
        final EditText pwd=(EditText) findViewById(R.id.editText7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
		        String u=un.getText().toString() ;
		        String p=pwd.getText().toString() ;
		        if(u=="sample" && p=="sample") {
                    Intent intent = new Intent(FirstPage.this, StudentOptionPage.class);
                    startActivity(intent);
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u=un.getText().toString() ;
                String p=pwd.getText().toString() ;
                if(u=="teacher" && p=="teacher") {
                    Intent intent = new Intent(FirstPage.this, TeacherOptionPage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
