import java.util.ArrayList;

public class Item_choice_Filteration {

	public static ArrayList<String> getCategories()
	{
		return Item_DB_Interface.getAllCategories();
	}
	public static ArrayList<String> getTypesForCategory(String category)
	{
		if(category == null)
			return null;
		return Item_DB_Interface.getAllTypesForCategory(category);
	}
	public static ArrayList<String> getBrandsForCategoryAndTypes(String category, String type)
	{
		if(category == null || type == null )
			return null;
		return Item_DB_Interface.getAllBrandsForCategoryAndType(category, type);
	}
	public static ArrayList<Item> getAllItems()
	{
		return Item_DB_Interface.getAllItems();
	}
	public static Item getItemFor(String category,String type, String brand)
	{
		if(category == null || type == null || brand == null)
			return null;
		return Item_DB_Interface.getItem(category, type, brand);
	}
	
	public static int saveItem(Item item)
	{
		int id = Item_DB_Interface.addItem(item);
		item.setId(id);
		for(int i=0;i<item.getQuestionsForThisItem().size();i++)
		{
			item.getQuestionsForThisItem().get(i).addItemToItemsUsesMe(item);;
			Question_getter_Filteration.saveQuestion(item.getQuestionsForThisItem().get(i));
		}
		return id;
	}
}
