import java.util.ArrayList;

public class Question_Answers {
	private int id=-1;
	private String question;
	private String answer;
	private ArrayList<String> options;
	private Form myForm;
	private ArrayList<Item> itemsUsesMe;
	
	public Question_Answers(){}
	public Question_Answers(Question_Answers q)
	{
		this.setId(q.getId());
		this.setQuestion(getQuestion());
		this.setOptions(q.getOptions());
		this.setAnswer(q.getAnswer());
	}
	public Question_Answers(int id, String question, String answer, ArrayList<String> options)
	{
		this.setId(id);
		this.setQuestion(question);
		this.setOptions(options);
		this.setAnswer(answer);
	}
	public Question_Answers(int id, String question, ArrayList<String> options)
	{
		this.id = id;
		this.question = question;
		this.setOptions(options);
	}
	public Question_Answers(String question, ArrayList<String> options)
	{
		this.question = question;
		this.setOptions(options);
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		if(options == null)
		{
			System.out.println("You should enter the options first");
			return;
		}
		for(String option : options)
			if(option.equals(answer))
			{
				this.answer = answer;
				return;
			}
		System.out.println(answer+" Not from the options");
	}

	/**
	 * @return the options
	 */
	public ArrayList<String> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(ArrayList<String> options) {
		if(options == null)
			return;	
		this.options = new ArrayList<>();
		for(String e : options)
			this.options.add(e);
	}
	/**
	 * 
	 * @param option the option to add
	 */
	public void addOptionToOptions(String option)
	{
		if(option == null)
			return;
		if(this.options == null)
			this.options = new ArrayList<>();
		this.options.add(option);
	}
	/**
	 * @return the myForm
	 */
	public Form getMyForm() {
		return myForm;
	}
	/**
	 * @param myForm the myForm to set
	 */
	public void setMyForm(Form myForm) {
		this.myForm = new Form(myForm);
	}
	/**
	 * @return the itemsUsesMe
	 */
	public ArrayList<Item> getItemsUsesMe() {
		return itemsUsesMe;
	}
	/**
	 * @param itemsUsesMe the itemsUsesMe to set
	 */
	public void setItemsUsesMe(ArrayList<Item> itemsUsesMe) {
		if(itemsUsesMe == null)
			return;
		this.itemsUsesMe = new ArrayList<>();
		for(Item e : itemsUsesMe)
			this.itemsUsesMe.add(e);
	}
	/**
	 * 
	 * @param item the item to add
	 */
	public void addQuestionToQuestionsForThisItem(Item item)
	{
		if(item == null)
			return;
		if(this.itemsUsesMe == null)
			this.itemsUsesMe = new ArrayList<>();
		this.itemsUsesMe.add(item);
	}
	/**
	 * 
	 * @param answer to check if it is right
	 * @return true if it is the same like we have
	 */
	public Boolean isThisAnswerRight(String answer)
	{
		return this.answer.equals(answer);
	}
	public String toString()
	{
		String result="\n";
		result += "Q: " + this.question +"\n";
		result += "A: " + this.answer;
		return result;
	}
}
