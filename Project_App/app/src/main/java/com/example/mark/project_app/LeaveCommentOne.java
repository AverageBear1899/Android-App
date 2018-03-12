package com.example.mark.project_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LeaveCommentOne extends AppCompatActivity {
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_comment_one);
        //get the last intent and get the username extra from it
        Intent i = getIntent();
        email = i.getStringExtra("email");
        //find the edittext
        EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        //set the username
        txtEmail.setText(email);

    }

    public void btnSave_OnClick(View v)
    {
        //find the 2 edit texts
        EditText commenttxt = (EditText) findViewById(R.id.txtComment);
        EditText commentrating = (EditText) findViewById(R.id.txtRating);

        //get the text and save as variables
        String comment = commenttxt.getText().toString();
        int rating = Integer.parseInt(commentrating.getText().toString());

        //create instance of review class
        Comment comments = new Comment();

        //call the four setter methods and pass in values
        comments.setName(email);
        comments.setPlaceId("Glasgow Cathedral");
        comments.setComments(comment);
        comments.setRating(rating);

        try
        {
            DBHandler db = new DBHandler(this);
            if (comment.isEmpty() || rating > 5 || rating < 0)
            {
                displayAlert("Enter valid text", "Either you havent written a comment or your rating is less than 0 or greater than 5, please try again");
                return;
            }
            else
            {
                db.addComment(comments);
            }
        } catch (Exception ex)
        {
            //display an alert with error message
            displayAlert("Comment Failed", "Error: " + ex);
            return;
        }
        //display toast saying review posted successfully
        Toast t = Toast.makeText(this, "success", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER, 0,0);
        t.setText("Comment posted Successful");
        t.show();

        Intent i = new Intent (this, ViewComments_One.class);
        i.putExtra("email", email);
        startActivity(i);
        finish();
    }

    public void displayAlert(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //no additional functionality required
                    }
                }).show();
    }

}


