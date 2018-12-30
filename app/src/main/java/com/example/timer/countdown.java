package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;

public class countdown extends AppCompatActivity{
    String runhour,runminutes,runseconds;
    int h,m,s;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);
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
                    seconds.setText("time's up");
                }
            }.start();

    }

}
