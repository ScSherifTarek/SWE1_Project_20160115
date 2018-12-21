
package project_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Item_Choice_Filteration {
  static ArrayList<Item>   allItems;//////from database
  public ArrayList <String> Categories=new ArrayList<>();///from database
  ArrayList <String> types= new ArrayList<>();
  ArrayList <String> brands= new ArrayList<>();     ///from database
    String C,T,B;
  
  ArrayList<String> getCategories(){
      int choice=0;
      Scanner sc=new Scanner(System.in);
      System.out.println("choose Category:");
     
      for(int i=0;i< Categories.size();i++){
        System.out.println((int)(i+1)+Categories.get(i));  
      
      }
       choice=sc.nextInt();C=Categories.get(choice);
              
      
  ArrayList <String> types=new ArrayList<>();
  return types;
       
  } 
 void getTypesFor(){
          
     types=getCategories();
     for(int i=0;i<types.size();i++){
     System.out.println((int)(i+1)+types.get(i));
     }
     int t=0;
     Scanner sc=new Scanner(System.in);
     t=sc.nextInt();
     types.get(t-1);
       T=types.get(t-1);
     //search in DB and get ArrayList of brand in brands 
     ArrayList brands=new ArrayList<>();
     
             } 
public void  getBrandsFor( ){
 
     
     for(int i=0;i<brands.size();i++){
     System.out.println((int)(i+1)+brands.get(i));
     }
     int b=0;
     Scanner sc=new Scanner(System.in);
     b=sc.nextInt();
     B=brands.get(b-1);
     
 }
public Item getAllIIPossibleCombinations(){
    int ind = 0;
    for(int i=0 ;i<allItems.size(); i++){
        
    if(allItems.get(i).category.equals(C) && allItems.get(i).type.equals(T)
            && allItems.get(i).brand.equals(B) )
    {ind =i; break;}
            }
    
    //Select item form DB to Get Item ID in it;
   // Item it=new Item();
    return allItems.get(ind);
}

}

    

