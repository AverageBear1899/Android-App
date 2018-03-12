package com.example.mark.project_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlacesToVisit extends AppCompatActivity {
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);
        //get the last intent and get the username extra from it
        Intent i = getIntent();
        email = i.getStringExtra("email");
    }

    //fires when the back icon is clicked
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, HomeScreen.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start activity
        startActivity(i);
    }

    //fires when the first image is clicked
    public void ImageOne_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlaceOne.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start the activity
        startActivity(i);
    }

    //fires when the second image is clicked
    public void ImageTwo_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlaceTwo.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start the activity
        startActivity(i);
    }
    //fires when the third image is clicked
    public void ImageThree_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlaceThree.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start the activity
        startActivity(i);
    }
    //fires when the fourth image is clicked
    public void ImageFour_OnClick(View v)
    {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlaceFour.class);
        //passing along the email to use when making comments
        i.putExtra("email", email);
        //start the activity
        startActivity(i);
    }
}
