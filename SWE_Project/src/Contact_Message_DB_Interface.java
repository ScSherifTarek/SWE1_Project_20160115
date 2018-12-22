import java.util.ArrayList;

public class Contact_Message_DB_Interface {
	
	private static String tableName="contactmessages";
	
	public static Boolean deleteContact_Message(Contact_Message message)
	{		
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+message.getId();
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	public static ArrayList<Contact_Message> getMessagesForAccountWithId(int id)
	{
		MySQLConnector.openConnection();
		String q ="SELECT * FROM "+tableName+" WHERE `receiverID` = "+id +"";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{
			MySQLConnector.closeConnection();
			return null;		
		}
		else
			try{
				ArrayList<Contact_Message> messages= new ArrayList<>();
				Contact_Message message= null;
				while(rs.next())
				{
					message = new Contact_Message(
							rs.getInt("id"), 
							Account_DB_Interface.getAccount(rs.getInt("senderID")), 
							Account_DB_Interface.getAccount(rs.getInt("receiverID")));
					messages.add(message);
				}				
				MySQLConnector.closeConnection();
				return messages;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
	}
	
	public static int addContact_Message(Contact_Message m)
	{
		if(m == null || m.getSender() == null || m.getReceiver()==null)
			return -1;
		MySQLConnector.openConnection();
		String q = "insert into "+tableName+"(senderID, receiverID) values "
				+ "("
				+ m.getSender().getId() +", "
				+m.getReceiver().getId()
				+ ")";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		MySQLConnector.closeConnection();
		return id;
	}
	public static Contact_Message getMessageById(int id)
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
				Contact_Message message = new Contact_Message(
						rs.getInt("id"), 
						Account_DB_Interface.getAccount(rs.getInt("senderID")), 
						Account_DB_Interface.getAccount(rs.getInt("receiverID")));
				MySQLConnector.closeConnection();
				return message;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
}
