import java.util.ArrayList;

public class Post_DB_Interface {
	private static String dateFormat = "YYYY-MM-dd HH:mm:ss";
	private static String tableName="posts";
	
	public static ArrayList<Post> getPostsWithItemWithId(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where itemID ="+id+"";
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
				ArrayList<Post> posts = new ArrayList<>();
				Post post = null;
				while(rs.next())
				{
					post =  new Post(
							rs.getInt("id"), 
							rs.getString("desc"), 
							rs.getString("dateAndTime"), 
							Item_DB_Interface.getItemById(rs.getInt("itemID"))
							);
					post.setCreator(Account_DB_Interface.getAccount(rs.getInt("creatorID")));
					post.setCreatorForm(Form_DB_Interface.getFormById(rs.getInt("creatorFormID")));
					posts.add(post);
				}				
				MySQLConnector.closeConnection();
				return posts;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static ArrayList<Post> getPostsCreatedByAccountWithId(int id)
	{
		MySQLConnector.openConnection();
		String q = "select * from "+tableName+" where creatorID ="+id+"";
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
				ArrayList<Post> posts = new ArrayList<>();
				Post post = null;
				while(rs.next())
				{
					post =  new Post(
							rs.getInt("id"), 
							rs.getString("desc"), 
							rs.getString("dateAndTime"), 
							Item_DB_Interface.getItemById(rs.getInt("itemID"))
							);
					post.setCreator(Account_DB_Interface.getAccount(rs.getInt("creatorID")));
					post.setCreatorForm(Form_DB_Interface.getFormById(rs.getInt("creatorFormID")));
					posts.add(post);
				}				
				MySQLConnector.closeConnection();
				return posts;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	public static Post getPostSubmittedByFormWithId(int id)
	{
		MySQLConnector.openConnection();
		String q ="SELECT `postID` FROM `formsinposts` WHERE `formID` = "+id +"limit 1";
		java.sql.ResultSet rs = MySQLConnector.executeQuery(q);
		if(rs == null)
		{
			MySQLConnector.closeConnection();
			return null;		
		}
		else
			try{
				rs.next();
				Post post = getPostById(rs.getInt("postID"));
				MySQLConnector.closeConnection();
				return post;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
	}
	public static Post getPostById(int id)
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
				Post post = new Post(
						rs.getInt("id"), 
						rs.getString("desc"), 
						rs.getString("dateAndTime"), 
						Item_DB_Interface.getItemById(rs.getInt("itemID"))
						);
				post.setCreator(Account_DB_Interface.getAccount(rs.getInt("creatorID")));
				post.setCreatorForm(Form_DB_Interface.getFormById(rs.getInt("creatorFormID")));
				MySQLConnector.closeConnection();
				return post;
			}
			catch(Exception ex)
			{
				MySQLConnector.closeConnection();
				return null;
			}
		}
	}
	
	public static int addPost(Post post)
	{
		MySQLConnector.openConnection();
		post.getCreatorForm().setId(Form_DB_Interface.addForm(post.getCreatorForm())); 
		String q = "insert into "+tableName
				+"(`desc`, `dateAndTime`, `itemID`, `creatorID`, `creatorFormID`)  values"
				+ "('"
				+ post.getDescription()+"' , '"
				+ post.getDatetime()+"' , "
				+ post.getLostItem().getId()+" , "
				+ post.getCreator().getId()+" , "
				+ post.getCreatorForm().getId()+" )";
		Boolean result = MySQLConnector.executeUpdate(q);
		
		//load the id
		int id=-1;
		if(result)
			id = MySQLConnector.getIdOfTheLastAddedIn(tableName);
		if(id != -1)
		{
			post.getCreatorForm().setId(Form_DB_Interface.addForm(post.getCreatorForm()));
		}
		MySQLConnector.closeConnection();
		return id;
	}


	/**
	 * @return the dateFormat
	 */
	public static String getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param strDateFormat the strDateFormat to set
	 */
	public static void setDateFormat(String dateFormat) {
		Post_DB_Interface.dateFormat = dateFormat;
	}
}
