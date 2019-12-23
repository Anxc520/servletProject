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

public class selectServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String sql = req.getParameter("sql");
		String sql = new String(req.getParameter("sql").getBytes("iso-8859-1"), "utf-8");
		String auth = new String(req.getParameter("auth").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =null;
		user = serviceUser.selectUser(Integer.parseInt(auth));
			List<User> list = serviceUser.select(sql);
			HttpSession session = req.getSession();
			session.setAttribute("admin", user);
			req.setAttribute("list", list);
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("³É¹¦");
	}

}
