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

		// ��֤��
		if ("yzm".equals(action)) {
			// �õ���֤��ͼƬ
			RenderedImage image = getImg();
			// ���õ���ͼƬд�ص���ҳ��
			ImageIO.write(image, "jpg", response.getOutputStream());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		UserModel mm = new UserModel();
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		
		// ͨ��url��ʽ����Ա���
		if ("zhucesex".equals(action)) {
			sex(request, response);
		}
		
		
		// ͨ��url��ʽ��ù������
		if("zhlb".equals(action)) {
			isadmin(request, response);
		}
		
		
		// ͨ��url��ʽ����Ƿ�ɾ��
		if("sfsc".equals(action)) {
			isdelect(request, response);
		}
		
		// ͨ��url��ʽ����Ƿ���Ч
		if("sfsx".equals(action)) {
			iseffect(request, response);
		}
		
		
		// ע���˺�
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

		// ��¼�˺�
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
	 *             ͨ����̨��ȡ�Ա����Ů��ID
	 */
	private static void sex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");// ��ֹ����
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
	 * ��ȡ�û������Ϣ  
	 * ����Ա����ͨ�û�
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
	 * ����û��Ƿ��ѱ�ɾ������Ϣ
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
	 * ����˻��Ƿ���Ч��Ϣ
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
	 *             �ж���֤���Ƿ���ȷ
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
	 *             �õ���֤��ͼƬ
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
	 *             ע����ͨ�û��˺�
	 */
	private static void zhuce(HttpServletRequest request, HttpServletResponse response, UserModel mm)
			throws NoSuchAlgorithmException, SQLException, IOException {

		int a = 0;

		// ��ȡϵͳʱ��
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

		// ��������м���
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
			out.println("���ڿ�ֵ");
			out.flush();
			out.close();
			break;
		case 1:
			out.println("ע��ɹ�");
			out.flush();
			out.close();
			break;
		case 0:
			out.println("ע��ʧ��");
			out.flush();
			out.close();
			break;
		case 2:
			out.println("�˺��Ѵ���");
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
	 * @throws IOException��
	 *             ��¼�˺�
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
			out.println("�����д��ڿ�ֵ");
			out.flush();
			out.close();
			break;
		case 1:
			out.println("�˺Ż��������");
			out.flush();
			out.close();
			break;
		case 2:
			out.println("���˺��ѱ�ɾ��");
			out.flush();
			out.close();
			break;
		case 3:
			out.println("���˺���ʧЧ");
			out.flush();
			out.close();
			break;
		case 4:
			out.println("��¼�ɹ�");
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
