package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t;
    EditText num1;
    EditText num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView)findViewById(R.id.textView);
        num1 = (EditText)findViewById(R.id.editText);
        num2 = (EditText)findViewById(R.id.editText2);
        Button add = (Button)findViewById(R.id.button);
        Button sub = (Button)findViewById(R.id.button2);
        Button mul = (Button)findViewById(R.id.button3);
        Button div = (Button) findViewById(R.id.button4);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());

        switch (v.getId()){
            case R.id.button:
                t.setText(String.valueOf(n1+n2));
                break;
            case R.id.button2:
                t.setText(String.valueOf(n1-n2));
                break;
            case R.id.button3:
                t.setText(String.valueOf(n1*n2));
                break;
            case R.id.button4:
                if(n2==0)
                    t.setText("0 division error");
                else
                    t.setText(String.valueOf(n1/n2));
                break;

        }
    }
}
