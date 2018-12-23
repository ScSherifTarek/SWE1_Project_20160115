import java.util.ArrayList;

public class Form {
	private int id=-1;
	private Account creator;
	private ArrayList<Question_Answers> questions;
	private Post submittedIn;
	
	public Form(){}
	public Form(Form form)
	{
		this.setId(form.getId());
		this.setCreator(form.getCreator());
		this.setQuestions(form.getQuestions());
	}
	public Form(int id)
	{
		this.setId(id);
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
	 * @return the creator
	 */
	public Account getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Account creator) {
		if(creator == null)
			return;
		this.creator = new Account(creator);
	}
	/**
	 * @return the questions
	 */
	public ArrayList<Question_Answers> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<Question_Answers> questions) {
		if(questions == null)
			return;
		this.questions = new ArrayList<>();
		for(Question_Answers e : questions)
			this.questions.add(e);
	}
	/**
	 * 
	 * @param question the question to add
	 */
	public void addQuestionToQuestions(Question_Answers question)
	{
		if(question == null)
			return;
		if(this.questions == null)
			this.questions = new ArrayList<>();
		this.questions.add(question);
		
	}
	/**
	 * @return the submittedIn
	 */
	public Post getSubmittedIn() {
		return submittedIn;
	}
	/**
	 * @param submittedIn the submittedIn to set
	 */
	public void setSubmittedIn(Post submittedIn) {
		this.submittedIn = new  Post(submittedIn);
	}
	
	public String toString()
	{
		String result="\n";
		
		result +="form id : "+this.id+"\n";
		if(this.creator != null)
			result +="creator name : "+this.creator.getName() +"\n";
		if(this.questions != null)
		{
			result +="Questions And their answers in this form:\n";
			for(Question_Answers q : this.questions)
				result += q +"\n";
		}
		return result;
	}
	
}
