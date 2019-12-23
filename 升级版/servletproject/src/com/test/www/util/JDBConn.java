package com.test.www.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConn {
	
	public static Connection conn = null;
	private static final String url="jdbc:mysql://localhost:3306/servlettest?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
	private static final String user="root";
	private static final String password="root";
	
	public static Connection ConnJDBC() {
		
		try {
//			加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//连接
			conn = DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
