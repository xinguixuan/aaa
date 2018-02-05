package system.user.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import system.user.dao.UserDao;
import system.user.model.UserModel;
import util.Constants;

public class UserService {
	
	private static UserDao ud = new UserDao();
	/**
	 * @param mm
	 * @return
	 * @throws SQLException
	 * ע���˺�
	 * ����ֵΪ-1ʱ��ʾ�������п�ֵ������쳣
	 * ����ֵΪ0ʱ��ʾ���ʧ��
	 * ����ֵΪ1ʱ��ʾ������ӳɹ�
	 * ����ֵΪ2ʱ��ʾ���˺��Ѵ���
	 */
	public int zhuce(UserModel mm) throws SQLException {
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
		
		// �ж�������˺��Ƿ����
		UserModel mm_insert_select = new UserModel();
		mm_insert_select.setUsername(username);
		if(ud.count_select(mm_insert_select) == 1) {
			return 2;
		}
		
		// ������ȡ�������µ�ʵ������
		// ȷ������������û�ж��������
		UserModel mm_insert = new UserModel();
		mm_insert.setUsername(username);
		mm_insert.setUserpass(userpass);
		mm_insert.setName(name);
		mm_insert.setSex(sex);
		mm_insert.setDescr(descr);
		mm_insert.setBirthdate(birthdate);
		mm_insert.setIsadmin(isadmin);
		mm_insert.setCreatetime(createtime);
		mm_insert.setIsdelete(isdelete);
		mm_insert.setIseffect(iseffect);
		
		return ud.insert(mm_insert);
	}
	
	
	
	/**
	 * @param mm
	 * @return
	 * ��¼�˺�
	 * ����ֵΪ-1ʱ��ʾ�������п�ֵ
	 * ����ֵΪ1ʱ��ʾ�˺Ż��������
	 * ����ֵΪ2ʱ��ʾ���˺��ѱ�ɾ��
	 * ����ֵΪ3ʱ��ʾ���˺���ʧЧ
	 * ����ֵΪ4ʱ��ʾ��¼�ɹ�
	 */
	public int denglu(UserModel mm) {
		if(mm == null) {
			return -1;
		}
		String username = mm.getUsername();
		String userpass = mm.getUserpass();
		if(username == null || "".equals(username.trim())) {
			return -1;
		}
		if(userpass == null || "".equals(userpass.trim())) {
			return -1;
		}
		
		UserModel mm_denglu = new UserModel();
		mm_denglu.setUsername(username);
		mm_denglu.setUserpass(userpass);
		List<UserModel> list = ud.select(mm_denglu);
		// �ж��˺Ż������Ƿ���ȷ
		// ��������������ݱ�ʾ�˺�������ȷ
		if(list.size() != 1) {
			return 1;
		}
		
		// �жϴ��˺��Ƿ�ɾ��
		if(list.get(0).getIsdelete() == Constants.DELETE_Y) {
			return 2;
		}
		
		// �жϴ��˺��Ƿ�ʧЧ
		if(list.get(0).getIseffect() == Constants.EFFECT_N) {
			return 3;
		}
		return 4;
	}
	
	
	/**
	 * @param mm
	 * @return
	 * ��������ѯ
	 * ����һ������
	 * ����ֵΪnull��ʱ���ʾ��ѯ���������
	 */
	public List<UserModel> select(UserModel mm){
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
		
		UserModel mm_select = new UserModel();
		mm_select.setId(id);
		mm_select.setUsername(username);
		mm_select.setUserpass(userpass);
		mm_select.setName(name);
		mm_select.setSex(sex);
		mm_select.setDescr(descr);
		mm_select.setBirthdateStart(birthdateStart);
		mm_select.setBirthdateEnd(birthdateEnd);
		mm_select.setIsadmin(isadmin);
		mm_select.setCreatetimeStart(createtimeStart);
		mm_select.setCreatetimeEnd(createtimeEnd);
		mm_select.setUpdatetimeStart(updatetimeStart);
		mm_select.setUpdatetimeEnd(updatetimeEnd);
		mm_select.setIsdelete(isdelete);
		mm_select.setIseffect(iseffect);
		mm_select.setPageindex(pageindex);
		mm_select.setPagesize(pagesize);
		
		List<UserModel> list = ud.page_select(mm_select);
		if(list.size() == 0) {
			return null;
		}
		return list;
	}
	
	
	/**
	 * @param mm
	 * @return
	 * �õ�totalֵ
	 */
	public int total_select(UserModel mm) {
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
		Integer pageindex = mm.getPageindex();
		Integer pagesize = mm.getPagesize();
		
		UserModel mm_select = new UserModel();
		mm_select.setId(id);
		mm_select.setUsername(username);
		mm_select.setUserpass(userpass);
		mm_select.setName(name);
		mm_select.setSex(sex);
		mm_select.setDescr(descr);
		mm_select.setBirthdateStart(birthdateStart);
		mm_select.setBirthdateEnd(birthdateEnd);
		mm_select.setIsadmin(isadmin);
		mm_select.setCreatetimeStart(createtimeStart);
		mm_select.setCreatetimeEnd(createtimeEnd);
		mm_select.setUpdatetimeStart(updatetimeStart);
		mm_select.setUpdatetimeEnd(updatetimeEnd);
		mm_select.setIsdelete(isdelete);
		mm_select.setIseffect(iseffect);
		mm_select.setPageindex(pageindex);
		mm_select.setPagesize(pagesize);
		return ud.count_select(mm_select);
	}
}
