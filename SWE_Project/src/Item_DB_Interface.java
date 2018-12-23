import java.util.ArrayList;

public class Item_DB_Interface {
	private static String tableName= "items";
	
	public static ArrayList<Item> getAllItems()
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName;
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				Item item = null;
				ArrayList<Item> items = new ArrayList<>();
				while(rs.next())
				{
					item = new Item(
							rs.getInt("id"), 
							rs.getString("category"), 
							rs.getString("type"), 
							rs.getString("brand"));
					item.setQuestionsForThisItem(Question_Answers_DB_Interface.getQuestionsForItemWithId(rs.getInt("id")));
					item.setPostsForMe(Post_DB_Interface.getPostsWithItemWithId(rs.getInt("id")));
					items.add(item);
				}
					
				MySQLConnector.closeConnection();
				return items;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static Item getItem(String category, String type, String brand)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where "
				+ " category ='"+category+"' "
				+ " AND "
				+ " type = '"+type+"' "
				+ " AND "
				+ " brand = '"+brand+"' "
				+ " limit 1";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				rs.next();
				Item item = new Item(
						rs.getInt("id"), 
						rs.getString("category"), 
						rs.getString("type"), 
						rs.getString("brand"));
				
				item.setQuestionsForThisItem(Question_Answers_DB_Interface.getQuestionsForItemWithId(rs.getInt("id")));
				item.setPostsForMe(Post_DB_Interface.getPostsWithItemWithId(rs.getInt("id")));
				
				MySQLConnector.closeConnection();
				return item;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static ArrayList<String> getAllBrandsForCategoryAndType(String category, String type)
	{
		MySQLConnector.openConnection();
		String q = "select brand from "+tableName+"where type='"+type+"' AND category ='"+category+"'";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				ArrayList<String> result = new ArrayList<>();
				String temp="";
				while(rs.next())
				{
					temp = rs.getString("brand");
					result.add(temp);
				}				
				MySQLConnector.closeConnection();
				return result;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static ArrayList<String> getAllTypesForCategory(String category)
	{
		MySQLConnector.openConnection();
		String q = "select type from "+tableName+"where category='"+category+"'";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				ArrayList<String> result = new ArrayList<>();
				String temp="";
				while(rs.next())
				{
					temp = rs.getString("type");
					result.add(temp);
				}				
				MySQLConnector.closeConnection();
				return result;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static ArrayList<String> getAllCategories()
	{
		MySQLConnector.openConnection();
		String q = "select category from "+tableName+"";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				ArrayList<String> result = new ArrayList<>();
				String temp="";
				while(rs.next())
				{
					temp = rs.getString("category");
					result.add(temp);
				}				
				MySQLConnector.closeConnection();
				return result;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static Boolean deleteItem(int id)
	{
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+id;
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	public static int addItem(Item item)
	{
		if(item == null)
			return -1;
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(`category`, `type`, `brand`)  values"
				+ "('"+ item.getCategory()+"' , '"+ item.getType()+"' , '"+ item.getBrand()+"' )";
		Boolean result = MySQLConnector.executeUpdate(q);
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		MySQLConnector.closeConnection();
		return id;
	}
	public static Item getItemById(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where id ="+id+" limit 1";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				rs.next();
				Item item = new Item(
						rs.getInt("id"), 
						rs.getString("category"), 
						rs.getString("type"), 
						rs.getString("brand"));
				
				item.setQuestionsForThisItem(Question_Answers_DB_Interface.getQuestionsForItemWithId(rs.getInt("id")));
				item.setPostsForMe(Post_DB_Interface.getPostsWithItemWithId(rs.getInt("id")));
				
				MySQLConnector.closeConnection();
				return item;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	
}
