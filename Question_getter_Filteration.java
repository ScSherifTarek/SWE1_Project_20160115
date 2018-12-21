
package project_classes;

import java.util.ArrayList;


public class Question_getter_Filteration {
    ArrayList<Question_Answers> question_Answers;
    
 ArrayList<Question_Answers> getQuestionFor(Item item){
     Item_Choice_Filteration itf=new Item_Choice_Filteration();
     itf.getCategories();
     itf.getTypesFor();
     itf.getBrandsFor();
     item=itf.getAllIIPossibleCombinations();
     int id=item.getItemID();
     ArrayList<Question_Answers> qAns= new ArrayList<>();
     //serach in DB for item id questions in arraylist
     return qAns;
 }
 
/* 
 ArrayList<Question_Answers> getQuestionForCat(String category){
     
 return null;
 } 

    
ArrayList<Question_Answers> getQuestionForTypeAndCategory(String type,String  category){
    return null;
} 
*/  
 

}