package stu.dao;


import stu.model.User;
/**
 *  ���ݿ���ʲ�-
 *
 */
public interface UserDao {
	  
	  public boolean isLogin(User user);

		 /**
		  * �޸��û�������

		  */
		
		public int updateUserPassWord(User  user);
}
