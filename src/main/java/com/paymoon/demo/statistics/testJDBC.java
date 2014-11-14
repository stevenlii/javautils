package com.paymoon.demo.statistics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class testJDBC {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			stmt =  conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			while(rs.next()) {
				System.out.println(rs.getString("deptno"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
					rs = null;
				}
				if(stmt!=null) {
					stmt.close();
					stmt = null;
				}
				if(conn!=null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}


 
