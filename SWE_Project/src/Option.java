
public class Option {
	private int id=-1;
	private String option;
	private Question_Answers forQuestion;
	Option(){}
	Option(int id, String option)
	{
		this.id=id;
		this.option = option;
	}
	Option(String option)
	{
		this.option = option;
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
	 * @return the option
	 */
	public String getOption() {
		return option;
	}
	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}
	/**
	 * @return the forQuestion
	 */
	public Question_Answers getForQuestion() {
		return forQuestion;
	}
	/**
	 * @param forQuestion the forQuestion to set
	 */
	public void setForQuestion(Question_Answers forQuestion) {
		this.forQuestion = new Question_Answers(forQuestion);
	}
}
