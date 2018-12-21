package project_classes;

public class Acoount_Operations {
    public Account login(String em,String pass){
        Account ac=new Account(em,pass);
        //email unique search by email
        //check password of email
        //get password form DB 
        String password="";
        if(pass.equals(password)) {

        //get all info of account an return it to the object
            
        }
    
        
        // search for account in DB if found  
    //if (found==true) return ac to make operations on object
        return ac;
    }
    
    public int createAccount(String n,String pass, String em, String ph){
     Account ac= new Account(n ,pass,em ,ph);
     Account_DB_interface inter=new Account_DB_interface();
     if(inter.addAccount(ac))return ac.getId();
     else return -1;
     
    }

    
}
