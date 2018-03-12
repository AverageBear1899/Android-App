package com.example.mark.project_app;

/**
 * Created by Mark on 23/02/2018.
 */

public class Comment {
    //private properties
    private String name;
    private String placeId;
    private String Comments;
    private int Rating;


    //public getter functions
    public String getName()
    {
        return name;
    }

    public String getplaceId()
    {
        return placeId;
    }

    public String getComments()
    {
        return Comments;
    }

    public int getRating()
    {
        return Rating;
    }


    //public setter methods
    public void setName(String nameIn)
    {
        name = nameIn;
    }

    public void setPlaceId(String placeIdIn)
    {
        placeId = placeIdIn;
    }

    public void setComments(String CommentsIn)
    {
        Comments = CommentsIn;
    }

    public void setRating(int RatingIn)
    {
        Rating = RatingIn;
    }
}
