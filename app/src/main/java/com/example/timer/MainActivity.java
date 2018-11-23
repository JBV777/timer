package com.example.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
public class MainActivity extends AppCompatActivity {
    EditText hours, minutes, seconds;
    String userhours,userminutes,userseconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prompt);
        //links button with "Start timer" button on prompt
        Button start=(Button) findViewById(R.id.button2);
        hours=findViewById(R.id.editText2);
        userhours=hours.getText().toString();
        minutes=findViewById(R.id.editText3);
        userminutes=minutes.getText().toString();
        seconds=findViewById(R.id.editText4);
        userseconds=seconds.getText().toString();
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //setContentView(R.layout.countdown);
                Toast.makeText(MainActivity.this,userhours,Toast.LENGTH_SHORT).show();
            }


        });

    }
}
