package stu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.dao.StudentDao;
import stu.dao.impl.StudentDaoImpl;
import stu.model.Student;

/**
 *���Ʋ�
 *����ѧ����Ϣ
 *by���ĳ�
 */
public class AddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}//doGetֱ�ӵ���doPost����

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����һ��Student(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		String stuName = request.getParameter("stuName");
		String stuSex = request.getParameter("stuSex");
		String stuAge = request.getParameter("stuAge");
		Long stuTel = Long.parseLong(request.getParameter("stuTel"));
		String stuDept = request.getParameter("stuDept");
		String stuAddress = request.getParameter("stuAddress");
		Student stu = new Student(stuName, stuSex, stuAge, stuTel, stuDept,
				stuAddress);
		StudentDao studao = new StudentDaoImpl();
		boolean flag = studao.addStudent(stu);
		if (flag && !(stuTel == null) && !"".equals(stuTel)) {
			request.setAttribute("msg", "�ɹ������Ϣ");
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
			System.out.println("���ʧ�ܣ���������׽������");
		}

	}

}
