/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmain;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Contact_Message_DB_Interface {
    		
	private static String tableName="contactmessages";
	
	
	public static ArrayList<String> getMessageById(int id)
	{
		
 	
 		MySQLConnector.openConnection();
 		String m = "select * from "+tableName +" where "
 				+ "id = " + id;
 		java.sql.ResultSet rs = MySQLConnector.executeQuery(m);
 		if(rs == null)
 		{	
 			MySQLConnector.closeConnection();
 			return null;
 		}
 		else
 		{
 			try
 			{
 				ArrayList<String> Messages= new ArrayList<>();
 				String message = null;
 				while(rs.next())  
 				{
                                    message = rs.getString("option");
 					Messages.add(message);
 				}
 				MySQLConnector.closeConnection();
 				return Messages;
 			}
 			catch(Exception ex)
 			{
 				MySQLConnector.closeConnection();
 				return null;
 			}
                }
        }
        public static int addContact_Message(Contact_Message c)
	{
		MySQLConnector.openConnection();
		String q = "insert into "+tableName+"(id,senderID, receiverID) "
				+ "values ("
				+ c.id +", "
				+c.getSender()+", "
				+c.getReceiver()+", "
				+ ")";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = c.id; 
		MySQLConnector.closeConnection();
		return id;
	}
	
	
	public static int getId(int senderID, int receiverID)
	{
		MySQLConnector.openConnection();
		String q = "select id from "+tableName+" where "
				+ " senderID ="+senderID+""
				+ " and "
				+ " receiverID ="+receiverID+ ""
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

