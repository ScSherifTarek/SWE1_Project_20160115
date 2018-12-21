package project_classes;

import java.util.ArrayList;

public class Item {
    public String category;
    public String type;
    public String brand;
    private int item_id;
    ArrayList <Post> posts;
    public Item(){}
    public Item(String c,String t ,String b )
    {
        this.category=c;
        this.brand=b;
        this.type=t;
    }
    public void setItemID(int id)
      {
           this.item_id=id;
      }
    public int getItemID()
      {
           return  this.item_id;
      }
    public void setcategory(String cat)
    {
        this.category=cat;
    }
    public void settype(String type)
    {
        this.type=type;
    }
    public void setbrand(String brand)
    {
        this.brand=brand;
    }
     public String getcategory()
     {
         return this.category;
     }
     public String gettype()
     {
         return this.type;
     }
     public String getbrand()
     {
         return this.brand;
     }

}
