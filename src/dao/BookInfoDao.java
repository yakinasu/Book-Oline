package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.BookBean;

public class BookInfoDao extends AbstractDao {

	/**
	 * 本情報をデータベースに追加する
	 *
	 * @param bookBean
	 * @param sql
	 * @throws SQLException
	 */
	public void addBookInfo(BookBean bookBean, String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			this.setParamater(ps, bookBean.getIsbn(), bookBean.getBookTytle(), bookBean.getTotalPage(),
					bookBean.getAuthor());
			System.out.println(ps);
			System.out.println("setFinish");
			System.out.println(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 本情報を全検索する 検索済みのものはListにして返す
	 *
	 * @param isbn
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<HashMap<String, String>> searchBookInfo(String sql) throws SQLException {

		Statement stmt = conn.createStatement();
		return this.getResultList(stmt.executeQuery(sql));

	}

	/**
	 * 本情報を主キーを渡して削除する
	 *
	 * @param sql
	 * @param deleteKey
	 * @throws SQLException
	 */
	public void deleteBookInfo(String sql, String deleteKey) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		this.setParamater(ps, deleteKey);
		System.out.println(sql);
		System.out.println(deleteKey);
		ps.executeUpdate();
	}

	/**
	 * 本情報を更新する
	 *
	 * @param sql
	 * @param field
	 * @param newData
	 * @param isbn
	 * @throws SQLException
	 */
	public void updateBookInfo(String sql, String newData, String isbn) {
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
		this.setParamater(ps, newData, isbn);
		System.out.println(sql);
		System.out.println(newData);
		System.out.println(isbn);
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ISBNを指定して検索
	 * @throws SQLException
	 */
	public HashMap<String, String> serchBookInfoByIsbn (String sql, String isbn) {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			this.setParamater(ps, isbn);
			list = this.getResultList(ps.executeQuery());
			System.out.println(sql);
			if (list.isEmpty()) {
				return null;
			}
		} catch (SQLException e) {
			try {
				System.out.println("***roleBack***");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
		return list.get(0);
	}

	private ArrayList<HashMap<String, String>> getResultList(ResultSet rs) throws SQLException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		while (rs.next()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.clear();
			map.put("isbn", rs.getString("isbn"));
			map.put("tytle", rs.getString("tytle"));
			map.put("page", rs.getString("page"));
			map.put("author", rs.getString("author"));
			list.add(map);
		}
		return list;
	}
}
