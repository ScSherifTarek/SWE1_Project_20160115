
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Form_Operations {
   public float compare( Form post_form, Form form_entered){
       int correct=0;
       for(int i=0;i<post_form.Q_ans.size();i++){
       if(post_form.Q_ans.get(i).Answer.equals(form_entered.Q_ans.get(i).Answer))
           correct++;
           }
      return correct/post_form.Q_ans.size();
     }
  public void createForm(ArrayList<Question_Answers> q_ans){
      String ans="";
      Scanner sc=  new Scanner(System.in); 
        for(int i=0;i<q_ans.size();i++){
            System.out.println(q_ans.get(i).Question);
            System.out.println(q_ans.get(i).Options);
            ans=sc.nextLine();
            q_ans.get(i).Answer=ans;
        }
        
   }
 public Form getForm(int FormID){
 ///search in DB for formID
 //put all info in form object
Form form=new Form();
//form.Q_ans=what will be returned from DB;
return form;
 }
 public Form getFormWithoutAnswers(Form baseForm){
     Form form=new Form();
     int index=baseForm.Q_ans.indexOf(baseForm.getFormID(baseForm));
     form.setFormID();
     form.Q_ans.get(form.getFormID(form)).Question=baseForm.Q_ans.get(index).Question;
     form.Q_ans.get(form.getFormID(form)).Options=baseForm.Q_ans.get(index).Options;
     return form;
 }
 
  
}
