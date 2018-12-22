import java.util.ArrayList;

public class Question_Answers_DB_Interface {
	
	private static String tableName= "questionandanswers";	
	public static int addQuestion_Answers(Question_Answers question)
	{
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(question, answer) values"
				+ "("+question.getQuestion()+", '"+ question.getAnswer()+"' )";
		Boolean result = MySQLConnector.executeUpdate(q);
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		if(id != -1)
		{
			ArrayList<String> options = question.getOptions();
			for(String option:options)
				Option_DB_Interface.addOption(id, option);

		}
		MySQLConnector.closeConnection();
		return id;
	}
	
	public static ArrayList<Question_Answers> getQuestionsForFormWithId(int id)
	{
		String q = "SELECT "
					+ "questionandanswers.id, "
					+ "questionandanswers.question, "
					+ "questionandanswers.answer "
				+ "FROM "
					+ "`questionsforforms` "
					+ "JOIN "
					+ "forms "
					+ "JOIN "
					+ "questionandanswers "
				+ "ON "
					+ "questionsforforms.formID = forms.id "
					+ "AND "
					+ "questionsforforms.questionID = questionandanswers.id";
		MySQLConnector.openConnection();
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
				ArrayList<Question_Answers> questions= new ArrayList<>();
				Question_Answers qu = null;
				while(rs.next())  
				{
					
					qu = new Question_Answers(
							rs.getInt("id"), 
							rs.getString("question"), 
							rs.getString("answer"),
							Option_DB_Interface.getOptionsFor(rs.getInt("id"))
							);
					questions.add(qu);
				}
				MySQLConnector.closeConnection();
				return questions;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
		
	}
	public static ArrayList<Question_Answers> getQuestionsForItemWithId(int id)
	{
		String q = "SELECT "
					+ "questionandanswers.id, "
					+ "questionandanswers.question, "
					+ "questionandanswers.answer "
				+ "FROM "
					+ "`questionsforitems` "
					+ "JOIN "
					+ "items "
					+ "JOIN "
					+ "questionandanswers "
				+ "ON "
					+ "questionsforitems.formID = items.id "
					+ "AND "
					+ "questionsforitems.questionID = questionandanswers.id";
		MySQLConnector.openConnection();
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
				ArrayList<Question_Answers> questions= new ArrayList<>();
				Question_Answers qu = null;
				while(rs.next())  
				{
					
					qu = new Question_Answers(
							rs.getInt("id"), 
							rs.getString("question"), 
							rs.getString("answer"),
							Option_DB_Interface.getOptionsFor(rs.getInt("id"))
							);
					questions.add(qu);
				}
				MySQLConnector.closeConnection();
				return questions;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
		
	}
	
	
	public static Boolean deleteQuestion(int id)
	{
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+id;
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
}
