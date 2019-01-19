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
    int h,m,s,totaltime;
    Button newtime, pause, resume;
    int pauseclicked=0;
    int resumeclicked=0;
    CountDownTimer c;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);

        newtime=(Button)findViewById(R.id.button3);
        pause=(Button)findViewById(R.id.button4);
        resume=(Button)findViewById(R.id.button5);

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
        totaltime=h*3600+m*60+s;

            c=new CountDownTimer(totaltime*1000, 1000) {
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


            };
            // what happens when clicking "new time" button
            newtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseclicked++;
                c.cancel();
                Intent back=new Intent(countdown.this,MainActivity.class);
                startActivity(back);
            }
            });

            //what happens when clicking "pause"
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.cancel();
            }
        });

        //what happens when clicking "resume"
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int newtime;
                String newhour=hour.getText().toString();
                int newh=Integer.parseInt(newhour);
                String newminute=minute.getText().toString();
                int newm=Integer.parseInt(newminute);
                String newseconds=seconds.getText().toString();
                int news=Integer.parseInt(newseconds);
                newtime=newh*3000+newm*60+news;

                c=new CountDownTimer(newtime*1000, 1000) {
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
        });


        c.start();

    }

}
