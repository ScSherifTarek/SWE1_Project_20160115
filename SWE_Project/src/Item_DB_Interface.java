import java.util.ArrayList;

public class Item_DB_Interface {
	private static String tableName= "items";
	
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
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(`category`, `type`, `brand`)  values"
				+ "('"+ item.getCategory()+"' , '"+ item.getType()+"' , '"+ item.getBrand()+"' )";
		Boolean result = MySQLConnector.executeUpdate(q);
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		if(id != -1)
		{
			ArrayList<Question_Answers> questions = item.getQuestionsForThisItem();
			for(Question_Answers question :questions)
				Question_Answers_DB_Interface.addQuestion_Answers(question);
		}
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
						rs.getString("type"));
				
				item.setQuestionsForThisItem(Question_Answers_DB_Interface.getQuestionsForItemWithId(rs.getInt("id")));
				//posts
				
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
