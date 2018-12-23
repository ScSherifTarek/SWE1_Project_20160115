import java.util.ArrayList;

public class Message_Operations {
	public static int saveAnswer_Message(Answer_Message message)
	{
		return Answer_Message_DB_Interface.addAnswer_Message(message);
	}
	public static int saveContact_Message(Contact_Message message)
	{
		return Contact_Message_DB_Interface.addContact_Message(message);
	}
	public ArrayList<Message> getAllMessagesForAccountWithId(int id)
	{
		return Message_DB_Interface.getMessagesForAccountWithId(id);
	}
}
