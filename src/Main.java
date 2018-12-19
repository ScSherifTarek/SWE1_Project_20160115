
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void search(){}
    public static void update_post(){}
    public static void delete_post(){} 
    public static void create_post(){}
    public static  void login(){} 
    public static void signup(){}
    ArrayList<Message> getAllMessages(){return null;} 
    
    public static void main(String[] args) {
        int welcome_option=0;
        int SearchORpost=0;        
        Scanner sc= new Scanner (System.in);
        System.out.println("Welcome to 2ayiin a4ya2ii :)");
        System.out.println("1-Log in");
        System.out.println("2- sign up");
        welcome_option=sc.nextInt();
        if(welcome_option==1) {
            login();
            System.out.println("What Do You Want To Do ?");
            System.out.println("1-Make Post");
            System.out.println("2-Search For Item");
            SearchORpost=sc.nextInt();
            if(SearchORpost==1)create_post();
            else search();
        }
        else signup();
        
        
        // TODO code application logic here
    }
    
}
