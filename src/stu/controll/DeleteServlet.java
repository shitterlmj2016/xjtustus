package stu.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.dao.StudentDao;
import stu.dao.impl.StudentDaoImpl;
/**
 * ���Ʋ�
 * ɾ������ 
 *by���ĳ�
 */
public class DeleteServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}//doGetֱ�ӵ���doPost����

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao studao = new StudentDaoImpl();
	
		String id=request.getParameter("id");
		int d=Integer.parseInt(id);
		boolean flag=studao.delStudent(d);
		//���ɾ���ɹ������ص�displaystudent.jspҳ�棬������ɹ������û���ʾ��Ϣ
		if(flag){
			RequestDispatcher dispatch=request.getRequestDispatcher("showAllStudents");
			dispatch.forward(request, response);
		}else{
			 System.out.println("ɾ��ʧ����");
		}
	}

}