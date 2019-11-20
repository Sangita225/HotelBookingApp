package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import static com.example.hotelbooking.R.*;

public class ProgressBar extends AppCompatActivity{

    ProgressBar progressbaractivity;
    int progressStatus=0;
    TextView textview;
     Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_progress_bar);

       // progressbaractivity = findViewById(R.id.prbiwindow);

        textview=findViewById(R.id.txtview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressbaractivity.setProgress(progressStatus);
                           // textview.setText(progressStatus + "/" + progressbaractivity.getMax());
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
