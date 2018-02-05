package init;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import util.Constants;
public class StartUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		ResourceBundle jdbc = ResourceBundle.getBundle("jdbc");
		String driverClass = jdbc.getString("driverClass");
		String url = jdbc.getString("url");
		String username = jdbc.getString("username");
		String password = jdbc.getString("password");
		if(driverClass == null || "".equals(driverClass)) {
			return;
		}
		if(url == null || "".equals(url)) {
			return;
		}
		if(username == null || "".equals(username)) {
			return;
		}
		if(password == null || "".equals(password)) {
			return;
		}
		
		Constants.DRIVERCLASS = driverClass;
		Constants.URL = url;
		Constants.USERNAME = username;
		Constants.PASSWORD = password;
		
		ResourceBundle prop = ResourceBundle.getBundle("prop");
		String birthdateStart = prop.getString("birthdateStart");
		String birthdateEnd = prop.getString("birthdateEnd");
		String createtimeStart = prop.getString("createtimeStart");	
		String createtimeEnd = prop.getString("createtimeEnd");
		String updatetimeStart = prop.getString("updatetimeStart");
		String updatetimeEnd = prop.getString("updatetimeEnd");
		String ssex_m = prop.getString("sex_m");
		String ssex_w = prop.getString("sex_w");
		String sadmin_g = prop.getString("admin_g");
		String sadmin_p = prop.getString("admin_p");
		String sdelete_y = prop.getString("delete_y");
		String sdelete_n = prop.getString("delete_n");
		String seffect_y = prop.getString("effect_y");
		String seffect_n = prop.getString("effect_n");

		
		String sex_m_name = prop.getString("sex_m_name");
		String sex_w_name = prop.getString("sex_w_name");
		String admin_g_name = prop.getString("admin_g_name");
		String admin_p_name = prop.getString("admin_p_name");
		String delete_y_name = prop.getString("delete_y_name");
		String delete_n_name = prop.getString("delete_n_name");
		String effect_y_name = prop.getString("effect_y_name");
		String effect_n_name = prop.getString("effect_n_name");
		try {
			sex_m_name = new String(sex_m_name.getBytes("ISO-8859-1"),"utf-8");
			sex_w_name = new String(sex_w_name.getBytes("ISO-8859-1"),"utf-8");
			admin_g_name = new String(admin_g_name.getBytes("ISO-8859-1"),"utf-8");
			admin_p_name = new String(admin_p_name.getBytes("ISO-8859-1"),"utf-8");
			delete_y_name = new String(delete_y_name.getBytes("ISO-8859-1"),"utf-8");
			delete_n_name = new String(delete_n_name.getBytes("ISO-8859-1"),"utf-8");
			effect_y_name = new String(effect_y_name.getBytes("ISO-8859-1"),"utf-8");
			effect_n_name = new String(effect_n_name.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		if(birthdateStart == null || "".equals(birthdateStart)) {
			return;
		}
		if(birthdateEnd == null || "".equals(birthdateEnd)) {
			return;
		}
		if(createtimeStart == null || "".equals(createtimeStart)) {
			return;
		}
		if(createtimeEnd == null || "".equals(createtimeEnd)) {
			return;
		}
		if(updatetimeStart == null || "".equals(updatetimeStart)) {
			return;
		}
		if(updatetimeEnd == null || "".equals(updatetimeEnd)) {
			return;
		}
		if(sex_m_name == null || "".equals(sex_m_name)) {
			return;
		}
		if(sex_w_name == null || "".equals(sex_w_name)) {
			return;
		}
		if(admin_g_name == null || "".equals(admin_g_name)) {
			return;
		}
		if(admin_p_name == null || "".equals(admin_p_name)) {
			return;
		}
		if(delete_y_name == null || "".equals(delete_y_name)) {
			return;
		}
		if(delete_n_name == null || "".equals(delete_n_name)) {
			return;
		}
		if(effect_y_name == null || "".equals(effect_y_name)) {
			return;
		}
		if(effect_n_name == null || "".equals(effect_n_name)) {
			return;
		}
		
		
		if(ssex_m == null || "".equals(ssex_m)) {
			return;
		}
		if(ssex_w == null || "".equals(ssex_w)) {
			return;
		}
		if(sadmin_g == null || "".equals(sadmin_g)) {
			return;
		}
		if(sadmin_p == null || "".equals(sadmin_p)) {
			return;
		}
		if(sdelete_y == null || "".equals(sdelete_y)) {
			return;
		}
		if(sdelete_n == null || "".equals(sdelete_n)) {
			return;
		}
		if(seffect_y == null || "".equals(seffect_y)) {
			return;
		}
		if(seffect_n == null || "".equals(seffect_n)) {
			return;
		}
		BigDecimal sex_m = new BigDecimal(ssex_m);
		BigDecimal sex_w = new BigDecimal(ssex_w);
		BigDecimal admin_g = new BigDecimal(sadmin_g);
		BigDecimal admin_p = new BigDecimal(sadmin_p);
		BigDecimal delete_y = new BigDecimal(sdelete_y);
		BigDecimal delete_n = new BigDecimal(sdelete_n);
		BigDecimal effect_y = new BigDecimal(seffect_y);
		BigDecimal effect_n = new BigDecimal(seffect_n);
		Constants.SEX_M_NAME = sex_m_name;
		Constants.SEX_W_NAME = sex_w_name;
		Constants.SEX_M = sex_m;
		Constants.SEX_W = sex_w;
		Constants.ADMIN_G = admin_g;
		Constants.ADMIN_P = admin_p;
		Constants.DELETE_Y = delete_y;
		Constants.DELETE_N = delete_n;
		Constants.EFFECT_Y = effect_y;
		Constants.EFFECT_N = effect_n;
		Constants.BIRTHDATESTART = birthdateStart;
		Constants.BIRTHDATEEND = birthdateEnd;
		Constants.CREATETIMESTART = createtimeStart;
		Constants.CREATETIMEND = createtimeEnd;
		Constants.UPDATETIMESTART = updatetimeStart;
		Constants.UPDATETIMEEND = updatetimeEnd;
		
		Constants.ADMIN_G_NAME = admin_g_name;
		Constants.ADMIN_P_NAME = admin_p_name;
		Constants.DELETE_Y_NAME = delete_y_name;
		Constants.DELETE_N_NAME = delete_n_name;
		Constants.EFFECT_Y_NAME = effect_y_name;
		Constants.EFFECT_N_NAME = effect_n_name;
	}
}
