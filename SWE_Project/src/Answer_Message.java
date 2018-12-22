import java.util.ArrayList;

public class Answer_Message implements Message {
	private int id = -1;
	private Post postSubmittedInIt;
	private Form formSubmitted;
	private Account sender;
	private Account receiver;
	
	public Answer_Message(){}
	public Answer_Message(Answer_Message m)
	{
		if(m == null)
			return;
		this.id = m.getId();
		this.setPostSubmittedInIt(m.getPostSubmittedInIt());
		this.setFormSubmitted(m.getFormSubmitted());
		this.setSender(m.getSender());
		this.setReceiver(m.getReceiver());
	}
	public Answer_Message(int id, Post postSubmittedInIt, Form formSubmitted, Account sender, Account receiver )
	{
		this.id = id;
		this.setPostSubmittedInIt(postSubmittedInIt);
		this.setFormSubmitted(formSubmitted);
		this.setSender(sender);
		this.setReceiver(receiver);
	}
	public Answer_Message(Post postSubmittedInIt, Form formSubmitted, Account sender, Account receiver )
	{
		this.setPostSubmittedInIt(postSubmittedInIt);
		this.setFormSubmitted(formSubmitted);
		this.setSender(sender);
		this.setReceiver(receiver);
	}
	
	@Override
	public String getBody() {
		String result="\n";
		result += "Some One Submitted in the post with this description:\n";
		result += postSubmittedInIt.getDescription() +"\n";
		result += "which posted by you in : " + postSubmittedInIt.getDatetime() + "\n";
		result += "Please take an action with him :D\n";
		result += "Here's the questions with his answers check it then do the right you see (e3mel elsa7 XD)\n";
		ArrayList<Question_Answers> qAs = formSubmitted.getQuestions();
		for(Question_Answers q : qAs)
			result += q + "\n";
		return result;
	}

	/**
	 * @return the postSubmittedInIt
	 */
	public Post getPostSubmittedInIt() {
		return postSubmittedInIt;
	}

	/**
	 * @param postSubmittedInIt the postSubmittedInIt to set
	 */
	public void setPostSubmittedInIt(Post postSubmittedInIt) {
		this.postSubmittedInIt = new Post(postSubmittedInIt);
	}

	/**
	 * @return the formSubmitted
	 */
	public Form getFormSubmitted() {
		return formSubmitted;
	}

	/**
	 * @param formSubmitted the formSubmitted to set
	 */
	public void setFormSubmitted(Form formSubmitted) {
		this.formSubmitted = new Form(formSubmitted);
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
