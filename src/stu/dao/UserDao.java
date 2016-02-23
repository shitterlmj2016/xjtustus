package stu.dao;


import stu.model.User;
/**
 *  数据库访问层-
 *
 */
public interface UserDao {
	  
	  public boolean isLogin(User user);

		 /**
		  * 修改用户的密码

		  */
		
		public int updateUserPassWord(User  user);
}
