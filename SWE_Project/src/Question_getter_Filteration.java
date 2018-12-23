import java.util.ArrayList;

public class Question_getter_Filteration {
	
	public static ArrayList<Question_Answers> getQuestionFor(Item item)
	{
		return Question_Answers_DB_Interface.getQuestionsForItemWithId(item.getId());
	}
	public static Question_Answers createQuestion(ArrayList<Option> options)
	{
		Question_Answers q = new Question_Answers();
		q.setOptions(options);
		return q;
	}
	public static int saveQuestion(Question_Answers q)
	{
		int id = Question_Answers_DB_Interface.addQuestion_Answers(q);
		q.setId(id);
		for(int i=0;i<q.getOptions().size();i++)
		{
			q.getOptions().get(i).setForQuestion(q);
			q.getOptions().get(i).setId(Option_DB_Interface.addOption(q.getOptions().get(i)));
		}
		return id;
	}
}
