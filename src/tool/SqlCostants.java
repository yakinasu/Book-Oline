package tool;

public class SqlCostants {
	public final static String SQL_BOOK_ADD = "INSERT INTO BookInfodb (isbn , tytle , page , author) VALUES(?, ?, ?, ?)";
	public final static String SQL_BOOK_SELECT =  "SELECT * FROM bookInfodb";
	public final static String SQL_BOOK_SEARCH =  "SELECT * FROM bookInfodb WHERE isbn = ? FOR UPDATE";
	public final static String SQL_BOOK_SEARCH_FOR_UPDATE =  "SELECT * FROM bookInfodb   WHERE isbn = ? FOR UPDATE";
	public final static String SQL_BOOK_DELETE = "DELETE FROM bookInfodb WHERE isbn = ?";
	public final static String SQL_BOOK_UPDATE_TITLE = "UPDATE bookInfodb SET tytle = ? WHERE isbn = ?";
	public final static String SQL_BOOK_UPDATE_PAGE = "UPDATE bookInfodb SET page = ? WHERE isbn = ?";
	public final static String SQL_UPDATE_AUTHOR = "UPDATE bookInfodb set author = ? WHERE isbn = ?";
	public final static String SQL_USER_ADD = "INSERT INTO UserInfo (username, password) VALUES(?, ?)";
}
