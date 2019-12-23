package com.test.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.www.po.User;
import com.test.www.service.ServiceUser;

/**
 * 
    * @ClassName: UpdateUser
    * @Description: 更新用户信息
    * @author Anxc
    * @date 2019年8月23日
    *
 */
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		//String classes = req.getParameter("class");
		//String number = req.getParameter("number");
		//String sex = req.getParameter("sex");
		//String tel =req.getParameter("tel");
		String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		String name = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		String classes =new String(req.getParameter("class").getBytes("iso-8859-1"), "utf-8");
		String number = new String(req.getParameter("number").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String tel = new String(req.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
		String authority =new String(req.getParameter("authority").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		String auth = new String(req.getParameter("auth").getBytes("iso-8859-1"), "utf-8");
		User user1 =null;
		user1 = serviceUser.selectUser(Integer.parseInt(auth));
		HttpSession session = req.getSession();
		session.setAttribute("admin", user1);
		//赋值初始化
		user.setId(Integer.parseInt(id));
		user.setU_username(name);
		user.setU_password(password);
		user.setU_classes(classes);
		user.setU_number(number);
		user.setU_sex(sex);
		user.setU_tel(tel);
		user.setU_authority(authority);
		System.out.println("------查看当前值："+user.toString());
		//调用函数
		boolean flag = serviceUser.updateUser(user);
		String JDBCInfo = "error";
		if(flag) {
		
			if("0".equals(user1.getU_authority())) {
				session.setAttribute("user", user);
				req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
			}else {
				List<User> list = serviceUser.userList();
				req.setAttribute("list", list);
				req.getRequestDispatcher("hello.jsp").forward(req, resp);
			}
			
		}
		else {
			resp.getWriter().write(JDBCInfo);
			System.out.println("error");
		}
		
	}

}
