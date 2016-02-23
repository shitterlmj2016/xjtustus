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
 * 控制层
 * 处理登陆信息
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
		req.setCharacterEncoding("utf-8");//为解决乱码统一设置为UTF—8，然而好像还是有问题？
		String username=req.getParameter("username").trim();//获取用户名的同时去掉空格
		String password=req.getParameter("password").trim();//获取密码并去掉空格
		String imageValue=req.getParameter("imageValue");//获取验证码信息
		String remember=req.getParameter("remember");//是否选择记住密码
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	 if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		 }//用isEmpty方法确认是否有输入，如果一个都不输入就无响应。
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "请输入验证码");
	 		req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "验证码错误了");
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
			req.setAttribute("error", "用户名或密码错误了");
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
			// TODO Auto-generated catch block 保留用户信息
			e.printStackTrace();
		}
	}
}
