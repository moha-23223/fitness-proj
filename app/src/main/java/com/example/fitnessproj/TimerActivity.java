package com.example.fitnessproj;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TimerActivity extends AppCompatActivity {
    CountDownTimer timer;
    ProgressBar progressBar;
    int time=60;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        progressBar= findViewById(R.id.progress_bar);
        text=findViewById(R.id.textView4);
        timer= new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                time--;
                String t="";
                if (time<10)
                    t="00:0";
                else
                    t="00:";
                text.setText(t+ String.valueOf(time));
                progressBar.setProgress(time);
            }

            public void onFinish() {

            }
        };
    }
    public void onPauseClick(View v)
    {
        timer.cancel();
    }
    public void onStopClick(View v)
    {
        timer.cancel();
        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time--;
                String t="";
                if (time<10)
                    t="00:0";
                else
                    t="00:";
                text.setText(t+ String.valueOf(time));
                progressBar.setProgress(time);
            }

            @Override
            public void onFinish() {

            }
        };
        text.setText("60:00");
        time=60;
        progressBar.setProgress(time);
    }
    public void onStartClick(View v)
    {
        timer.start();
    }
}