import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnector {
	private static String databaseName = "jdbc:mysql://localhost/swe_project";
	private static String username = "root";
	private static String password = "";
	private static Connection con;
	
	/**
	 * A function to open the connection
	 * @return true if the connection opened correctly 
	 * @return false if not
	 */
	public static Boolean openConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(databaseName,username,password);  
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}

	}
	
	/**
	 * A function to close the connection
	 * @return true if the connection closed correctly
	 * @return false if not
	 */
	public static Boolean closeConnection()
	{
		try
		{
			
			con.close();  
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}

	}
	
	/**
	 * A function used to execute queries that perform an updates and don't return any thing
	 * like select, update and delete
	 * @param q the query to be executed
	 * @return true if the updates done successfully
	 * @return false if not
	 */
	public static Boolean executeUpdate(String q)
	{
		try
		{  
			Statement stmt=con.createStatement();  
			stmt.executeUpdate(q);  
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}  
	}
	
	
	/**
	 * A function used to execute select queries
	 * @param q the query to be executed
	 * @return the result set if the query executed successfully
	 * @return null if not
	 */
	public static java.sql.ResultSet executeQuery(String q)
	{
		try
		{   
			Statement stmt=con.createStatement();  
			stmt.executeQuery(q);  
			ResultSet rs= stmt.executeQuery(q);
			return rs;
		}
		catch(Exception e)
		{
			return null;
		}  
	}
	
	
	
	/**
	 * @return the databaseName
	 */
	public static String getDatabaseName() {
		return databaseName;
	}
	/**
	 * @param databaseName the databaseName to set
	 */
	public static void setDatabaseName(String databaseName) {
		MySQLConnector.databaseName = "jdbc:mysql://localhost/" + databaseName;
	}
	/**
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public static void setUsername(String username) {
		MySQLConnector.username = username;
	}
	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		MySQLConnector.password = password;
	}
	
}
