/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Account_Operations {
    
    public Account login(String email,String password){
        Account ac=new Account();
        
        // search for account in DB if found  
    //if (found==true) return ac to make operations on object
        return ac;
    }
    public Account createAccount(String n,String pass, String em, String ph){
     Account ac= new Account();
     ac.name=n;
     ac.email=em;
     ac.setPassword(pass);
     ac.setPhoneNum(ph);
     ac.setUserId();
     return ac;
    }
    
}
