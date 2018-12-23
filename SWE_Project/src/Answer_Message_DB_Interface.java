import java.util.ArrayList;

public class Answer_Message_DB_Interface {
	
	private static String tableName="answermessages";
	
	public static Boolean deleteAnswer_Message(Answer_Message message)
	{
		Form_DB_Interface.deleteForm(message.getFormSubmitted());
		
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+message.getId();
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	public static ArrayList<Answer_Message> getMessageForPostWithId(int id)
	{
		MySQLConnector.openConnection();
		String q ="SELECT * FROM "+tableName+" WHERE `postID` = "+id +"";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{
			MySQLConnector.closeConnection();
			return null;		
		}
		else
			try{
				ArrayList<Answer_Message> messages= new ArrayList<>();
				Answer_Message message= null;
				while(rs.next())
				{
					message = new Answer_Message(
							rs.getInt("id"), 
							Post_DB_Interface.getPostById(rs.getInt("postID")), 
							Form_DB_Interface.getFormById(rs.getInt("formID")), 
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
	public static ArrayList<Answer_Message> getMessagesForAccountWithId(int id)
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
				ArrayList<Answer_Message> messages= new ArrayList<>();
				Answer_Message message= null;
				while(rs.next())
				{
					message = new Answer_Message(
							rs.getInt("id"), 
							Post_DB_Interface.getPostById(rs.getInt("postID")), 
							Form_DB_Interface.getFormById(rs.getInt("formID")), 
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
	public static Answer_Message getMessageById(int id)
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
				Answer_Message message = new Answer_Message(
						rs.getInt("id"), 
						Post_DB_Interface.getPostById(rs.getInt("postID")), 
						Form_DB_Interface.getFormById(rs.getInt("formID")), 
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
	
	public static int addAnswer_Message(Answer_Message m)
	{
		if(m == null || m.getSender() == null || m.getReceiver() == null || m.getFormSubmitted() == null || m.getPostSubmittedInIt() == null)
			return -1;
		MySQLConnector.openConnection();
		String q = "insert into "+tableName+"(senderID, receiverID, formID, postID) "
				+ "values ("
				+ m.getSender().getId() +", "
				+m.getReceiver().getId()+", "
				+m.getFormSubmitted().getId()+", "
				+m.getPostSubmittedInIt().getId() 
				+ ")";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		MySQLConnector.closeConnection();
		return id;
	}
	
	
	public static int getId(int senderID, int receiverID, int formID, int postID)
	{
		MySQLConnector.openConnection();
		String q = "select id from "+tableName+" where "
				+ " senderID ="+senderID+""
				+ " and "
				+ " receiverID ="+receiverID+ ""
				+ " and "
				+ " formID ="+formID+ ""
				+ " and "
				+ " postID ="+postID+ ""
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
