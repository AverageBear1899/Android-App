package com.example.mark.project_app;

/**
 * Created by Mark on 23/02/2018.
 */

public class User {
    //private properties
    private String name;
    private String password;
    private String email;



    //public getter functions
    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }




    //public setter methods
    public void setName(String nameIn)
    {
        name = nameIn;
    }

    public void setPassword(String passwordIn)
    {
        password = passwordIn;
    }

    public void setEmail(String emailIn)
    {
        email = emailIn;
    }


}
