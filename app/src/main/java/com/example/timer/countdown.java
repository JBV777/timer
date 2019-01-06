package com.example.timer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.widget.Toast;

public class countdown extends AppCompatActivity{
    String runhour,runminutes,runseconds;
    int h,m,s;
    Button reset, newtime, pause;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);

        reset=(Button)findViewById(R.id.button);
        newtime=(Button)findViewById(R.id.button3);
        pause=(Button)findViewById(R.id.button4);

        Bundle extras=getIntent().getExtras();
        final TextView hour=findViewById(R.id.hours);
        final TextView minute=findViewById(R.id.min);
        final TextView seconds=findViewById(R.id.sec);
        runhour=extras.getString("key");
        h=Integer.parseInt(runhour);
        hour.setText(String.valueOf(h));
        runminutes=extras.getString("key2");
        m=Integer.parseInt(runminutes);
        minute.setText(runminutes);
        runseconds=extras.getString("key3");
        s=Integer.parseInt(runseconds);
        seconds.setText(String.valueOf(s));
        int totaltime=h*3600+m*60+s;

        newtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(countdown.this,MainActivity.class);
                startActivity(back);
            }
        });

            new CountDownTimer(totaltime*1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    s--;
                    seconds.setText(String.valueOf(s));
                    minute.setText(String.valueOf(m));
                    hour.setText(String.valueOf(h));
                    if (s==0 && m!=0) {
                        m--;
                        s=60;
                    }else if (s==0 && m==0 && h!=0){
                        h--;
                        m=59;
                        s=60;
                    }

                }

                public void onFinish() {
                    Toast.makeText(getApplicationContext(),"Time is up",Toast.LENGTH_SHORT).show();
                }
            }.start();

    }

}
