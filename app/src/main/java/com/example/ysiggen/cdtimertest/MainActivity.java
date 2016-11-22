package com.example.ysiggen.cdtimertest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btStartTimer;
    Button btChangeTimer;
    TextView tVTimer;
    CountDownTimer cDTimer;
    long cDTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tVTimer = (TextView)findViewById(R.id.textViewTimer);
        tVTimer.setText("--");

        cDTime = 30000;
        cDTimer = new CountDownTimer(cDTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String time = String.valueOf(millisUntilFinished / 1000);
                tVTimer.setText(time);
            }

            @Override
            public void onFinish() {
                tVTimer.setText("//");
            }
        };

        btStartTimer = (Button)findViewById(R.id.btStartTimer);
        btStartTimer.setText("Start");
        btStartTimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cDTimer.start();
            }
        });

        btChangeTimer = (Button)findViewById(R.id.btChangeTimer);
        btChangeTimer.setText("Change");
        btChangeTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDTimer.cancel();
                cDTime = 20000;
                cDTimer = new CountDownTimer(cDTime, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String time = String.valueOf(millisUntilFinished / 1000);
                        tVTimer.setText(time);
                    }

                    @Override
                    public void onFinish() {
                        tVTimer.setText("{}");
                    }
                };
                cDTimer.start();
            }
        });
    }
}
