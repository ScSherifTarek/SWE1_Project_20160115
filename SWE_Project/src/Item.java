import java.util.ArrayList;

public class Item {
	private int id=-1;
	private String category;
	private String type;
	private String brand;
	private ArrayList<Post> postsForMe;
	private ArrayList<Question_Answers> questionsForThisItem;
	
	public Item(){}
	public Item(Item item)
	{
		if(item == null)
			return;
		this.id = item.getId();
		this.category = item.getCategory();
		this.type = item.type;
		this.brand = item.getBrand();
		this.setPostsForMe(item.getPostsForMe());
	}
	public Item(int id, String category, String type, String brand)
	{
		this.id = id;
		this.category = category;
		this.type = type;
		this.brand = brand;
	}
	public Item(String category, String type, String brand)
	{
		this.category = category;
		this.type = type;
		this.brand = brand;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the postsForMe
	 */
	public ArrayList<Post> getPostsForMe() {
		return postsForMe;
	}
	/**
	 * @param postsForMe the postsForMe to set
	 */
	public void setPostsForMe(ArrayList<Post> postsForMe) {
		if(postsForMe == null)
			return;
		this.postsForMe = new ArrayList<>();
		for(Post post : postsForMe)
			this.postsForMe.add(post);
	}
	/**
	 * 
	 * @param post the post to add
	 */
	public void addPostToPostsForMe(Post post)
	{
		if(post == null)
			return;
		if(this.postsForMe == null)
			this.postsForMe = new ArrayList<>();
		this.postsForMe.add(post);
	}
	
	/**
	 * @return the questionsForThisItem
	 */
	public ArrayList<Question_Answers> getQuestionsForThisItem() {
		return questionsForThisItem;
	}
	/**
	 * @param questionsForThisItem the questionsForThisItem to set
	 */
	public void setQuestionsForThisItem(ArrayList<Question_Answers> questionsForThisItem) {
		if(questionsForThisItem == null)
			return;
		this.questionsForThisItem = new ArrayList<>();
		for(Question_Answers e : questionsForThisItem)
			this.questionsForThisItem.add(e);
	}
	/**
	 * 
	 * @param q the question to add
	 */
	public void addQuestionToQuestionsForThisItem(Question_Answers q)
	{
		if(q == null)
			return;
		if(this.questionsForThisItem == null)
			this.questionsForThisItem = new ArrayList<>();
		this.questionsForThisItem.add(q);
	}
	public String toString()
	{
		String result="\n";
		
		result +="item id : "+this.id+"\n";
		if(this.category != null)
			result +="category : "+this.category+"\n";
		if(this.type != null)
			result +="type : "+this.type+"\n";
		if(this.brand != null)
			result +="brand : "+this.brand+"\n";
		if(this.postsForMe != null)
		{
			result +="used in posts with this ids:";
			for(Post q : this.postsForMe)
				result += q.getId() +", ";
			result += "...\n";
		}
		return result;
	}
	
}
