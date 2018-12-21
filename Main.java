
package project_classes;

import java.util.ArrayList;
import java.util.Scanner;
import project_classes.Form_Operations;
import project_classes.Item;
import project_classes.Message;
import project_classes.Question_Answers;
import project_classes.Question_getter_Filteration;


public class Main {
    public static void search(){}
    public static void update_post(){}
    public static void delete_post(){} 
    public static void create_post(){}
    public static  void login(){} 
    public static void signup(){}
    ArrayList<Message> getAllMessages(){return null;} 
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        int welcome_option=0;
        int SearchORpost=0;        
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
    }
    public void OPERATIONS()
    {
        Scanner sc2= new Scanner (System.in);
        ArrayList<Question_Answers> qAns= new ArrayList<>();
        int choice;String cat;String type;String brand;
        System.out.println("What Do You Want To Do ?\n"+"1_Add Item\n2_Search for Item\n");
        choice=sc2.nextInt();
        if(choice==1)
        {   
            System.out.println("Please Enter Item_category\n");
                        cat=sc2.next();
            System.out.println("Please Enter Item_category\n");
                        type=sc2.next();
            System.out.println("Please Enter Item_category\n");
                        brand=sc2.next();
            Item item=new Item(cat ,type ,brand);
            Question_getter_Filteration newitem=new Question_getter_Filteration();
            Form_Operations form =new Form_Operations();
            form.createForm(newitem.getQuestionFor(item));



        }
        
    }

    }
    
    
