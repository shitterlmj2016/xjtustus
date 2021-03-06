package stu.dao;


import stu.model.Student;

/**
 * 数据访问层，学生信息CRUD操作
 * @author DY1101shaoyuxian
 */

import java.util.List;

public interface StudentDao {
	
	/**
	 * 获取指定的用戶(更新页面操作使用)
	 * 
	 * @param id
	 * @return stu
	 */
	public Student findStudentByid(int id);
		

	/**
	 * 添加学生信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean addStudent(Student stu);

	/**
	 * 删除学生信息
	 * 
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(int id);

	/**
	 * 更新学生信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateStudent(Student stu);

	/**
	 * 查询全体学生信息
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List StSelect();
	/**
	 * 根据ID查询学生信息
	 * 
	 * @return Student
	 */
	 public Student findStudentById(String id); 

}
