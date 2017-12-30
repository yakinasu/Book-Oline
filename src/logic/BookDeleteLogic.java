package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BookInfoDao;
import model.BookBean;
import tool.SqlCostants;

public class BookDeleteLogic {
	public BookBean forSearch = new BookBean();
	public ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	public BookInfoDao bookInfoDao = new BookInfoDao();

	public BookDeleteLogic() throws SQLException {
		bookInfoDao.newInstance();
		bookInfoDao.createDBConnection();
	}

	/**
	 * 本情報を削除する
	 *
	 * @param isbn
	 */
	public void deleteBookdb(String isbn) {
		try {
			System.out.println("削除を行います。");
			bookInfoDao.deleteBookInfo(SqlCostants.SQL_BOOK_DELETE, isbn);
			System.out.println("コネクションをクローズします");
			bookInfoDao.closeDBConnection();
		} catch (Exception e) {
		}
	}

}