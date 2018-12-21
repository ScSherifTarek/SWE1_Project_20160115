
package project_classes;

import java.util.ArrayList;

public class Post_Operations {
   public Form requestSubmitAnswers(){
       
   return null;
   }
  public boolean validate_Form(Post post, Form form){
      Form_Operations f=new Form_Operations();
     float fl= f.compare(post, form);
  int idP=post.form.getFormID();
  int idF=form.getFormID(form);
  if(fl>=0.8) return true; 
  // if content of form 1 equals or more than 80% return true
  // else return false
  return false;
  }
  public ArrayList<Post> getPostsWithThisData(Item item){
       return item.posts;
  
  }


}
