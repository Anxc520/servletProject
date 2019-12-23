package com.test.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.test.www.po.User;
import com.test.www.util.JDBConn;

public class UserDao {
	
//	��½����ʵ��
	public boolean loginUser(User user) {
		
		boolean flag=false;//Ĭ�ϵ�½ʧ��
		String sql= "select count(1) from User where u_username=? and u_password=?;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		
		try {
			//ִ��sql
			prestatement= conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_username());
			prestatement.setString(2, user.getU_number());
			ResultSet rs = prestatement.executeQuery();
			//��ȡ��һ��
			while(rs.next()) {
				int result = rs.getInt(1);
				if(result>=1) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				//�ر�����
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
	
//	ע�Ṧ��ʵ��
	public boolean InsertUser(User user) {
		boolean flag=false;//Ĭ��ע��ʧ��
		String sql= "insert into User values(null,?,?,?,?,?,?,?);";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		
		try {
			//ִ��sql
			prestatement= conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_username());
			prestatement.setString(2, user.getU_password());
			prestatement.setString(3, user.getU_classes());
			prestatement.setString(4, user.getU_number());
			prestatement.setString(5, user.getU_sex());
			prestatement.setString(6, user.getU_tel());
			prestatement.setString(7, user.getU_authority());
			
			//��ȡ�޸ĵ�����
			int count = prestatement.executeUpdate();
			if(count>=1) {
				flag =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				//�ر�����
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	�����û���Ϣ
	public boolean updateUser(User user) {
		
		boolean flag = false;
		Connection conn=JDBConn.ConnJDBC();
		String sql = "update user set u_username=?,u_password=?,u_class=?,u_number=?,u_sex=?,u_tel=?,u_authority=? where id=?";
		PreparedStatement prestatement  =null;
		
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_username());
			prestatement.setString(2, user.getU_password());
			prestatement.setString(3, user.getU_classes());
			prestatement.setString(4, user.getU_number());
			prestatement.setString(5, user.getU_sex());
			prestatement.setString(6, user.getU_tel());
			prestatement.setString(7, user.getU_authority());
			prestatement.setInt(8, user.getId());
			
			int count = prestatement.executeUpdate();
			if(count >=1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	�û�һ����
	public List<User> userList(){
		List<User> userlist = new LinkedList<User>();
		String sql= "select * from User;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		User user;
		
		try {
			prestatement = conn.prepareStatement(sql);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setU_username(rs.getString(2));
				user.setU_password(rs.getString(3));
				user.setU_classes(rs.getString(4));
				user.setU_number(rs.getString(5));
				user.setU_sex(rs.getString(6));
				user.setU_tel(rs.getString(7));
				user.setU_authority(rs.getString(8));
				userlist.add(user);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}
	
//	ɾ���û���Ϣ
	public boolean deleteUser(int id) {
		boolean flag = false;
		Connection conn=JDBConn.ConnJDBC();
		String sql = "delete from user where id=? ";
		PreparedStatement prestatement  =null;
		
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setInt(1, id);

			int count = prestatement.executeUpdate();
			if(count >=1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	��ѯ�û���Ϣ��update�ĵ�һ���������û����õ���bean
	public User selectUser(int id) {
		
		User user = new User();
		String sql= "select * from user where id=?;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setInt(1, id);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setU_username(rs.getString(2));
				user.setU_password(rs.getString(3));
				user.setU_classes(rs.getString(4));
				user.setU_number(rs.getString(5));
				user.setU_sex(rs.getString(6));
				user.setU_tel(rs.getString(7));
				user.setU_authority(rs.getString(8));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

//	���ֲ�ѯ��ģ���;�ȷ��
	public List<User> select(String sql) {
		List<User> userlist = new LinkedList<User>();
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		User user;
		
		try {
			prestatement = conn.prepareStatement("select * from user"+sql);
			System.out.println("select * from user"+sql);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setU_username(rs.getString(2));
				user.setU_password(rs.getString(3));
				user.setU_classes(rs.getString(4));
				user.setU_number(rs.getString(5));
				user.setU_sex(rs.getString(6));
				user.setU_tel(rs.getString(7));
				user.setU_authority(rs.getString(8));
				userlist.add(user);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}
	
}
