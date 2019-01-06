package com.example.timer;

import android.content.Intent;
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
        hours=(EditText) findViewById(R.id.editText2);
        minutes=(EditText) findViewById(R.id.editText3);
        seconds=(EditText) findViewById(R.id.editText4);
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                userhours=hours.getText().toString();
                userminutes=minutes.getText().toString();
                userseconds=seconds.getText().toString();
                if (userhours.equals("")||userminutes.equals("")||userseconds==""){
                    Toast.makeText(getApplicationContext(),"Please enter a valid time",Toast.LENGTH_SHORT).show();
                }else if (userhours.equals("0")&&userminutes.equals("0")&&userseconds.equals("0")){
                    Toast.makeText(getApplicationContext(),"You cannot set timer to 0", Toast.LENGTH_SHORT).show();
                }else {
                    //String value="tester";
                    Intent count = new Intent(MainActivity.this, countdown.class);
                    count.putExtra("key", userhours);
                    count.putExtra("key2", userminutes);
                    count.putExtra("key3", userseconds);
                    startActivity(count);
                }
            }


        });

    }
}
