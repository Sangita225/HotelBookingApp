package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class ProgressBar extends AppCompatActivity {

    private ProgressBar progressbar;
    private int progressStatus=0;
    TextView textview;
    private Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        //progressbar = findViewById(R.id.prbcyclic);
        textview=findViewById(R.id.txtview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressbar.setProgress(progressStatus);
                           // textview.setText(progressStatus + "/" + progressbar.getMax());
                        }
                    });
                    try {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {

                    }
                }

                }

        }).start();
    }
}
