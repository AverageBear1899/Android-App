package com.example.mark.project_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare an int to determine how long a delay we need
        final int delay = 5000; //1000 = 1 second
        //handler that will execute a method after a delay
        //the delay is determined by the variable delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //declare an intent to open MainActivity
                Intent i = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(i);
                //close splash screen activity
                finish();
            }
        }, delay);
    }
}


