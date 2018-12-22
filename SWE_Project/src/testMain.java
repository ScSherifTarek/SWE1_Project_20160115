import java.util.ArrayList;
import java.util.Date;

public class testMain {

	public static void main(String[] args) {
		
		String option1 = "Fine";
		String option2 = "Bad";
		System.out.println(Option_DB_Interface.addOption(1, option1));
		System.out.println(Option_DB_Interface.addOption(1, option2));
		System.out.println(Option_DB_Interface.getOptionsFor(1));
		
		// TODO Auto-generated method stub
//		Account acc = Account_DB_Interface.getAccount(5);
//		if(acc == null)
//		{
//			System.out.println("there's no account with this id");
//			return;
//		}
//		else
//			System.out.println(acc);
//		
//		Item item = new Item(1,"Electronics", "Mobiles", "Samsung");
//		System.out.println(item);
//		
//		ArrayList<String> options = new ArrayList<>();
//		options.add("white");
//		options.add("black");
//		Question_Answers q = new Question_Answers(1, "What's its color?", "white", options);
//		System.out.println(q);
//		
//		Form form = new Form(1);
//		form.addQuestionToQuestions(q);
//		form.setCreator(acc);
//		System.out.println(form);
//		
//		Date date = new Date();
//		Post post = new Post(1, "A Lost phone in shoubra", date, item);
//		post.setCreator(acc);
//		post.setCreatorForm(form);
//		
//		form = new Form(2);
//		
//		Account acc1 = Account_DB_Interface.getAccount(7);
//		if(acc1 == null)
//		{
//			System.out.println("No Account with this id");
//			return;
//		}
//			
//		form.setCreator(acc1);
//		q.setAnswer("white");
//		form.addQuestionToQuestions(q);
//		post.addSearchingFormToSearchingForms(form);
//		System.out.println(post);
//		
//		
//		Answer_Message message = new Answer_Message(post, form, form.getCreator(), post.getCreator());
//		System.out.println(message.getBody());
//		
//		Contact_Message cMessage = new Contact_Message(1, acc, acc1);
//		System.out.println(cMessage.getBody());
		
	}

}
