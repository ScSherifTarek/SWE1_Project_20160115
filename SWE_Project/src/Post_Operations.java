import java.util.ArrayList;

public class Post_Operations {
	public static Form requestSubmitAnswers(Post post)
	{
		Form form = Form_Operations.createForm(post.getCreatorForm().getQuestions());
		form.setSubmittedIn(post);
		return form;
	}
	public static int savePost(Post p)
	{
		
		p.getCreatorForm().setId(Form_Operations.saveForm(p.getCreatorForm()));
		int id = Post_DB_Interface.addPost(p);
		p.setId(id);
		
		return id;
	}
	public static ArrayList<Post> getPostsForItem(Item item)
	{
		return Post_DB_Interface.getPostsWithItemWithId(item.getId());
	}
}
