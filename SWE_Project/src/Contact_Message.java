
public class Contact_Message implements Message {

	int id = -1;
	private Account sender;
	private Account receiver;
	
	public Contact_Message() {}
	public Contact_Message(Contact_Message m)
	{
		this.id = m.id;
		this.setSender(m.sender);
		this.setReceiver(m.receiver);
	}
	public Contact_Message(int id, Account sender, Account receiver)
	{
		this.id = id;
		this.setSender(sender);
		this.setReceiver(receiver);
	}
	public Contact_Message(Account sender, Account receiver)
	{
		this.setSender(sender);
		this.setReceiver(receiver);
	}
	
	@Override
	public String getBody() {
		String result="\n";
		result += sender.getName();
		result += " has checked your answers, congratulations we have found for you your item :D\n";
		result += "please contact him by:\n";
		result += "email: " + sender.getEmail();
		result += "phone: " + sender.getPhoneNumber();
		result +="\n";
		return result;
	}

	/**
	 * @return the sender
	 */
	public Account getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(Account sender) {
		this.sender = new Account(sender);
	}

	/**
	 * @return the receiver
	 */
	public Account getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Account receiver) {
		this.receiver = new Account(receiver);
	}

}
