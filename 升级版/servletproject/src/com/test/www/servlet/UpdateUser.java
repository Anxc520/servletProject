package com.test.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.www.po.User;
import com.test.www.service.ServiceUser;

public class UpdateUser extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =null;
		user = serviceUser.selectUser(Integer.parseInt(id));
		
		if(user.getU_username()!=null) {
			String auth = new String(req.getParameter("auth").getBytes("iso-8859-1"), "utf-8");
			User user1 =null;
			user1 = serviceUser.selectUser(Integer.parseInt(auth));
			HttpSession session = req.getSession();
			session.setAttribute("admin", user1);
			req.setAttribute("user", user);
			req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
			System.out.println("³É¹¦");
		}
		else {
			resp.getWriter().write("error");
			System.out.println("error");
		}
		
	}
}
