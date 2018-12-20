import java.util.ArrayList;

public class Account_DB_Interface {
	private static String tableName="accounts";
	
	public static  int addAccount(Account acc)
	{
		MySQLConnector.openConnection();
		String q = "insert into "+tableName+"(name, password, email, phone) values ('"
				+ acc.getName() +"', '"+acc.getPassword()+"', '"+acc.getEmail()+"', '"+acc.getPhoneNumber() + "')";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = getId(acc.getEmail(), acc.getPassword());
		MySQLConnector.closeConnection();
		return id;
	}
	
	public static  Boolean updateAccount(Account acc)
	{
		MySQLConnector.openConnection();
		String q = "update "+tableName+" set "
				+ "name='"+acc.getName()+"', "
				+ "password='"+acc.getPassword()+"', "
				+ "email='"+acc.getEmail()+"', "
				+ "phone='"+acc.getPhoneNumber()+"' "
				+ "where id="+acc.getId();
		
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	
	
	public static ArrayList<Account> getAllAccounts()
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
				ArrayList<Account> accounts= new ArrayList<>();
				Account acc = null;
				while(rs.next())  
				{
					acc = new Account
							(
							rs.getInt("id"), 
							rs.getString("name"), 
							rs.getString("password"), 
							rs.getString("email"), 
							rs.getString("phone")
							);
					accounts.add(acc);
				}
				MySQLConnector.closeConnection();
				return accounts;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	
	public static Account getAccount(int id)
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
				Account acc = 
						new Account
						(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("password"), 
						rs.getString("email"), 
						rs.getString("phone")
						);
				
				MySQLConnector.closeConnection();
				return acc;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static Account getAccount(String email,String password)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where "
				+ "email ='"+email+"' "
				+ "and "
				+ "password ='"+password+ "'"
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
				Account acc = 
						new Account
						(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("password"), 
						rs.getString("email"), 
						rs.getString("phone")
						);
				
				MySQLConnector.closeConnection();
				return acc;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static int getId(String email,String password)
	{
		MySQLConnector.openConnection();
		String q = "select id from "+tableName+" where "
				+ "email ='"+email+"' "
				+ "and "
				+ "password ='"+password+ "'"
				+ " limit 1";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return -1;
		}
		else
		{
			try
			{
				rs.next();
				int id = rs.getInt("id");
				MySQLConnector.closeConnection();
				return id;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return -1;
			}
		}
	}
	
}

