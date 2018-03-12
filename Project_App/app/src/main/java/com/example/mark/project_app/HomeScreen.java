package com.example.mark.project_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //get the last intent and get the username extra from it
        Intent i = getIntent();
        email = i.getStringExtra("email");
    }

    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, Login_Activity.class);
        //start activity
        startActivity(i);
    }

    //fires when the whats on button is clicked
    public void btnWhatsOn_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, WhatsOn.class);
        //start the activity
        startActivity(i);
    }
    //fires when the places to visit button is clicked
    public void btnPlaces_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlacesToVisit.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start the activity
        startActivity(i);
    }
    //fires when the getting around button is clicked
    public void btnGettingAround_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, GettingAround.class);
        //start the activity
        startActivity(i);
    }
}
