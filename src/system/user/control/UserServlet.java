package system.user.control;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import system.user.model.UserModel;
import system.user.service.UserService;
import util.Constants;
import util.Md5;
import util.VerificationCode;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		// 验证码
		if ("yzm".equals(action)) {
			// 得到验证码图片
			RenderedImage image = getImg();
			// 将得到的图片写回到网页上
			ImageIO.write(image, "jpg", response.getOutputStream());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		UserModel mm = new UserModel();
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		
		// 通过url方式获得性别常量
		if ("zhucesex".equals(action)) {
			sex(request, response);
		}
		
		
		// 通过url方式获得管理类别
		if("zhlb".equals(action)) {
			isadmin(request, response);
		}
		
		
		// 通过url方式获得是否删除
		if("sfsc".equals(action)) {
			isdelect(request, response);
		}
		
		// 通过url方式获得是否生效
		if("sfsx".equals(action)) {
			iseffect(request, response);
		}
		
		
		// 注册账号
		if ("zhuce".equals(action)) {
			if (getCode(request, response) == 0) {
				out.println("1");
				out.flush();
				out.close();
				return;
			}
			try {
				zhuce(request, response, mm);
			} catch (NoSuchAlgorithmException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 登录账号
		if ("denglu".equals(action)) {
			if (getCode(request, response) == 0) {
				out.println("1");
				out.flush();
				out.close();
				return;
			}
			try {
				denglu(request, response, mm);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param response
	 * @throws IOException
	 *             通过后台获取性别和男女的ID
	 */
	private static void sex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");// 防止乱码
		response.setContentType("text/html;charset=utf-8");
		ArrayList<Map<String, String>> list = new ArrayList<>();
		Map<String, String> mm1 = new HashMap<>();
		mm1.put("id", Constants.SEX_M.toString());
		mm1.put("text", Constants.SEX_M_NAME);
		list.add(mm1);
		Map<String, String> mm2 = new HashMap<>();
		mm2.put("id", Constants.SEX_W.toString());
		mm2.put("text", Constants.SEX_W_NAME);
		list.add(mm2);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * 获取用户类别信息  
	 * 管理员和普通用户
	 */
	private static void isadmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Map<String,String>> list = new ArrayList<>();
		Map<String , String> mm1 = new HashMap<>();
		mm1.put("id", Constants.ADMIN_G.toString());
		mm1.put("text", Constants.ADMIN_G_NAME);
		Map<String , String> mm2 = new HashMap<>();
		mm2.put("id", Constants.ADMIN_P.toString());
		mm2.put("text", Constants.ADMIN_P_NAME);
		list.add(mm1);
		list.add(mm2);
		JSONArray json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * 获得用户是否已被删除的信息
	 */
	private static void isdelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Map<String,String>> list = new ArrayList<>();
		Map<String,String> mm1 = new HashMap<>();
		mm1.put("id", Constants.DELETE_Y.toString());
		mm1.put("text", Constants.DELETE_Y_NAME);
		Map<String,String> mm2 = new HashMap<>();
		mm2.put("id",Constants.DELETE_N.toString());
		mm2.put("text", Constants.DELETE_N_NAME);
		list.add(mm1);
		list.add(mm2);
		JSONArray json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * 获得账户是否生效信息
	 */
	private static void iseffect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Map<String,String>> list = new ArrayList<>();
		Map<String,String> mm1 = new HashMap<>();
		mm1.put("id", Constants.EFFECT_Y.toString());
		mm1.put("text",Constants. EFFECT_Y_NAME);
		Map<String,String> mm2 = new HashMap<>();
		mm2.put("id", Constants.EFFECT_N.toString());
		mm2.put("text", Constants.EFFECT_N_NAME);
		list.add(mm1);
		list.add(mm2);
		JSONArray json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	
	/**
	 * @return
	 * @throws IOException
	 *             判断验证码是否正确
	 */
	private static int getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String yzm = request.getParameter("yzm");
		String code = VerificationCode.getCode();
		if (code.equals(yzm)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * @return
	 * @throws IOException
	 *             得到验证码图片
	 */
	private static BufferedImage getImg() throws IOException {
		return VerificationCode.getImg();
	}

	/**
	 * @param request
	 * @param response
	 * @param mm
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 * @throws IOException
	 *             注册普通用户账号
	 */
	private static void zhuce(HttpServletRequest request, HttpServletResponse response, UserModel mm)
			throws NoSuchAlgorithmException, SQLException, IOException {

		int a = 0;

		// 获取系统时间
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);

		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String name = request.getParameter("name");
		String ssex = request.getParameter("sex");
		String descr = request.getParameter("descr");
		String birthdate = request.getParameter("birthdate");
		BigDecimal isadmin = Constants.ADMIN_P;
		String createtime = time;
		BigDecimal isdelete = Constants.DELETE_N;
		BigDecimal iseffect = Constants.EFFECT_Y;

		if (ssex == null || "".equals(ssex.trim())) {
			return;
		}
		BigDecimal sex = new BigDecimal(ssex);

		// 将米面进行加密
		if (userpass == null || "".equals(userpass.trim())) {
			return;
		}
		String newpass = Md5.jiami(userpass);
		UserModel mm_zhuce = new UserModel();
		mm_zhuce.setUsername(username);
		mm_zhuce.setUserpass(newpass);
		mm_zhuce.setName(name);
		mm_zhuce.setSex(sex);
		mm_zhuce.setDescr(descr);
		mm_zhuce.setBirthdate(birthdate);
		mm_zhuce.setIsadmin(isadmin);
		mm_zhuce.setCreatetime(createtime);
		mm_zhuce.setIsdelete(isdelete);
		mm_zhuce.setIseffect(iseffect);
		UserService us = new UserService();
		a = us.zhuce(mm_zhuce);
		PrintWriter out = response.getWriter();
		switch (a) {
		case -1:
			out.println("存在空值");
			out.flush();
			out.close();
			break;
		case 1:
			out.println("注册成功");
			out.flush();
			out.close();
			break;
		case 0:
			out.println("注册失败");
			out.flush();
			out.close();
			break;
		case 2:
			out.println("账号已存在");
			out.flush();
			out.close();
			break;
		}
	}


	/**
	 * @param request
	 * @param response
	 * @param mm
	 * @throws NoSuchAlgorithmException
	 * @throws IOException、
	 *             登录账号
	 */
	public static void denglu(HttpServletRequest request, HttpServletResponse response, UserModel mm)
			throws NoSuchAlgorithmException, IOException {

		int a = 0;

		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		if (mm == null || "".equals(userpass.trim())) {
			return;
		}
		String newpass = Md5.jiami(userpass);
		UserModel mm_denglu = new UserModel();
		mm_denglu.setUsername(username);
		mm_denglu.setUserpass(newpass);
		UserService us = new UserService();
		a = us.denglu(mm_denglu);
		PrintWriter out = response.getWriter();
		switch (a) {
		case -1:
			out.println("方法中存在空值");
			out.flush();
			out.close();
			break;
		case 1:
			out.println("账号或密码错误");
			out.flush();
			out.close();
			break;
		case 2:
			out.println("此账号已被删除");
			out.flush();
			out.close();
			break;
		case 3:
			out.println("此账号已失效");
			out.flush();
			out.close();
			break;
		case 4:
			out.println("登录成功");
			out.flush();
			out.close();
			break;
		default:
			break;
		}
	}
	
	private static void select (HttpServletRequest request, HttpServletResponse response) {
		String sid = request.getParameter("id");
		BigDecimal id = new BigDecimal("sid");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String ssex = request.getParameter("sex");
		BigDecimal sex = new BigDecimal("ssex"); 
		String descr = request.getParameter("descr");
		String birthdateStart = request.getParameter("birthdateStart");
		String birthdateEnd = request.getParameter("birthdateEnd");
		String sisadmin = request.getParameter("isadmin");
		BigDecimal isadmin = new BigDecimal("sisadmin");
		String createtimeStart = request.getParameter("createtimeStart");
		String createtimeEnd = request.getParameter("createtimeEnd");
		String updatetimeStart = request.getParameter("updatetimeStart");
		String updatetimeEnd = request.getParameter("updatetimeEnd");
		String sisdelete = request.getParameter("isdelete");
		BigDecimal isdelete = new BigDecimal("sisdelete");
		String siseffect = request.getParameter("iseffect");
		BigDecimal iseffect = new BigDecimal("siseffect");
		String pageindex = request.getParameter("pageindex");
		String pagesize = request.getParameter("pagesize");
		
		
	}
}
