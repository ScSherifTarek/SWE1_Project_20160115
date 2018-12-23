import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Post {
	private int id=-1;
	private String description=null;
	private String datetime;
	private Item lostItem;
	private Account creator;
	private Form creatorForm;
	private ArrayList<Form> searchingForms;
	private ArrayList<Answer_Message> answerMessages; 
	
	public Post(){}
	public Post(Post post)
	{
		if(post == null)
			return;
		this.id = post.getId();
		this.description = post.getDescription();
		this.datetime = post.getDatetime();
		this.setLostItem(post.getLostItem());
	}
	public Post(int id, String description ,String datetime, Item lostItem)
	{
		this.id = id;
		this.description = description;
		this.datetime = datetime;
		this.setLostItem(lostItem);
	}
	public Post(String description ,String datetime, Item lostItem)
	{
		this.description = description;
		this.datetime = datetime;
		this.setLostItem(lostItem);
	}
	public Post(int id, String description ,String datetime)
	{
		this.id = id;
		this.description = description;
		this.datetime = datetime;
	}
	public Post(int id, String description ,Date datetime, Item lostItem)
	{
		this.id = id;
		this.description = description;
		this.setDatetime(datetime);
		this.setLostItem(lostItem);
	}
	public Post(String description ,Date datetime, Item lostItem)
	{
		this.description = description;
		this.setDatetime(datetime);
		this.setLostItem(lostItem);
	}
	public Post(int id, String description ,Date datetime)
	{
		this.id = id;
		this.description = description;
		this.setDatetime(datetime);
	}
	public Post(String description ,Date datetime)
	{
		this.description = description;
		this.setDatetime(datetime);
	}
	public Post(String description ,String datetime)
	{
		this.description = description;
		this.datetime = datetime;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		if(datetime == null)
			return;
		DateFormat dateFormat = new SimpleDateFormat(Post_DB_Interface.getDateFormat());
		this.datetime = dateFormat.format(datetime);
	}
	/**
	 * @return the lostItem
	 */
	public Item getLostItem() {
		return lostItem;
	}
	/**
	 * @param lostItem the lostItem to set
	 */
	public void setLostItem(Item lostItem) {
		if(lostItem == null)
			return;
		this.lostItem = new Item(lostItem);
	}
	/**
	 * @return the creatorForm
	 */
	public Form getCreatorForm() {
		return creatorForm;
	}
	/**
	 * @param creatorForm the creatorForm to set
	 */
	public void setCreatorForm(Form creatorForm) {
		if(creatorForm == null)
			return;
		this.creatorForm = new Form(creatorForm);
	}
	/**
	 * @return the creator
	 */
	public Account getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	/**
	 * @return the searchingForms
	 */
	public ArrayList<Form> getSearchingForms() {
		return searchingForms;
	}
	/**
	 * @param searchingForms the searchingForms to set
	 */
	public void setSearchingForms(ArrayList<Form> searchingForms) {
		if(searchingForms == null)
			return;
		this.searchingForms = new ArrayList<>();
		for(Form e : searchingForms)
			this.searchingForms.add(e);
	}
	public void addSearchingFormToSearchingForms(Form form)
	{
		if(form == null)
			return;
		if(this.searchingForms == null)
			this.searchingForms = new ArrayList<>();
		this.searchingForms.add(form);
	}
	/**
	 * @return the answerMessages
	 */
	public ArrayList<Answer_Message> getAnswerMessages() {
		return answerMessages;
	}
	/**
	 * @param answerMessages the answerMessages to set
	 */
	public void setAnswerMessages(ArrayList<Answer_Message> answerMessages) {
		if(answerMessages == null)
			return;
		this.answerMessages = new ArrayList<>();
		for(Answer_Message e : answerMessages)
			this.answerMessages.add(e);
	}
	public void addAnswerMessageToAnswerMessages(Answer_Message answerMessage)
	{
		if(answerMessage == null)
			return;
		if(this.answerMessages == null)
			this.answerMessages = new ArrayList<>();
		this.answerMessages.add(answerMessage);
	}
	public String toString()
	{
		String result="\n";
		
//		result +="post id : "+this.id+"\n";
		if(this.creator != null)
			if(this.creator.getName()!=null)
				result +="creator name: " + this.creator.getName();
		if(this.lostItem != null)
		{
			result +="the item lost is from ";
			if(this.lostItem.getCategory()!= null)
				result +="category : "+this.lostItem.getCategory()+", ";
			if(this.lostItem.getType() != null)
				result +="type : "+this.lostItem.getType()+", ";
			if(this.lostItem.getBrand() != null)
				result +="brand : "+this.lostItem.getBrand()+"";
		}
		
		result +="\ndescription :" + this.getDescription();
		result +="\nposted in : "+this.datetime+"\n";
		
		
//		if(this.creatorForm != null)
//		{
//			result +="the creator form data is as follow:\n";
//			result +=this.creatorForm;
//		}
		
//		if(this.searchingForms != null)
//		{
//			result +="the answers form:";
//			for(Form f : this.searchingForms)
//				result += f + "\n";
//		}
		
		return result;
	}
}
