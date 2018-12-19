
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
public class Form {
    private int formID;
    static int Form_counter=0;
    ArrayList <Question_Answers> Q_ans;
    public void setFormID(){
        Form_counter++;
        formID=Form_counter;
    }
   public int getFormID(Form form){
       return form.formID;
   }
}
