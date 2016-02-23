package stu.controll;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.dao.impl.UserDaoImpl;
import stu.model.User;
import stu.util.StringUtil;
/**
 * ���Ʋ�
 * �����½��Ϣ
 *by HXC
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doPost(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");//Ϊ�������ͳһ����ΪUTF��8��Ȼ�������������⣿
		String username=req.getParameter("username").trim();//��ȡ�û�����ͬʱȥ���ո�
		String password=req.getParameter("password").trim();//��ȡ���벢ȥ���ո�
		String imageValue=req.getParameter("imageValue");//��ȡ��֤����Ϣ
		String remember=req.getParameter("remember");//�Ƿ�ѡ���ס����
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	 if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		 }//��isEmpty����ȷ���Ƿ������룬���һ���������������Ӧ��
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "��������֤��");
	 		req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "��֤�������");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}
		User user=new User(username,password);
		UserDaoImpl usersdao=new UserDaoImpl();
		session.setAttribute("username", username);	
		if(usersdao.isLogin(user)){
			if("remember-me".equals(remember)){
				rememberMe(username,password,resp);
			}
			resp.sendRedirect("main.jsp");
		}
		else{
			req.setAttribute("error", "�û��������������");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("login.jsp");
			requestdispatcher.forward(req, resp);
		}
		
	}

	
	private void rememberMe(String userName,String password,HttpServletResponse response){
		Cookie user;
		try {
			user = new Cookie("user",URLEncoder.encode(userName,"UTF-8")+"-"+URLEncoder.encode(password,"UTF-8"));
			user.setMaxAge(1*60*60*24*7);
			response.addCookie(user);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block �����û���Ϣ
			e.printStackTrace();
		}
	}
}
