package stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import stu.dao.UserDao;
import stu.model.User;
import stu.util.DbConn;
/**
 *  ���ݿ���ʲ�
 *
 */
public class UserDaoImpl implements UserDao {
	private Connection conn = DbConn.getConn();
	//��½�û���֤
	  public boolean isLogin(User user){
		  boolean flag=false;
		  String sql="select * from t_manager where username=? and password=?";
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, user.getUsername());//�Դ��������û�����������з�װ
			pmst.setString(2, user.getPassword());
			ResultSet rs=pmst.executeQuery();
			if(rs.next()){
				flag=true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	  
	  }

		 /**
		  * �޸��û�������
		  * @param page
		  * @return
		  */
		
		public int updateUserPassWord(User  user) {
			int a=0;
			String sql = "update t_manager set password=? where username=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getUsername());
				a= pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return a;
		}
}