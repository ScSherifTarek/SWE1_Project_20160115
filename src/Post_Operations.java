
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
public class Post_Operations {
   public Form requestSubmitAnswers(){
       
   return null;
   }
  public boolean validate_Form(Post post, Form form){
  int idP=post.form.getFormID(form);
  int idF=form.getFormID(form);
  // if content of form 1 equals or more than 80% return true
  // else return false
  return false;
  }
  public ArrayList<Post> getPostsWithThisData(Item item){
       return item.posts;
  
  }


}
