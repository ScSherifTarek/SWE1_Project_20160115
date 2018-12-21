
package project_classes;

import java.util.ArrayList;

public class Form {
    private int formID;
    ArrayList <Question_Answers> Q_ans;
     
    public void setFormID(int id)
    {
        this.formID=id;
    }
    public int getFormID(){
      return this.formID;    
    }
    
   
    
}
