package com.test.www.service;

import java.util.List;

import com.test.www.dao.UserDao;
import com.test.www.po.User;

/**
 * 
    * @ClassName: Service
    * @Description: �м�㣬Ŀǰû��ʵ�ʵ����ã�֪ʶ���𽻽Ӵ���
    * @author Anxc
    * @date 2019��8��22��
    *
 */
public class ServiceUser {
	
	UserDao userDao = new UserDao();
	/**
	 * 
	    * @Title: LoginUser
	    * @Description:��½���ܵ�ʵ��
	    * @param @param user
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean LoginUser(User user) {
		
		return  userDao.loginUser(user);
	}
	
	/**
	 * 
	    * @Title: InsertUser
	    * @Description: ע���û�����
	    * @param @param user
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean InsertUser(User user) {
		
		return  userDao.InsertUser(user);
	}
	
	/**
	 * 
	    * @Title: userList
	    * @Description: �û�һ����Ļ�ȡ
	    * @param @return    ����
	    * @return List<User>    ��������
	    * @throws
	 */
	public List<User> userList(){
	
		return userDao.userList();
	}
	/**
	 * 
	    * @Title: updateUser
	    * @Description: �����û���Ϣ
	    * @param @param user
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(int name) {
		return userDao.deleteUser(name);
	}
	
	public User selectUser(int name) {
		return userDao.selectUser(name);
	}
	
	public List<User> select(String sql) {
		return userDao.select(sql);
	}
}
