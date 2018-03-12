package com.example.mark.project_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GettingAround extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_around);
    }

    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, HomeScreen.class);
        //start activity
        startActivity(i);
    }

    //fires when bike hire button is clicked
    public void btnBike_OnClick(View v) {
        //declare a string to hold url
        String url = "https://www.nextbike.co.uk/en/glasgow/";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }

    //fires when subway button is clicked
    public void btnSubway_OnClick(View v) {
        //declare a string to hold url
        String url = "http://www.spt.co.uk/subway/";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }

    //fires when train timetables button is clicked
    public void btnTrain_OnClick(View v) {
        //declare a string to hold url
        String url = "https://www.scotrail.co.uk/plan-your-journey/timetables-and-routes";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }

    //fires when bus timetables button is clicked
    public void btnBus_OnClick(View v) {
        //declare a string to hold url
        String url = "https://www.firstgroup.com/greater-glasgow/plan-journey/timetables/?operator=10&page=1&redirect=no";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }

    //fires when bus timetables button is clicked
    public void btnTaxi_OnClick(View v) {
        //declare a string to hold url
        String url = "http://www.glasgowtaxis.co.uk/";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }
}