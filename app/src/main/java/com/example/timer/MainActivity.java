package com.example.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prompt);
        //links button with "Start timer" button on prompt
        Button start=(Button) findViewById(R.id.button2);
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.countdown);
            }


        });

    }
}
