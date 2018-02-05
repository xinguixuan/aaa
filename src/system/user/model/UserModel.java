package system.user.model;

import java.math.BigDecimal;

public class UserModel extends UserLimit {
	private BigDecimal id;
	private String username;
	private String userpass;
	private String name;
	private BigDecimal sex;
	private String descr;
	private String birthdate;
	// 是否是管理员
	private BigDecimal isadmin;
	private String createtime;
	private String updatetime;
	private BigDecimal isdelete;
	private BigDecimal iseffect;

	private String birthdateStart;
	private String birthdateEnd;

	private String createtimeStart;
	private String createtimeEnd;

	private String updatetimeStart;
	private String updatetimeEnd;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSex() {
		return sex;
	}

	public void setSex(BigDecimal sex) {
		this.sex = sex;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public BigDecimal getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(BigDecimal isadmin) {
		this.isadmin = isadmin;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(BigDecimal isdelete) {
		this.isdelete = isdelete;
	}

	public BigDecimal getIseffect() {
		return iseffect;
	}

	public void setIseffect(BigDecimal iseffect) {
		this.iseffect = iseffect;
	}

	public String getBirthdateStart() {
		return birthdateStart;
	}

	public void setBirthdateStart(String birthdateStart) {
		this.birthdateStart = birthdateStart;
	}

	public String getBirthdateEnd() {
		return birthdateEnd;
	}

	public void setBirthdateEnd(String birthdateEnd) {
		this.birthdateEnd = birthdateEnd;
	}

	public String getCreatetimeStart() {
		return createtimeStart;
	}

	public void setCreatetimeStart(String createtimeStart) {
		this.createtimeStart = createtimeStart;
	}

	public String getCreatetimeEnd() {
		return createtimeEnd;
	}

	public void setCreatetimeEnd(String createtimeEnd) {
		this.createtimeEnd = createtimeEnd;
	}

	public String getUpdatetimeStart() {
		return updatetimeStart;
	}

	public void setUpdatetimeStart(String updatetimeStart) {
		this.updatetimeStart = updatetimeStart;
	}

	public String getUpdatetimeEnd() {
		return updatetimeEnd;
	}

	public void setUpdatetimeEnd(String updatetimeEnd) {
		this.updatetimeEnd = updatetimeEnd;
	}
}
