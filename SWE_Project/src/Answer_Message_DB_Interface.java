import java.util.ArrayList;

public class Answer_Message_DB_Interface {
	
	private static String tableName="answermessages";
	
	public static Answer_Message getMessageById(int id)
	{
		return null;
	}
	
	public static int addAnswer_Message(Answer_Message m)
	{
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
