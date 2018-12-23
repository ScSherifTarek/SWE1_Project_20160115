
public class Post_Operations {
	public static Form requestSubmitAnswers(Post post)
	{
		Form form = Form_Operations.createForm(post.getCreatorForm().getQuestions());
		return form;
	}
	public static int savePost(Post p)
	{
		int id = Post_DB_Interface.addPost(p);
		p.setId(id);
		return id;
	}
}
