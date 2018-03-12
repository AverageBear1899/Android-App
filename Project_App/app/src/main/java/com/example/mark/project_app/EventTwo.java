package com.example.mark.project_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EventTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_two);
    }

    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, WhatsOn.class);
        //start activity
        startActivity(i);
    }

    //fires when tickets button is clicked
    public void btnTickets_OnClick(View v) {
        //declare a string to hold url
        String url = "http://www.ticketmaster.co.uk/summernights";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }

    //fires when more info button is clicked
    public void btnMoreInfo_OnClick(View v) {
        //declare a string to hold url
        String url = "http://www.whatsonglasgow.co.uk/event/008751-summer-nights-at-the-bandstand/";
        //call an intent to open default browser and go to the website
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //start the activity
        startActivity(i);
    }
}
