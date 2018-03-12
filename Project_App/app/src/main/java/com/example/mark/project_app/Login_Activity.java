package com.example.mark.project_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }
    //method fires when login button is clicked
    public void btnLogin_OnClick (View v)
    {
        //get the two edittexts
        EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        //get the text out of the edittexts and saved to variable
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        //create a new instance of the DBHandler
        DBHandler db = new DBHandler(this);

        //check username and password have a length
        if (email.length() == 0 || password.length() == 0)
        {
            //display error and return
            displayAlert("Empty Fields", "You must enter an email and/or password");
            return;
        }

        //call the check login method from dbhandler class
        if (db.checkLogin(email, password) == true)
        {
            //login is ok
            Intent i = new Intent(this, HomeScreen.class);
            //pass across the username as an extra
            i.putExtra("email", email);
            startActivity(i);

        }else{
            //invalid login details
            displayAlert("Invalid Login", "Email and/or password is incorrect, please reenter your details");
        }


    }

    //method to display alert dialog
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


    //method fires when register button is clicked
    public void btnRegister_OnClick(View v)
    {
        //initialise intent connected to register activity
        Intent i = new Intent(this, Register.class);

        //start the activity
        startActivity(i);

        //close this page
        finish();

    }

}

