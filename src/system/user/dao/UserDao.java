 package system.user.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.user.model.UserModel;
import util.Creation;
import util.Jdbc;

public class UserDao {
	
	
	/**
	 * @param mm
	 * @return
	 * 添加数据
	 * 返回值为-1表示方法中有空值或出现异常
	 * 返回值为1时表示数据添加成功
	 * 返回值为0时表示数据添加失败
	 * @throws SQLException 
	 */
	public int insert(UserModel mm) throws SQLException {
		if(mm == null) {
			return -1;
		}
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		String name = mm.getName();
		BigDecimal sex = mm.getSex();
		String descr = mm.getDescr();
		String birthdate = mm.getBirthdate();
		BigDecimal isadmin = mm.getIsadmin();
		String createtime = mm.getCreatetime();
		BigDecimal isdelete = mm.getIsdelete();
		BigDecimal iseffect = mm.getIseffect();
		if(username == null || "".equals(username.trim())) {
			return -1;
		}
		if(userpass == null || "".equals(userpass.trim())) {
			return -1;
		}
		if(name == null || "".equals(name.trim())) {
			return -1;
		}
		if(sex == null) {
			return -1;
		}
		if(descr == null || "".equals(descr.trim())) {
			return -1;
		}
		if(birthdate == null || "".equals(birthdate.trim())) {
			return -1;
		}
		if(isadmin == null) {
			return -1;
		}
		if(createtime == null || "".equals(createtime.trim())) {
			return -1;
		}
		if(isdelete == null) {
			return -1;
		}
		if(iseffect == null) {
			return -1;
		}
		int a = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into zuoye.kaoshi (username , userpass , name , sex , descr , birthdate , isadmin , createtime , isdelete , iseffect) values (?,?,?,?,?,?,?,?,?,?);";
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpass);
			ps.setString(3, name);
			ps.setBigDecimal(4, sex);
			ps.setString(5, descr);
			ps.setString(6, birthdate);
			ps.setBigDecimal(7, isadmin);
			ps.setString(8, createtime);
			ps.setBigDecimal(9, isdelete);
			ps.setBigDecimal(10, iseffect);
			a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbc.closePreparedStatement(ps);
		}
		return -1; 
	}
	
	
	/**
	 * @param mm
	 * @return
	 * @throws SQLException 
	 * 通过id修改数据
	 * 返回值为-1时表示方法中有空值或者出现异常
	 * 返回值为1时表示修改成功
	 * 返回值为0时表示修改失败
	 */
	public int update(UserModel mm) throws SQLException {
		if(mm == null) {
			return -1;
		}
		BigDecimal id = mm.getId();
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		String name = mm.getName();
		BigDecimal sex = mm.getSex();
		String descr = mm.getDescr();
		String birthdate = mm.getBirthdate();
		BigDecimal isadmin = mm.getIsadmin();
		String createtime = mm.getCreatetime();
		String updatetime = mm.getUpdatetime();
		BigDecimal isdelete = mm.getIsdelete();
		BigDecimal iseffect = mm.getIseffect();
		if(id == null) {
			return -1;
		}
		if(username == null || "".equals(username.trim())) {
			return -1;
		}
		if(userpass == null || "".equals(userpass.trim())) {
			return -1;
		}
		if(name == null || "".equals(name.trim())) {
			return -1;
		}
		if(sex == null) {
			return -1;
		}
		if(descr == null || "".equals(descr.trim())) {
			return -1;
		}
		if(birthdate == null || "".equals(birthdate.trim())) {
			return -1;
		}
		if(isadmin == null) {
			return -1;
		}
		if(createtime == null || "".equals(createtime.trim())) {
			return -1;
		}
		if(updatetime == null || "".equals(updatetime.trim())) {
			return -1;
		}
		if(isdelete == null) {
			return -1;
		}
		if(iseffect == null) {
			return -1;
		}
		int a = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update zuoye.kaoshi set username = ? userpass = ? name = ? sex = ? descr = ? birthdate = ? isadmin = ? createtime = ? updatetime = ? isdelete = ? iseffect = ? where id = ? ";
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpass);
			ps.setString(3, name);
			ps.setBigDecimal(4, sex);
			ps.setString(5, descr);
			ps.setString(6, birthdate);
			ps.setBigDecimal(7, isadmin);
			ps.setString(8, createtime);
			ps.setString(9, updatetime);
			ps.setBigDecimal(10, isdelete);
			ps.setBigDecimal(11, iseffect);
			ps.setBigDecimal(12, id);
			a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbc.closePreparedStatement(ps);
		}
		return -1;
	}
	
	
	/**
	 * @param mm
	 * @return
	 * 多条件查找  
	 * 返回一个存有数据的集合
	 * 集合中存的是集合类型的对象
	 */
	public List<UserModel> select(UserModel mm) {
		if(mm == null) {
			return null;
		}
		BigDecimal id = mm.getId();
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		String name = mm.getName();
		BigDecimal sex = mm.getSex();
		String descr = mm.getDescr();
		String birthdateStart = mm.getBirthdateStart();
		String birthdateEnd = mm.getBirthdateEnd();
		BigDecimal isadmin = mm.getIsadmin();
		String createtimeStart = mm.getCreatetimeStart();
		String createtimeEnd = mm.getCreatetimeEnd();
		String updatetimeStart = mm.getUpdatetimeStart();
		String updatetimeEnd = mm.getUpdatetimeEnd();
		BigDecimal isdelete = mm.getIsdelete();
		BigDecimal iseffect = mm.getIseffect();
		ArrayList<Object> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select id , username , userpass , name , sex , descr , birthdate , isadmin , createtime , updatetime , isdelete , iseffect from zuoye.kaoshi where 1=1");
		if(id != null) {
			sql.append(" and id = ? ");
			list.add(id);
		}
		if(username != null && !"".equals(username.trim())) {
			sql.append(" and username = ? ");
			list.add(username);
		}
		if(userpass != null && !"".equals(userpass.trim())) {
			sql.append(" and userpass = ? ");
			list.add(userpass);
		}
		if(name != null && !"".equals(name.trim())) {
			sql.append(" and name like ? ");
			list.add("%"+name+"%");
		}
		if(sex != null) {
			sql.append(" and sex = ? ");
			list.add(sex);
		}
		if(descr != null && !"".equals(descr.trim())) {
			sql.append(" and descr like ? ");
			list.add("%"+descr+"%");
		}
		if(birthdateStart != null && !"".equals(birthdateStart.trim()) && birthdateEnd != null && !"".equals(birthdateEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(birthdateStart);
			list.add(birthdateEnd);
		}
		if(isadmin != null) {
			sql.append(" and isadmin = ? ");
			list.add(isadmin);
		}
		if(createtimeStart != null && !"".equals(createtimeStart.trim()) && createtimeEnd != null && !"".equals(createtimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(createtimeStart);
			list.add(createtimeEnd);
		}
		if(updatetimeStart != null && !"".equals(updatetimeStart.trim()) && updatetimeEnd != null && !"".equals(updatetimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(updatetimeStart);
			list.add(updatetimeEnd);
		}
		if(isdelete != null) {
			sql.append(" and isdelete = ? ");
			list.add(isdelete);
		}
		if(iseffect != null) {
			sql.append(" and iseffect = ? ");
			list.add(iseffect);
		}
		String sql1 = sql.toString();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserModel> userlist = new ArrayList<>();
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			for(int i = 0;i<list.size();i++) {
				ps.setObject(i+1, list.get(i));
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				userlist.add(Creation.add(rs));
			}
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Jdbc.closeResultSet(rs);
				Jdbc.closePreparedStatement(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * @param mm
	 * @return
	 * 多条件分页查询  
	 * 返回的是一个集合   
	 * 集合中存放的是UserModel类型的对象
	 */
	public List<UserModel> page_select(UserModel mm){
		if(mm == null) {
			return null;
		}
		BigDecimal id = mm.getId();
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		String name = mm.getName();
		BigDecimal sex = mm.getSex();
		String descr = mm.getDescr();
		String birthdateStart = mm.getBirthdateStart();
		String birthdateEnd = mm.getBirthdateEnd();
		BigDecimal isadmin = mm.getIsadmin();
		String createtimeStart = mm.getCreatetimeStart();
		String createtimeEnd = mm.getCreatetimeEnd();
		String updatetimeStart = mm.getUpdatetimeStart();
		String updatetimeEnd = mm.getUpdatetimeEnd();
		BigDecimal isdelete = mm.getIsdelete();
		BigDecimal iseffect = mm.getIseffect();
		Integer pageindex = mm.getPageindex();
		Integer pagesize = mm.getPagesize();
		ArrayList<Object> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select id , username , userpass , name , sex , descr , birthdateStart , birthdateEnd , isadmin , createtimeStart , createtimeEnd , updatetimeStart , updatetimeEnd , isdelete , iseffect from zuoye.kaoshi where 1=1");
		if(id != null) {
			sql.append(" and id = ? ");
			list.add(id);
		}
		if(username != null && !"".equals(username.trim())) {
			sql.append(" and username = ? ");
			list.add(username);
		}
		if(userpass != null && !"".equals(userpass.trim())) {
			sql.append(" and userpass = ? ");
			list.add(userpass);
		}
		if(name != null && !"".equals(name.trim())) {
			sql.append(" and name like ? ");
			list.add("%"+name+"%");
		}
		if(sex != null) {
			sql.append(" and sex = ? ");
			list.add(sex);
		}
		if(descr != null && !"".equals(descr.trim())) {
			sql.append(" and descr like ? ");
			list.add("%"+descr+"%");
		}
		if(birthdateStart != null && !"".equals(birthdateStart.trim()) && birthdateEnd != null && !"".equals(birthdateEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(birthdateStart);
			list.add(birthdateEnd);
		}
		if(isadmin != null) {
			sql.append(" and isadmin = ? ");
			list.add(isadmin);
		}
		if(createtimeStart != null && !"".equals(createtimeStart.trim()) && createtimeEnd != null && !"".equals(createtimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(createtimeStart);
			list.add(createtimeEnd);
		}
		if(updatetimeStart != null && !"".equals(updatetimeStart.trim()) && updatetimeEnd != null && !"".equals(updatetimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(updatetimeStart);
			list.add(updatetimeEnd);
		}
		if(isdelete != null) {
			sql.append(" and isdelete = ? ");
			list.add(isdelete);
		}
		if(iseffect != null) {
			sql.append(" and iseffect = ? ");
			list.add(iseffect);
		}
		if(pageindex != null && pagesize != null && pageindex > 0 && pagesize > 0) {
			sql.append(" limit ?,?" );
			list.add((pageindex-1)*pagesize);
			list.add(pagesize);
		}
		String sql1 = sql.toString();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserModel> userlist = new ArrayList<>();
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			for(int i = 0;i<list.size();i++) {
				ps.setObject(i+1, list.get(i));
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				userlist.add(Creation.add(rs));
			}
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Jdbc.closeResultSet(rs);
				Jdbc.closePreparedStatement(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * @param mm
	 * @return
	 * 返回是total值
	 */
	public int count_select(UserModel mm) {
		if(mm == null) {
			return -1;
		}
		BigDecimal id = mm.getId();
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		String name = mm.getName();
		BigDecimal sex = mm.getSex();
		String descr = mm.getDescr();
		String birthdateStart = mm.getBirthdateStart();
		String birthdateEnd = mm.getBirthdateEnd();
		BigDecimal isadmin = mm.getIsadmin();
		String createtimeStart = mm.getCreatetimeStart();
		String createtimeEnd = mm.getCreatetimeEnd();
		String updatetimeStart = mm.getUpdatetimeStart();
		String updatetimeEnd = mm.getUpdatetimeEnd();
		BigDecimal isdelete = mm.getIsdelete();
		BigDecimal iseffect = mm.getIseffect();
		ArrayList<Object> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select count(1) from zuoye.kaoshi where 1=1");
		if(id != null) {
			sql.append(" and id = ? ");
			list.add(id);
		}
		if(username != null && !"".equals(username.trim())) {
			sql.append(" and username = ? ");
			list.add(username);
		}
		if(userpass != null && !"".equals(userpass.trim())) {
			sql.append(" and userpass = ? ");
			list.add(userpass);
		}
		if(name != null && !"".equals(name.trim())) {
			sql.append(" and name like ? ");
			list.add("%"+name+"%");
		}
		if(sex != null) {
			sql.append(" and sex = ? ");
			list.add(sex);
		}
		if(descr != null && !"".equals(descr.trim())) {
			sql.append(" and descr like ? ");
			list.add("%"+descr+"%");
		}
		if(birthdateStart != null && !"".equals(birthdateStart.trim()) && birthdateEnd != null && !"".equals(birthdateEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(birthdateStart);
			list.add(birthdateEnd);
		}
		if(isadmin != null) {
			sql.append(" and isadmin = ? ");
			list.add(isadmin);
		}
		if(createtimeStart != null && !"".equals(createtimeStart.trim()) && createtimeEnd != null && !"".equals(createtimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(createtimeStart);
			list.add(createtimeEnd);
		}
		if(updatetimeStart != null && !"".equals(updatetimeStart.trim()) && updatetimeEnd != null && !"".equals(updatetimeEnd.trim())) {
			sql.append(" and between ? and ? ");
			list.add(updatetimeStart);
			list.add(updatetimeEnd);
		}
		if(isdelete != null) {
			sql.append(" and isdelete = ? ");
			list.add(isdelete);
		}
		if(iseffect != null) {
			sql.append(" and iseffect = ? ");
			list.add(iseffect);
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql1 = sql.toString();
		int a = 0;
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			for(int i = 0;i<list.size();i++) {
				ps.setObject(i+1, list.get(i));
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				a = rs.getInt(1);
			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
