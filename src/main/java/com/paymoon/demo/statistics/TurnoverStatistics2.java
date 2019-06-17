//package com.paymoon.demo.statistics;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//
//public class TurnoverStatistics2 {
//
//	/**
//	 * @param args
//	 * @throws ClassNotFoundException
//	 */
//	public static void main(String[] args)  {
//
//		String todayyyyMMdd = Util.calender();
//		String[] title = { "序号","商户","商品","省份银行","交易额（元）"};
//		String fileName = todayyyyMMdd + "交易统计.xls";
//		// 获得开始时间
//				// 输出的excel的路径
//				// 批量导出
//				String sheetNameString = todayyyyMMdd + "日交易额";
//
//				File file = new File(fileName);
//				WritableWorkbook wwb = null;
//
//
//
//				Connection conn = null;
//				ResultSet rs = null;
//				Statement stmt = null;
//		try {
//			wwb = Workbook.createWorkbook(file);
//			// 添加第一个工作表并设置第一个Sheet的名字
//			WritableSheet sheet = wwb.createSheet(sheetNameString, 0);
//			Label label;
//			for (int i = 0; i < title.length; i++) {
//				label = new Label(i, 0, title[i]);
//				// 将定义好的单元格添加到工作表中
//				sheet.addCell(label);
//
//			}
//			Class.forName("com.ibm.db2.jcc.DB2Driver");
//			conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/mbldev:retrieveMessagesFromServerOnGetMessage=true;", "uhfbusia", "uhfbusia");
//			stmt =  conn.createStatement();
//
//			String tableSuf = Util.calender("yyMM");
////			String transByBankid =  "select MERID,GOODSID,BANKID,SUM(AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_" + tableSuf + " where TRANSDATE='" + todayyyyMMdd + "' and TRANSTATE=0 group by MERID,GOODSID,BANKID";
//			String transByBankid =  "select MERID,GOODSID,BANKID,SUM(AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_" + tableSuf + " group by MERID,GOODSID,BANKID";
//
//			rs = stmt.executeQuery(transByBankid);
//			int col = 0;//列
//			int raw = 0;//行
//			while(rs.next()) {
//				//序号
//				raw++;
//				col=0;
//				label = new Label(col++, raw, String.valueOf(raw));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("MERID"));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("GOODSID"));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("BANKID"));
//				sheet.addCell(label);
//				String totalAmount = rs.getString("TOTALAMOUNT");
//				Double totalAmt = Double.parseDouble(totalAmount);
//				totalAmt = totalAmt/100;
//				label = new Label(col, raw, String.valueOf(totalAmt));
//				sheet.addCell(label);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("create wwb failed!");
//			e.printStackTrace();
//		} catch (RowsExceededException e) {
//			// TODO Auto-generated catch block
//			System.out.println("write wwb failed!");
//			e.printStackTrace();
//		} catch (WriteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				wwb.write();
//				wwb.close();
//				if(rs!=null) {
//					rs.close();
//					rs = null;
//				}
//				if(stmt!=null) {
//					stmt.close();
//					stmt = null;
//				}
//				if(conn!=null) {
//					conn.close();
//					conn = null;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (WriteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}
//}
//
