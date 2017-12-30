package logic;

import java.sql.SQLException;
import java.util.HashMap;

import dao.BookInfoDao;
import model.BookBean;
import tool.SqlCostants;

public class BookSearchLogic {
	public BookBean bookBean = new BookBean();
	public HashMap<String, String> hashMap = new HashMap<String, String>();
	public BookInfoDao bookInfoDao = new BookInfoDao();

	public BookSearchLogic() throws SQLException {
		bookInfoDao.newInstance();
		bookInfoDao.createDBConnection();
	}

	/**
	 * 検索したい本情報を取得する
	 *
	 * @param isbn
	 * @return
	 */
	public BookBean selectBookdb(String isbn) {
		try {
			hashMap = bookInfoDao.serchBookInfoByIsbn(SqlCostants.SQL_BOOK_SEARCH, isbn);
			convertMapToBookBean(hashMap);
			bookInfoDao.closeDBConnection();
		} catch (Exception e) {
			try {
				bookInfoDao.commitDB();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bookBean;
	}

	private void convertMapToBookBean(HashMap<String, String> hashMap) {
		bookBean.setIsbn(hashMap.get("isbn"));
		bookBean.setAuthor(hashMap.get("author"));
		bookBean.setTotalPage(hashMap.get("page"));
		bookBean.setBookTytle(hashMap.get("tytle"));
	}


}