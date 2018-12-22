import java.util.ArrayList;

public class Account{

	private int id=-1;
	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	private ArrayList<Message> messages;
	private ArrayList<Form> submittedForms;
	private ArrayList<Post> createdPosts;
	
	public Account(){}
	public Account(Account acc)
	{
		if(acc == null)
			return;
		this.id = acc.getId();
		this.name = acc.getName();
		this.password = acc.getPassword();
		this.email = acc.getEmail();
		this.phoneNumber = acc.getPhoneNumber();
		this.setMessages(acc.getMessages());
		this.setSubmittedForms(acc.getSubmittedForms());
		this.setCreatedPosts(acc.getCreatedPosts());
	}
	public Account(int id,String name, String password, String email, String phoneNumber)
	{
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Account(String name, String password, String email, String phoneNumber)
	{
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<Message> messages) {
		if(messages == null)
			return;
		this.messages = new ArrayList<>();
		for(Message m : messages)
			this.messages.add(m);
	}
	public void addMessageToMessages(Message message)
	{
		if(messages == null)
			return;
		if(this.messages == null)
			this.messages = new ArrayList<>();
		this.messages.add(message);
	}
	/**
	 * @return the submittedForms
	 */
	public ArrayList<Form> getSubmittedForms() {
		return submittedForms;
	}
	/**
	 * @param submittedForms the submittedForms to set
	 */
	public void setSubmittedForms(ArrayList<Form> submittedForms) {
		if(submittedForms == null)
			return;
		this.submittedForms = new ArrayList<>();
		for(Form form : submittedForms)
			this.submittedForms.add(form);
	}
	public void addFormToSubmittedForms(Form form)
	{
		if(form == null)
			return;
		if(submittedForms == null)
			submittedForms = new ArrayList<>();
		submittedForms.add(form);
	}
	/**
	 * @return the createdPosts
	 */
	public ArrayList<Post> getCreatedPosts() {
		return createdPosts;
	}
	/**
	 * @param createdPosts the createdPosts to set
	 */
	public void setCreatedPosts(ArrayList<Post> createdPosts) {
		if(createdPosts == null)
			return;
		this.createdPosts = new ArrayList<>();
		for(Post post : createdPosts)
			this.createdPosts.add(post);
	}
	/**
	 * 
	 * @param post the post to add
	 */
	public void addPostToCreatedPosts(Post post)
	{
		if(post == null)
			return;
		if(this.createdPosts == null)
			this.createdPosts = new ArrayList<>();
		this.createdPosts.add(post);
	}
	public String toString()
	{
		String result="\n";
		
		result +="Account id : "+this.id+"\n";
		if(this.name != null)
			result +="name : "+this.name +"\n";
		if(this.email != null)
			result +="email : "+this.email +"\n";
		if(this.phoneNumber != null)
			result +="phone number : "+this.phoneNumber +"\n";
		if(this.password != null)
			result +="password : "+this.password +"\n";
		return result;
	}
}