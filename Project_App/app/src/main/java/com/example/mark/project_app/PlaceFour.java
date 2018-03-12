package com.example.mark.project_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlaceFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_four);
    }
    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlacesToVisit.class);
        //start activity
        startActivity(i);
    }

    //fires when getting there button is clicked
    public void btnGettingThere_OnClick(View v) {
        //declare a string to hold url
        String url = "http://bit.ly/2syyKjN";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }
}
