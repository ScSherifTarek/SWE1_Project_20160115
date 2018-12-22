
public class Post_DB_Interface {
	private static String dateFormat = "YYYY-MM-dd HH:mm:ss";
	private static String tableName="posts";
	


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
