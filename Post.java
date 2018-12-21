/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_classes;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Post {
    Account account ;
    Item i;
    Form form;
    ArrayList <Answer_Message>Ans;
    public String Discription;
    private int postID;
    public String dateAndTime ;
    public void setPostID(int id)
    {
        this.postID=id;
    }
    public int getPostID()
    {
        return this.postID;
    }
    public void setdisc(String disc)
    {
        this.Discription=disc;
    }
    public String getdisc()
    {
        return this.Discription;
    }
}
