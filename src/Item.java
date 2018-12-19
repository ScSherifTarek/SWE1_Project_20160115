
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
public class Item {
    ArrayList <Post> posts;
    public String category;
    public String type;
    public String brand;
    int item_id;
    static int item_counter=0;
    public void setItemID(){
        item_counter++;
        item_id=item_counter;
        
    }
    public int getItemID(Item it){
        return it.item_id;
    }
}
