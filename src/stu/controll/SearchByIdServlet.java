package stu.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.dao.impl.StudentDaoImpl;
import stu.model.Student;

/**
 * 控制层
 * 根据ID查询用户信息
 * by HXC
 */
public class SearchByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String id=request.getParameter("searchId");
         StudentDaoImpl userdao=new StudentDaoImpl();
         Student student=userdao.findStudentById(id);
         request.setAttribute("student", student);
         String mainPage = "showstudent.jsp";
 		 request.setAttribute("mainPage", mainPage);
 		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
 		 dispatcher.forward(request, response);
	}

}
