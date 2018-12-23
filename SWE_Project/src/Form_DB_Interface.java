import java.util.ArrayList;

public class Form_DB_Interface {

	private static String tableName= "forms";

	
	public static Boolean deleteForm(Form form)
	{
		
		for(Question_Answers qu: form.getQuestions())
			Question_Answers_DB_Interface.deleteQuestion(qu);
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+form.getId();
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
	public static ArrayList<Form> getFormsCreatedByAccountWithId(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where formWriterID ="+id+"";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				ArrayList<Form> forms = new ArrayList<>();
				Form form = null;
				while(rs.next())
				{
					form = new Form(rs.getInt("id"));
					form.setQuestions(Question_Answers_DB_Interface.getQuestionsForFormWithId(rs.getInt("id")));
					form.setCreator(Account_DB_Interface.getAccount(rs.getInt("formWriterID")));
					form.setSubmittedIn(Post_DB_Interface.getPostById(rs.getInt("postSubmittedIn")));
					forms.add(form);
				}				
				MySQLConnector.closeConnection();
				return forms;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static ArrayList<Form> getFormsForPostWithId(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where postSubmittedIn ="+id+"";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				ArrayList<Form> forms = new ArrayList<>();
				Form form = null;
				while(rs.next())
				{
					form = new Form(rs.getInt("id"));
					form.setQuestions(Question_Answers_DB_Interface.getQuestionsForFormWithId(rs.getInt("id")));
					form.setCreator(Account_DB_Interface.getAccount(rs.getInt("formWriterID")));
					form.setSubmittedIn(Post_DB_Interface.getPostById(rs.getInt("postSubmittedIn")));
					forms.add(form);
				}				
				MySQLConnector.closeConnection();
				return forms;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static int addForm(Form form)
	{
		if(form == null || form.getCreator() == null || form.getSubmittedIn() == null)
			return -1;
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"( `formWriterID`, `postSubmittedIn`)  values"
				+ "('"+ form.getCreator().getId()+"' , '"+ form.getSubmittedIn().getId()+"')";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		if(id != -1)
		{
			if(form.getSubmittedIn() != null )
			{
				q = "INSERT INTO `formsinposts`(`formID`, `postID`) "
						+ "VALUES "
						+ "("
						+ id + ","
						+ form.getSubmittedIn().getId()+ ","
						+ ")";
				result = MySQLConnector.executeUpdate(q);
			}
			
		}
		MySQLConnector.closeConnection();
		return id;
	}
	
	public static Form getFormById(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where id ="+id+" limit 1";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{		
			MySQLConnector.closeConnection();
			return null;
		}
		else
		{
			try
			{
				rs.next();
				Form form = new Form(rs.getInt("id"));
				form.setQuestions(Question_Answers_DB_Interface.getQuestionsForFormWithId(rs.getInt("id")));
				form.setCreator(Account_DB_Interface.getAccount(rs.getInt("formWriterID")));
				form.setSubmittedIn(Post_DB_Interface.getPostById(rs.getInt("postSubmittedIn")));
				
				MySQLConnector.closeConnection();
				return form;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
}
