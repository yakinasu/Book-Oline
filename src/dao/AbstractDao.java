package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDao {
	public java.sql.Connection conn = null;
	private String driver;
	private String url;
	private String user;
	private String password;

	/**
	 * コンストラクタ
	 *
	 * @param driver
	 *            ドライバー
	 * @param url
	 *            URL
	 * @param user
	 *            ユーザー名
	 * @param password
	 *            パスワード
	 */
	public AbstractDao(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 引数なしのコンストラクタ 既定値を使用する
	 */
	public AbstractDao() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/BookInfodb";
		user = "root";
		password = "";
	}

	/**
	 * Mysqlに接続する
	 *
	 * @throws SQLException
	 */
	public void newInstance() throws SQLException {
		String msg = "";
		try {
			Class.forName(driver).newInstance();
			msg = "ドライバのロードに成功しました";
		} catch (ClassNotFoundException e) {
			msg = "ドライバのロードに失敗しました";
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}

	public void createDBConnection() throws SQLException {
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// 何もしない
			e.printStackTrace();
		}
	}

	public void closeDBConnection() throws SQLException {
		System.out.println("************SQL connection Close******");
		// TODO connのnullcheck
		this.commitDB();
		conn.close();
	}

	public void commitDB() throws SQLException {
		try {
			// コミット
			System.out.println("*********SQL Commit************");
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void setParamater(PreparedStatement ps, String... paramaters) {
		int num = 1;
		try {
			for (String para : paramaters) {
				ps.setString(num++, para);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
