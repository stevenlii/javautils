package com.paymoon.demo.statistics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TurnoverStatisticsDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/mbldev:retrieveMessagesFromServerOnGetMessage=true;", "uhfbusia", "uhfbusia");
			stmt =  conn.createStatement();
			//    select sum(AMOUNT) total from  "UMPAY"."T_UPTRANS_1411" where TRANSDATE='20141105' and TRANSTATE=0
			rs = stmt.executeQuery("select * from UMPAY.T_UPORDER_0");
			while(rs.next()) {
				System.out.println(rs.getString("ORDERID"));
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


 

