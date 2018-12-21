
package project_classes;

import java.util.ArrayList;
public class Question_Answers {
    Form form;
    String Question;
    ArrayList<String> Options;
    String Answer;
    private int qID;
    static int Q_counter=0;
   
    public void setQID(){
    Q_counter++;
    qID=Q_counter;
    }
    public int getQID(Question_Answers qa){
        return qa.qID;
    }
    ArrayList<String> getOptions(Question_Answers q){
        ArrayList<String> str=new ArrayList<>();
        // search in DB by Question ID and get answers
        // put it in arraylist str
        return str ;
    }
 /* public boolean isThisAnswerRight(String answer,int qID,Form f){
      f.
      String ans="";
      //search in DB with ID of question 
      //get the answer in string ans 
      if(ans.equals(answer)) return true;
      else return false;
  } 
    */
}

