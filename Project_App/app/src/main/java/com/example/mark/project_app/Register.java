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

public class Register extends AppCompatActivity {
    private EditText txtName;
    private EditText txtPassword;
    private EditText txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = (EditText)findViewById(R.id.txtName);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtEmail = (EditText)findViewById(R.id.txtEmail);

    }

    public void btnRegister_OnClick(View v)
    {
        //find edittexts


        //get the text and save to variables
        //get the text out of the edittexts and saved to variable
        String name = txtName.getText().toString();
        String password = txtPassword.getText().toString();
        String email = txtEmail.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            displayAlert("Empty field(s)", "Please fill in all fields");
            return;
        }


        DBHandler db = new DBHandler(this);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);



        if(db.emailTaken(email) == true)
        {
            //display an error
            displayAlert("Email Used", "The email you've entered has already been used");
        }else {

            //try apply this information to the database
            try {


                db.addUser(user);
            }
            catch(Exception ex)
            {
                displayAlert("Registration Failed", "Error: " + ex);
                return;
            }

            //display toast
            Toast t = Toast.makeText(this, "success", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0,0);
            t.setText("Registration Successful");
            t.show();

            ReturnToLogin();
        }
    }

    //method fires when register button is clicked
    public void btnCancel_OnClick(View v)
    {
        ReturnToLogin();
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

    public void ReturnToLogin()
    {
        //initialise intent connected to register activity
        Intent i = new Intent(this, Login_Activity.class);

        //start the activity
        startActivity(i);

        //close this page
        finish();
    }
}


