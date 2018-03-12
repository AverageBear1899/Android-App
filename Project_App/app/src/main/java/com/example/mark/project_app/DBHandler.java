package com.example.mark.project_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Mark on 23/02/2018.
 */

public class DBHandler extends SQLiteOpenHelper
{
    //FINAL variables to hold the names of the two TABLES
    public static final String TABLE_USERS = "users";
    public static final String TABLE_COMMENTS = "comments";

    //FINAL variables to hold the COLUMNS for the USERS table
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";


    //FINAL variables to hold the COLUMNS for the COMMENTS table (reuse "username" from above)
    public static final String COLUMN_PLACE_ID = "placeId";
    public static final String COLUMN_COMMENTS = "Comments";
    public static final String COLUMN_RATING = "Rating";


    //constructor for the DBHandler class - takes in a parameter defining the context
    public DBHandler(Context context)
    {
        //UsersDB is the name of the database which will be created
        //null is to say use the standard SQL Cursor behaviours   //1 is the version number of the DB
        super(context, "UsersDB", null, 1);
    }


    //Create tables for database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //build a string which contains the necessary SQL to create the USERS table
        final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," + COLUMN_PASSWORD + " TEXT," +
                COLUMN_EMAIL + " TEXT " +
                ")";

        //execute the sql by calling the execSQL method
        db.execSQL(CREATE_USERS_TABLE);


        //build a string which contains the necessary SQL to create the COMMENTS table
        final String CREATE_COMMENTS_TABLE = "CREATE TABLE " + TABLE_COMMENTS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_PLACE_ID + " TEXT," + COLUMN_NAME + " TEXT," +
                COLUMN_COMMENTS + " TEXT," + COLUMN_RATING + " INT" +
                ")";

        //execute the sql by calling the execSQL method
        db.execSQL(CREATE_COMMENTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //we need to have this method as we inherit from SQLiteOpenHelper
        //but don't need to code it as we won't use it
    }


    //add user to users table - takes in a parameter of User
    public void addUser(User user)
    {
        //content values class allows us to store all the data we wish to insert for the new user
        ContentValues values = new ContentValues();
        //call the put method to add the data we wish for a certain column
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_EMAIL, user.getEmail());

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();
        //call the insert method to add all the data in the ContentValues object to a new row in the db
        db.insert(TABLE_USERS, null, values);
        //close the db
        db.close();
    }

    //Check if new username is already in table - takes in a parameter of username
    public boolean emailTaken(String email)
    {
        //build a string which contains the necessary SQL to check if the username exists
        String query = "SELECT * FROM " + TABLE_USERS +
                " WHERE " + COLUMN_EMAIL + " = '" + email + "'";

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();
        //declare a cursor which will be used to read the data from the database table
        Cursor cursor = db.rawQuery(query, null);
        //declare a boolean to hold whether the username is found or not
        boolean taken = false;
        //Carry out SQL query on username from users Table
        //Use 'Cursor' to hold any results - should be 1 result if found and 0 if not
        if(cursor.getCount() > 0 )
        {
            //then the username already exists
            taken = true;
            cursor.close();
        }else{
            //the username doesnt exist, so is available
            taken = false;
        }

        //close the db connection
        db.close();
        //return the boolean value
        return taken;
    }

    //CheckLogin method confirms if username is in database and if so checks if stored password matches input
    //both checks must pass to return true - the user logged in correctly
    public boolean checkLogin(String email, String password)
    {
        //build a string which contains the necessary SQL to check if the username and password combo exists
        String query = "SELECT * FROM " + TABLE_USERS +
                " WHERE " + COLUMN_EMAIL + " = '" + email + "'" +
                " AND " + COLUMN_PASSWORD + " = '" + password + "'";
        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("delete from "+ TABLE_USERS);
        //db.execSQL("delete from "+ TABLE_COMMENTS);

        //declare a cursor which will be used to read the data from the database table
        Cursor cursor = db.rawQuery(query, null);
        //declare a boolean to hold answer
        boolean valid = false;
        //Carry out SQL query on username and password from users Table
        //Use 'Cursor' to hold any results - should be 1 result if found and 0 if not
        if (cursor.getCount() > 0)
        {
            //the username and password is correct
            valid = true;
            cursor.close();
        }
        db.close();
        return valid;
    }

    //add comment to comments table - takes in a parameter of Comment
    public void addComment(Comment comment)
    {
        //content values class allows us to store all the data we wish to insert for the new comment
        ContentValues values = new ContentValues();
        //call the put method to add the data we wish for a certain column
        values.put(COLUMN_PLACE_ID, comment.getplaceId());
        values.put(COLUMN_NAME, comment.getName());
        values.put(COLUMN_COMMENTS, comment.getComments());
        values.put(COLUMN_RATING, comment.getRating());

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();
        //call the insert method to add all the data in the ContentValues object to a new row in the db
        db.insert(TABLE_COMMENTS, null, values);
        //close the db
        db.close();
    }

    //Fetch comments left for a product - takes in the parameter ProductId
    public ArrayList<Comment> getcomments(String placeId)
    {
        //declare an array list of COMMENTS class objects
        ArrayList<Comment> comments = new ArrayList<>();
        //build a string which contains the necessary SQL to check if the username and password combo ecist
        String query = "SELECT * FROM " + TABLE_COMMENTS +
                " WHERE " + COLUMN_PLACE_ID + " = '" + placeId + "'";
        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();
        //declare a cursor which will be used to read the data from the database table
        Cursor cursor = db.rawQuery(query, null);
        //Carry out SQL query on username and password from users Table
        //Use 'Cursor' to hold any results - should be 1 result if found and 0 if not
        if ( cursor.getCount() > 0){
            //for every record returned map the values to a comment class

            //move to the first record
            cursor.moveToFirst();

            //create instance of comment class
            Comment r = new Comment();

            r.setPlaceId(cursor.getString(1));
            r.setName(cursor.getString(2));
            r.setComments(cursor.getString(3));
            r.setRating(cursor.getInt(4));

            //add the comment to the arraylist
            comments.add(r);
            //keep repeating this task while there are records left to view
            while (cursor.moveToNext())
            {
                r = new Comment();

                r.setPlaceId(cursor.getString(1));
                r.setName(cursor.getString(2));
                r.setComments(cursor.getString(3));
                r.setRating(cursor.getInt(4));

                //add the comment to the arraylist
                comments.add(r);
            }
            cursor.close();
            db.close();
        }
        //return populated arraylist
        return comments;
    }
}
