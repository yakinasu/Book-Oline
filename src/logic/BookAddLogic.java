package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BookInfoDao;
import model.BookBean;
import tool.SqlCostants;

public class BookAddLogic {
	public BookBean forSearch = new BookBean();
	public ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	public BookInfoDao bookInfoDao = new BookInfoDao();

	public BookAddLogic() throws SQLException {
		bookInfoDao.newInstance();
		bookInfoDao.createDBConnection();
	}
	/**
	 * 本情報を追加する用の処理
	 *
	 * @param bookBean
	 * @throws SQLException
	 */
	public void insertBookInfo(BookBean bookBean) throws SQLException {
		try {
			System.out.println("bookInfoGet");
			bookInfoDao.addBookInfo(bookBean, SqlCostants.SQL_BOOK_ADD);
			bookInfoDao.closeDBConnection();
			System.out.println("addBookInfo");
		} catch (SQLException e) {
			System.out.println("error");
			throw e;
		}
	}

}