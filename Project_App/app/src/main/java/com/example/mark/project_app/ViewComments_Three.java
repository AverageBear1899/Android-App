package com.example.mark.project_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewComments_Three extends AppCompatActivity {
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments__three);
        //get the last intent and get the username extra from it
        Intent i = getIntent();
        email = i.getStringExtra("email");
    }
    public void btnBack_OnClick(View v) {
        //declare a new intent and pass in this screen and the screen we wish to go to
        Intent i = new Intent(this, PlaceThree.class);
        //start activity
        startActivity(i);
    }

    //method which will fire when we click the add comments button
    public void btnAddComment_OnClick(View v) {
        Intent i = new Intent(this, LeaveCommentThree.class);
        i.putExtra("email", email);
        startActivity(i);
    }

    //method which will get ther comments from the db and display them
    public void displayComments() {
        //find the list view
        ListView listOfComments = (ListView) findViewById(R.id.lstComment2);

        //create an instance of the db handler class
        DBHandler db = new DBHandler(this);

        //create an instance of array list
        ArrayList<Comment> arrayComments = new ArrayList<>();
        //call the getComments method to populate the arraylist
        arrayComments = db.getcomments("Riverside"); //put in the name of the place here
        //array list of strings

        ArrayList<String> arrayString = new ArrayList<>();

        //loop through every comments in the array list
        for (Comment r : arrayComments) {
            //build a string with formatting for display
            String formattedComment = "Commenter:\t\t" + r.getName() +
                    "\nRating:\t\t\t\t" + r.getRating() + " Out of 5" +
                    "\nComments:\t\t\t\t" + r.getComments();
            //add formatted comments to array list of strings
            arrayString.add(formattedComment);
        }

        //declare an arrayAdapter which will display all the strings in the listview
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayString);

        //connect the adapter to the list view
        listOfComments.setAdapter(listAdapter);
    }
}

