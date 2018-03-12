package com.example.mark.project_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WhatsOn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_on);
    }

    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, HomeScreen.class);
        //start activity
        startActivity(i);
    }

    //fires when the first image is clicked
    public void ImageOne_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, EventOne.class);
        //start the activity
        startActivity(i);
    }

    //fires when the second image is clicked
    public void ImageTwo_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, EventTwo.class);
        //start the activity
        startActivity(i);
    }

    //fires when the third image is clicked
    public void ImageThree_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, EventThree.class);
        //start the activity
        startActivity(i);
    }
}
