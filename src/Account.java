
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
public class Account {
     String name;
     ArrayList<Post>post;
     ArrayList <Form> forms;
     ArrayList <Message> msg;
      private int userID;
      static int Acc_counter=0;
      private String phoneNumber;
       String email;
       private String password;
       public void setPassword(String pass){
           password=pass;
       }
       public String getPassword(Account ac){
       return ac.password;
       }
   
      public void setUserId(){
          Acc_counter++;
          userID=Acc_counter;
      }
       public int getUserID(Account acc){
           return acc.userID;
       }
     public void setPhoneNum(String number){
          phoneNumber=number;
      } 
   public String getPhoneNum(Account ac){
          return ac.phoneNumber;
      }
     public String getPhoneNum(String email){
      String phone_num="";
      //search in DB 
      return phone_num;
      
     }
     boolean emailIUnique(String email){
         //search in DB with  email if found 
         return false;
     
     }
     
      
    
}
