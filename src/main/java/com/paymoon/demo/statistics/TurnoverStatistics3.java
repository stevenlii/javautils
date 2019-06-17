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
///**
// *
//* @ClassName: TurnoverStatistics3
//* @Description: 优化EXCEL文件格式，更改数据库用户ucollatb
//* @author lizhiqiang
//* @date 2014年11月13日 下午3:53:02
//*
// */
//public class TurnoverStatistics3 {
//
//	/**
//	 * @param args
//	 * @throws ClassNotFoundException
//	 */
//	public static void main(String[] args)  {
//
//		String todayyyyMMdd = Util.calender();
//		String[] title = { "序号","商户","商户名称","商品","商品名称","省份银行","交易额（元）"};
//		String fileName = todayyyyMMdd + "交易统计.xls";
//		// 获得开始时间
//		// 输出的excel的路径
//		// 批量导出
//		String sheetNameString = todayyyyMMdd + "日交易额";
//
//		File file = new File(fileName);
//		WritableWorkbook wwb = null;
//
//		Connection conn = null;
//		ResultSet rs = null;
//		Statement stmt = null;
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
//			conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/statdev:retrieveMessagesFromServerOnGetMessage=true;", "ucollatb", "ucollatb");
//			stmt =  conn.createStatement();
//
//			String tableSuf = Util.calender("yyMM");
//			//TODO 日期和  where TRANSDATE='" + todayyyyMMdd + "' and TRANSTATE=0 要加上
////			String transByBankid =  "select MERID,GOODSID,BANKID,SUM(AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_" + tableSuf + " where TRANSDATE='" + todayyyyMMdd + "' and TRANSTATE=0 group by MERID,GOODSID,BANKID";
//			String tradeStatisticsSQL =  "select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_" + tableSuf + " as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME";
//
//			rs = stmt.executeQuery(tradeStatisticsSQL);
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
//				label = new Label(col++, raw, rs.getString("MERNAME"));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("GOODSID"));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("GOODSNAME"));
//				sheet.addCell(label);
//				label = new Label(col++, raw, rs.getString("BANKNAME"));
//				sheet.addCell(label);
//				String totalAmount = rs.getString("TOTALAMOUNT");
//				Double totalAmt = Double.parseDouble(totalAmount);
//				totalAmt = totalAmt/100;
//				label = new Label(col, raw, String.valueOf(totalAmt));
//				sheet.addCell(label);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("create wwb failed!");
//			e.printStackTrace();
//		} catch (RowsExceededException e) {
//			System.out.println("write wwb failed!");
//			e.printStackTrace();
//		} catch (WriteException e) {
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
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (WriteException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}
//}
//
//
//
//
