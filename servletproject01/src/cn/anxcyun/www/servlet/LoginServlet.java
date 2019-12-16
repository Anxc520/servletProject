package cn.anxcyun.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;
/**
 * 
    * @ClassName: LoginServlet
    * @Description: ��½��servlet��
    * @author Anxc
    * @date 2019��8��22��
    *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("username");
		//String number  = req.getParameter("number");
		String name = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String number = new String(req.getParameter("number").getBytes("iso-8859-1"), "utf-8");
		
		
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//��ֵ��ʼ��
		user.setU_name(name);
		user.setU_number(number);
		
		//���ú���
		boolean flag = serviceUser.LoginUser(user);
		String JDBCInfo = "error";
		if(flag) {
			List<User> list = serviceUser.userList();
			req.setAttribute("list", list);
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("�ɹ�");
		}
		else {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}
		
		
		
	}

}

