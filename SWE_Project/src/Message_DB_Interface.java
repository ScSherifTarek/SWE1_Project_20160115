import java.util.ArrayList;

public class Message_DB_Interface {
	

	
	public static int addAnswer_Message(Answer_Message message)
	{
		return Answer_Message_DB_Interface.addAnswer_Message(message);
	}
	public static int addContact_Message(Contact_Message message)
	{
		return Contact_Message_DB_Interface.addContact_Message(message);
	}
	public static ArrayList<Message> getMessagesForAccountWithId(int id)
	{
		ArrayList<Message>  messages= new ArrayList<>();
		for(Answer_Message m : Answer_Message_DB_Interface.getMessagesForAccountWithId(id))
			messages.add(m);
		for(Contact_Message m : Contact_Message_DB_Interface.getMessagesForAccountWithId(id))
			messages.add(m);
		if(messages.size()<1)
			return null;
		return messages;
	}

}
