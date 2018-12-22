import java.util.ArrayList;


public class Option_DB_Interface {
	private static String tableName= "options";
	
	public static int addOption(int questionID,String option)
	{
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(questionID, option) values"
				+ "("+questionID+", '"+ option+"' )";
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
	
	public static ArrayList<String> getOptionsFor(int questionID)
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
				ArrayList<String> options= new ArrayList<>();
				String option = null;
				while(rs.next())  
				{
					option = rs.getString("option");
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
