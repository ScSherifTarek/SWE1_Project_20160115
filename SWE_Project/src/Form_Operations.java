import java.util.ArrayList;

public class Form_Operations {
	public static float compare(Form postForm, Form enteredForm)
	{
		if(postForm == null || enteredForm == null || postForm.getQuestions() == null || postForm.getQuestions() == null)
			return 0;
		if(postForm.getQuestions().size() != enteredForm.getQuestions().size())
			return 0;
		float result = 0;
		int numOfQuestions = postForm.getQuestions().size();
		for(int i=0;i<numOfQuestions;i++)
		{
			if(postForm.getQuestions().get(i).isThisAnswerRight(enteredForm.getQuestions().get(i).getAnswer()))
				result +=1;
			
		}
		result /= numOfQuestions;
		return result;
	}
	
	public static Form createForm(ArrayList<Question_Answers> QandAs)
	{
		Form form = new Form();
		for(int i=0;i<QandAs.size();i++)
		{
			QandAs.get(i).setId(Question_Answers_DB_Interface.addQuestion_Answers(QandAs.get(i)));
		}
		form.setQuestions(QandAs);
		return form;
	}
	
	public static Form getFormWithoutAnswers(Post p)
	{
		Form form = new Form(p.getCreatorForm());
		form.setId(-1);
		form.setSubmittedIn(p);
		for(int i=0;i<form.getQuestions().size();i++)
			form.getQuestions().get(i).setAnswer("");
		return form;
	}
	
	public static int saveForm(Form f)
	{
		int id = Form_DB_Interface.addForm(f);
		f.setId(id);
		for(int i=0;i<f.getQuestions().size();i++)
		{
			f.getQuestions().get(i).setMyForm(f);
			f.getQuestions().get(i).setId(Question_getter_Filteration.saveQuestion(f.getQuestions().get(i)));
		}
		return id;
	}
}
