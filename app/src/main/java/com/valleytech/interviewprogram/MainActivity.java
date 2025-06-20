package com.valleytech.interviewprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.valleytech.interviewprogram.looper.WorkedThread;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler mainHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(android.os.Message msg) {
                // Handle messages from the worker thread here
                System.out.println("Message received in MainActivity: " + msg.obj);
            }
        };

        WorkedThread workerThread = new WorkedThread("WorkerThread", mainHandler);
        workerThread.start();


      new Handler(getMainLooper()).postDelayed(
                () -> {
                    for(int i = 0; i < 10; i++) {
                      workerThread.addTask(i);
                    }
                }, 1000);



    }
}