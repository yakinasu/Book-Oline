package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BookInfoDao;
import model.BookBean;
import tool.PropertiesUtil;
import tool.SqlCostants;

public class BookUpdateLogic {
	public BookBean forSearch = new BookBean();
	public ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	public BookInfoDao bookInfoDao = new BookInfoDao();
	public PropertiesUtil propertiesUtil = new PropertiesUtil();
	public BookUpdateLogic() throws SQLException {
//		bookInfoDao.newInstance();
//		bookInfoDao.createDBConnection();
	}


	/**
	 * 主キーを与えて本情報を更新する
	 *
	 * @param key
	 * @param isbn
	 * @param record
	 */

	public void updateBookdb(String key, String isbn, String record) {
		try {
			//XXX デモ用に作成
			//bookInfoDao.newInstance();
			bookInfoDao.createDBConnection();
			bookInfoDao.serchBookInfoByIsbn(SqlCostants.SQL_BOOK_SEARCH_FOR_UPDATE, isbn);
			//propertiesUtil.createInstance();
			Thread.sleep(10000);
			System.out.println(key);
			if (key.equals("tytle")) {
				System.out.println(key);
				bookInfoDao.updateBookInfo(SqlCostants.SQL_BOOK_UPDATE_TITLE, record, isbn);
				System.out.println(record);
			}
			if (key.equals("page")) {
				bookInfoDao.updateBookInfo(SqlCostants.SQL_BOOK_UPDATE_PAGE, record, isbn);
			}
			if (key.equals("author")) {
				bookInfoDao.updateBookInfo(SqlCostants.SQL_UPDATE_AUTHOR, record, isbn);
			}
			// コネクション　終了
			bookInfoDao.closeDBConnection();
		} catch (Exception e) {

		}
	}

}