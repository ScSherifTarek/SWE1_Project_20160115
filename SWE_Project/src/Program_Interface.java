import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Program_Interface {
	public static Account acc= null;
	public static Account login()
	{
		Account acc = null;
		Scanner sc = new Scanner(System.in);
		while(acc == null)
		{
			System.out.println("Enter your email: ");
			String email = sc.next();
			email = email.toLowerCase();
			System.out.println("Enter your password: ");
			String password = sc.next();
			acc = Account_Operations.login(email, password);
			if(acc == null)
				System.out.println("The Email or The Password is wrong\n");
		}
		return acc;
	}
	
	public static Account signUp()
	{
		Account acc = null;
		Scanner sc = new Scanner(System.in);
		while(acc == null)
		{
			System.out.println("Enter your Name: ");
			String name = sc.next();
			System.out.println("Enter your email: ");
			String email = sc.next();
			email = email.toLowerCase();
			System.out.println("Enter your Phone Number: ");
			String phoneNumber = sc.next();
			System.out.println("Enter your password: ");
			String password = sc.next();
			acc = Account_Operations.createAccount(name, password, email, phoneNumber);
			if(acc == null)
				System.out.println("\nSorry the email is repeated\n");
		}
		return acc;
	}
	public static void initialize()
	{
		
		ArrayList<Question_Answers> questions = new ArrayList<>();
		
		String q="What is the color?";
		ArrayList<Option> options = new ArrayList<>();
		options.add(new Option("blue"));
		options.add(new Option("red"));
		options.add(new Option("black"));
		options.add(new Option("white"));
		options.add(new Option("purple"));
		options.add(new Option("gray"));
		options.add(new Option("gold"));
		questions.add(new Question_Answers(q,  options));
		
		q = "What is the version of it?";
		options = new ArrayList<>();
		options.add(new Option("y7 prime"));
		options.add(new Option("y7 prime 2018"));
		options.add(new Option("y9 prime"));
		options.add(new Option("y6 prime"));
		questions.add(new Question_Answers(q,options));
		
		q="What is the storage of it?";
		options = new ArrayList<>();
		options.add(new Option("32 GB"));
		options.add(new Option("64 GB"));
		options.add(new Option("16 GB"));
		questions.add(new Question_Answers(q,options));

		q="Where was it lost?";
		options = new ArrayList<>();
		options.add(new Option("Club"));
		options.add(new Option("Azhar Park"));
		options.add(new Option("Haram Street"));
		options.add(new Option("Zoo"));
		questions.add(new Question_Answers(q,options));

		Item item = new Item("Electronics", "Phones", "Huawei");
		item.setQuestionsForThisItem(questions);
		
		Item_choice_Filteration.saveItem(item);
	
	}
	public static void createPost()
	{
		
		String category="", type="", brand="";
		Scanner sc = new Scanner(System.in);
		// choosing the category
		ArrayList<String> choices = Item_choice_Filteration.getCategories();
		int choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the category:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		category = choices.get(choice);

		
		// choosing the type
		choices = Item_choice_Filteration.getTypesForCategory(category);
		if(choices == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}	
		choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the type:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		type = choices.get(choice);

		
		// choosing the brand
		choices = Item_choice_Filteration.getBrandsForCategoryAndTypes(category, type);
		if(choices == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}	
		choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the brand:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		brand = choices.get(choice);

		// get the choosed item
		Item item = Item_choice_Filteration.getItemFor(category, type, brand);
		if(item == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}		
		
		// get the questions for this item
		ArrayList<Question_Answers> questions = Question_getter_Filteration.getQuestionFor(item);
		if(questions == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}
		
		// taking the answers of those questions
		String answer="";
		System.out.println("Please Answer These Questions with the number of the option: ");
		for(int i=0;i<questions.size();i++)
		{
			choice = -1;
			while(choice < 0 || choice >= choices.size())
			{
				System.out.print("Q: " + questions.get(i).getQuestion()+"\n");
				for(int j=0;j<questions.get(i).getOptions().size();j++)
					System.out.println(j+") "+questions.get(i).getOptions().get(j).getOption());
				System.out.print("A: ");
				choice = sc.nextInt();
			}
			
			answer = questions.get(i).getOptions().get(choice).getOption();
			questions.get(i).setAnswer(answer);
		}
		
		// create the creator form
		Form creatorForm = new Form();
		creatorForm.setCreator(acc);
		creatorForm.setQuestions(questions);
		
		// get the description of the post
		System.out.println("Please Write a Description in one line:");
		String description = sc.nextLine();
		
		// create the post
		Date date = new Date();
		Post post = new Post(description, date, item);
		post.setCreator(acc);
		post.setCreatorForm(creatorForm);
		
		// save post
		int id = Post_Operations.savePost(post);
		if(id == -1)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}
		post.setId(id);
		
		
	}
	
	public static void searchForPost()
	{
		String category="", type="", brand="";
		Scanner sc = new Scanner(System.in);
		// choosing the category
		ArrayList<String> choices = Item_choice_Filteration.getCategories();
		int choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the category:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		category = choices.get(choice);

		
		// choosing the type
		choices = Item_choice_Filteration.getTypesForCategory(category);
		if(choices == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}	
		choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the type:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		type = choices.get(choice);

		
		// choosing the brand
		choices = Item_choice_Filteration.getBrandsForCategoryAndTypes(category, type);
		if(choices == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}	
		choice=-1;
		while(choice < 0 || choice >= choices.size())
		{
			System.out.println("\nPlease Choose the number of the brand:");
			for(int i=0;i<choices.size();i++)
				System.out.println(i+") "+choices.get(i));
			choice = sc.nextInt();
		}
		brand = choices.get(choice);

		// get the choosed item
		Item item = Item_choice_Filteration.getItemFor(category, type, brand);
		if(item == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}
		
		
		// get posts with this data
		ArrayList<Post> posts = Post_Operations.getPostsForItem(item);
		if(posts == null)
		{
			System.out.println("Sorry no one had found your item");
		}
		
		// choose a post
		choice = -1;
		while(choice < 0 || choice >= posts.size())
		{
			System.out.println("\nPlease Choose the number of the post:");
			for(int i=0;i<posts.size();i++)
				System.out.println(i+")\n"+posts.get(i));
			choice = sc.nextInt();
		}
		Post choosedPost = posts.get(choice);
		if(choosedPost == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}
		
		// request form without answers
		Form toSubmitForm = Post_Operations.requestSubmitAnswers(choosedPost);
		if(toSubmitForm == null)
		{
			System.out.println("Sorry we are not ready to do your service now please come later");
			return;
		}
		
		
		// taking the answers of questions in the form
		String answer="";
		System.out.println("Please Answer These Questions with the number of the option: ");
		for(int i=0;i<toSubmitForm.getQuestions().size();i++)
		{
			choice = -1;
			while(choice < 0 || choice >= choices.size())
			{
				System.out.print("Q: " + toSubmitForm.getQuestions().get(i).getQuestion()+"\n");
				for(int j=0;j<toSubmitForm.getQuestions().get(i).getOptions().size();j++)
					System.out.println(j+") "+toSubmitForm.getQuestions().get(i).getOptions().get(j).getOption());
				System.out.print("A: ");
				choice = sc.nextInt();
			}
			
			answer = toSubmitForm.getQuestions().get(i).getOptions().get(choice).getOption();
			toSubmitForm.getQuestions().get(i).setAnswer(answer);
		}
		
		
		// validate form
		// if > 80% is right 
		if(Form_Operations.compare(choosedPost.getCreatorForm(),toSubmitForm)>=0.8)
		{
			// submit the form
			toSubmitForm.setCreator(acc);
			choosedPost.addSearchingFormToSearchingForms(toSubmitForm);
			Form_Operations.saveForm(toSubmitForm);
			
			// save a message
			Answer_Message message= new Answer_Message(choosedPost, toSubmitForm, acc, choosedPost.getCreator());
			message.setId(Message_Operations.saveAnswer_Message(message));
			
			System.out.println("Done, Creator will check it");
		}
		else
		{
			System.out.println("7ramy we ahbal :P ");
		}
		
		
	}
	
	public static void main(String[] args) {
//		initialize();
		int input;
		Scanner sc = new Scanner(System.in);
		acc = Account_Operations.login("sherift1552@gmail.com","01158789888");
		System.out.println(acc);
		while(acc == null)
		{
			System.out.println("enter 1 to login, 2 to signup or 3 to exit");
			input = sc.nextInt();
			if(input == 1)
				acc = login();
			if(input == 2)
				acc = signUp();
			if(input == 3)
				return;
				
		}
		while(true)
		{
			System.out.println("enter 1 to post, 2 to search or 3 to exit");
			input = sc.nextInt();
			if(input == 3)
				return;
			if(input == 1)
				createPost();
			if(input == 2)
				searchForPost();
		}
		
	}

}
