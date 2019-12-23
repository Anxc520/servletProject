package com.test.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.www.po.User;
import com.test.www.service.ServiceUser;

/**
 * 
    * @ClassName: RegisterUser
    * @Description: 注册页面
    * @author Anxc
    * @date 2019年8月22日
    *
 */
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		//String classes = req.getParameter("class");
		//String number = req.getParameter("number");
		//String sex = req.getParameter("sex");
		//String tel =req.getParameter("tel");
		String name = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		String classes =new String(req.getParameter("class").getBytes("iso-8859-1"), "utf-8");
		String number = new String(req.getParameter("number").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String tel = new String(req.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
		String authority ="0"; 
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//赋值初始化
		user.setU_username(name);
		user.setU_password(password);
		user.setU_classes(classes);
		user.setU_number(number);
		user.setU_sex(sex);
		user.setU_tel(tel);
		user.setU_authority(authority);
		
		//调用函数
		boolean flag = serviceUser.InsertUser(user);
		String JDBCInfo = "error";
		if(flag) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("成功");
		}
		else {
			resp.getWriter().write(JDBCInfo);
			System.out.println("error");
		}
	}

}
