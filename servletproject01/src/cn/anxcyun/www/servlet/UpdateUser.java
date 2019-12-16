package cn.anxcyun.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;

public class UpdateUser extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =null;
		
		user = serviceUser.selectUser(name);
		
		
		if(user.getU_name()!=null) {
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
