package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBean;

public class UserInfoDao extends AbstractDao {

	/**
	 * User情報を新しく追加する
	 *
	 * @param sql
	 * @param userBean
	 * @throws SQLException
	 */
	public void addUserInfo(String sql, UserBean userBean) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		this.setParamater(ps, userBean.getName(), userBean.getPassword());
		ps.executeQuery();
	}
}
