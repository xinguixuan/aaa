package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import system.user.model.UserModel;

public class Creation {
	public static UserModel add (ResultSet rs) throws SQLException {
		UserModel uu = new UserModel();
		uu.setId(rs.getBigDecimal("id"));
		uu.setUsername(rs.getString("username"));
		uu.setUserpass(rs.getString("userpass"));
		uu.setName(rs.getString("name"));
		uu.setSex(rs.getBigDecimal("sex"));
		uu.setDescr(rs.getString("descr"));
		uu.setBirthdate(rs.getString("birthdate"));
		uu.setIsadmin(rs.getBigDecimal("isadmin"));
		uu.setCreatetime(rs.getString("createtime"));
		uu.setUpdatetime(rs.getString("updatetime"));
		uu.setIsdelete(rs.getBigDecimal("isdelete"));
		uu.setIseffect(rs.getBigDecimal("iseffect"));
		return uu;
	}
}
