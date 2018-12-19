
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Post {
    Account account;
    Item i;
    Form form;
    ArrayList <Form>forms;
    ArrayList<Answer_Message>ANS;
    public String Discription ;
    private int postID;
    static int Post_counter=0;
    public String dateAndTime;
    
    public void setPostID(){
        Post_counter++;
        postID=Post_counter;
    }
    public int getPostID(Post p){
        return p.postID;
    }
    
    
}
