package cn.anxcyun.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;

public class selectServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String sql = req.getParameter("sql");
		String sql = new String(req.getParameter("sql").getBytes("iso-8859-1"), "utf-8");;
		System.out.println("-----------sql:"+sql);
		ServiceUser serviceUser = new ServiceUser();
		
			List<User> list = serviceUser.select(sql);
			req.setAttribute("list", list);
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("³É¹¦");
	}

}
