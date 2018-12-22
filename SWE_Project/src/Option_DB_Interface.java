import java.util.ArrayList;


public class Option_DB_Interface {
	private static String tableName= "options";
	
	public static int addOption(Option option)
	{
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(questionID, option) values"
				+ "("+option.getForQuestion().getId()+", '"+ option.getOption()+"' )";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		MySQLConnector.closeConnection();
		return id;
	}
	
	public static Boolean deleteOption(int id)
	{
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+id;
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	
	public static ArrayList<Option> getOptionsFor(int questionID)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName +" where "
				+ "questionID = " + questionID;
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
				ArrayList<Option> options= new ArrayList<>();
				Option option = null;
				while(rs.next())  
				{
					option = new Option(rs.getInt("id"), rs.getString("option"));
					options.add(option);
				}
				MySQLConnector.closeConnection();
				return options;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
		
	}
	
}
