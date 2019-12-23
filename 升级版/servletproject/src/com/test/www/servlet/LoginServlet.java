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
    * @ClassName: LoginServlet
    * @Description: 登陆的servlet类
    * @author Anxc
    * @date 2019年8月22日
    *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("username");
		//String number  = req.getParameter("number");
		String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		if(username==null||"".equals(username)||null==password||"".equals(password)) {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}else {
		
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//赋值初始化
		user.setU_username(username);
		user.setU_number(password);
		
		//调用函数
		boolean flag = serviceUser.LoginUser(user);
		String JDBCInfo = "error";
//		权限说明： 0：普通用户，1：一般用户可以查看别人的信息，但只能修改自己的信息， 2:对所有用户都有修改删除功能
		if(flag) {
			List<User> list = serviceUser.userList();
			req.setAttribute("list", list);
			for(User user1:list) {
				if(username.equals(user1.getU_username())&&password.equals(user1.getU_password())) {
					user = user1;
					HttpSession session = req.getSession();
					session.setAttribute("admin", user1);
					if("0".equals(user1.getU_authority())) {
						req.setAttribute("user", user1);
						req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
					}
					break;
				}
			}
			if(!"0".equals(user.getU_authority())) {
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("成功");
			}
		}
		else {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}
		}
		
		
	}

}

