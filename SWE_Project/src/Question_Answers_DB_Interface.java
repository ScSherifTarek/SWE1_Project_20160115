import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

public class Question_Answers_DB_Interface {
	
	private static String tableName= "questionandanswers";	
	public static int addQuestion_Answers(Question_Answers question)
	{
		if(question == null)
			return -1;
		MySQLConnector.openConnection();
		String q = "insert into "+tableName
				+"(question, answer) values"
				+ "('"+question.getQuestion()+"', '"+ question.getAnswer()+"' )";
		Boolean result = MySQLConnector.executeUpdate(q);
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		if(id != -1)
		{
			if(question.getMyForm() != null)
			{
				q = "INSERT INTO `questionsforforms`(`questionID`, `formID`) "
						+ "VALUES ("+ id +" , "+ question.getMyForm().getId() + ")";
				MySQLConnector.executeUpdate(q);
				
			}
			if(question.getItemsUsesMe() != null)
			{
				for(Item i : question.getItemsUsesMe())
				{
					q = "select * from questionsforitems where "
							+ "questionID =" + id +""
							+ "And"
							+ "itemID = "+i.getId()+"";
					try
					{
						java.sql.ResultSet haves = MySQLConnector.executeQuery(q);
						haves.next();
						continue;
					}catch(Exception ex)
					{
					}
					
					
					q = "INSERT INTO `questionsforitems`(`questionID`, `itemID`) "
							+ "VALUES ("+id+" , " + i.getId() +" )";
					MySQLConnector.executeUpdate(q);
				}
					
			}
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
	
	public static Question_Answers getQuestionAnswersWithId(int id)
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
				Question_Answers qu= 
						new Question_Answers(
								rs.getInt("id"),
								rs.getString("question"), 
								rs.getString("answer"),
								Option_DB_Interface.getOptionsFor(rs.getInt("id"))
								);
				
				MySQLConnector.closeConnection();
				return qu;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static Boolean deleteQuestion(Question_Answers qu)
	{
		for(Option option: qu.getOptions())
			Option_DB_Interface.deleteOption(option.getId());
		MySQLConnector.openConnection();
		String q = "delete from "+ tableName +" where "
				+ "id = "+qu.getId();
		Boolean result = MySQLConnector.executeUpdate(q);
		MySQLConnector.closeConnection();
		return result;
	}
}
