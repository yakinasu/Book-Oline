package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BookInfoDao;
import model.BookBean;
import tool.SqlCostants;

public class BookHomeLogic {
	public BookBean forSearch = new BookBean();
	public ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	public BookInfoDao bookInfoDao = new BookInfoDao();

	public BookHomeLogic() throws SQLException {
		bookInfoDao.newInstance();
		bookInfoDao.createDBConnection();
	}


	/**
	 * 本情報の全検索結果を受け取る
	 *
	 * @return
	 */
	public ArrayList<HashMap<String, String>> searchBookdb() {
		try {
			list = bookInfoDao.searchBookInfo(SqlCostants.SQL_BOOK_SELECT);
			bookInfoDao.closeDBConnection();
			return list;
		} catch (Exception e) {
		}
		return null;
	}
}