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
//* @Description:转化率
//* @author lizhiqiang
//* @date 2014年11月13日 下午3:53:02
//*
// */
//public class TurnoverStatistics4_fullBUTEXCEPTION {
//
//	/**
//	 * @param args
//	 * @throws ClassNotFoundException
//	 */
//	public static void main(String[] args)  {
//		new TurnoverStatistics4_fullBUTEXCEPTION().connectDB2();
//	}
//
//	public static WritableWorkbook createEXCEL() {
//		String todayyyyMMdd = Util.calender();
//		String fileName = todayyyyMMdd + "交易统计.xls";
//		File file = new File(fileName);
//		WritableWorkbook wwb = null;
//		try {
//			wwb = Workbook.createWorkbook(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return wwb;
//	}
//
//	//数据库连接程序
//	public void connectDB2() {
//		Connection conn = null;
//		ResultSet rs = null;
//		Statement stmt = null;
//		WritableWorkbook wwb = createEXCEL();
//		try {
//
//			Class.forName("com.ibm.db2.jcc.DB2Driver");
//			conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/statdev:retrieveMessagesFromServerOnGetMessage=true;", "ucollatb", "ucollatb");
//			stmt =  conn.createStatement();
//
//			String tableSuf = Util.calender("yyMM");
//			//TODO 日期和  where TRANSDATE='" + todayyyyMMdd + "' and TRANSTATE=0 要加上
////			String transByBankid =  "select MERID,GOODSID,BANKID,SUM(AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_" + tableSuf + " where TRANSDATE='" + todayyyyMMdd + "' and TRANSTATE=0 group by MERID,GOODSID,BANKID";
//
//			String tradeStatisticsSQL =  "select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_" + tableSuf + " as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME";
//			rs = stmt.executeQuery(tradeStatisticsSQL);
//			turnoverStatistics(wwb,rs);
//
//			//转化率
//			String transRateSQL =  "select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME";
//			rs = stmt.executeQuery(transRateSQL);
//			transRate(wwb,stmt,rs);
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
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
//
//
//	}
//	//交易额统计
//	public void turnoverStatistics(WritableWorkbook wwb,ResultSet rs) {
//		String todayyyyMMdd = Util.calender();
//		String[] title = { "序号","商户","商户名称","商品","商品名称","省份银行","交易额（元）"};
//		// 获得开始时间
//		// 输出的excel的路径
//		// 批量导出
//		String sheetNameString = todayyyyMMdd + "日交易额";
//		// 添加第一个工作表并设置第一个Sheet的名字
//				try {
//					WritableSheet sheet = wwb.createSheet(sheetNameString, 0);
//					Label label;
//					for (int i = 0; i < title.length; i++) {
//						label = new Label(i, 0, title[i]);
//						// 将定义好的单元格添加到工作表中
//							sheet.addCell(label);
//					}
//					int col = 0;//列
//					int raw = 0;//行
//					while(rs.next()) {
//						//序号
//						raw++;
//						col=0;
//						label = new Label(col++, raw, String.valueOf(raw));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("MERID"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("MERNAME"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("GOODSID"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("GOODSNAME"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("BANKNAME"));
//						sheet.addCell(label);
//						String totalAmount = rs.getString("TOTALAMOUNT");
//						Double totalAmt = Double.parseDouble(totalAmount);
//						totalAmt = totalAmt/100;
//						label = new Label(col, raw, String.valueOf(totalAmt));
//						sheet.addCell(label);
//					}
//				} catch (RowsExceededException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (WriteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (NumberFormatException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	}
//	//转化率
//	/**
//	 *
//		 * ***************** TODO  *****************<br>
//		 * method name   :  transRate
//		 * @return		 :  void
//		 * @author       :  lizhiqiang 2014年11月13日下午6:26:51
//		 * description
//		 * 输出字段：
//		 * 订单数（ORDERSTATE=0，1，2，3）、支付数（ORDERSTATE ！= 0）、支付转化率8、支付失败数9（ORDERSTATE 3）、支付成功数10（ORDERSTATE=2）、支付成功率11、交易成功率12
//			*payRate支付转化率=支付数/订单数（）
//			*OrderSuccessRate支付成功率=支付成功数/支付数
//			*TradeSuccessRate交易成功率=支付成功数/订单数
//
//		 * **********************************************
//	 */
//	public void transRate(WritableWorkbook wwb,Statement stmt,ResultSet rs) {
//
//		String todayyyyMMdd = Util.calender();
//		String[] title = { "序号","商户","商户名称","商品","商品名称","省份银行","订单数","支付数","支付转化率","支付失败数","支付成功数","支付成功率","交易成功率"};
//		// 获得开始时间
//		// 输出的excel的路径
//		// 批量导出
//		String sheetNameString = todayyyyMMdd + "转化率统计";
//		// 添加第一个工作表并设置第一个Sheet的名字
//				try {
//					WritableSheet sheet = wwb.createSheet(sheetNameString, 1);
//					Label label;
//					for (int i = 0; i < title.length; i++) {
//						label = new Label(i, 0, title[i]);
//						// 将定义好的单元格添加到工作表中
//							sheet.addCell(label);
//					}
//					int col = 0;//列
//					int raw = 0;//行
//					while(rs.next()) {
//						//序号
//						raw++;
//						col=0;
//						label = new Label(0, raw, String.valueOf(raw));
//						sheet.addCell(label);
//						String merid = rs.getString("MERID");
//						label = new Label(1, raw, merid);
//						sheet.addCell(label);
//						label = new Label(2, raw, rs.getString("MERNAME"));
//						sheet.addCell(label);
//						String goodsid = rs.getString("GOODSID");
//						label = new Label(3, raw, goodsid);
//						sheet.addCell(label);
//						label = new Label(4, raw, rs.getString("GOODSNAME"));
//						sheet.addCell(label);
//						String bankname = rs.getString("BANKNAME");
//						label = new Label(5, raw, bankname);
//						sheet.addCell(label);
//
//						String orderCount = rs.getString("ORDERCOUNT");
//						int orderCt = Integer.parseInt(orderCount);
//						//订单数
//						int orderAll = orderCt;
//						label = new Label(6, raw, String.valueOf(orderCount));
//						sheet.addCell(label);
//				String transRateSQL = "select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.MERID='"+merid +"' and prim.GOODSID='"+goodsid+"' and prim.BANKNAME='"+bankname+"' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE";
//				ResultSet rtrans = stmt.executeQuery(transRateSQL);
//				//支付数
//				int orderPay = 0;
//				//失败数
//				int orderFailed = 0;
//				//成功数
//				int orderSuccess = 0;
//				while(rtrans.next()) {
//					String orderState = rtrans.getString("ORDERSTATE");
//					int orderCountDetail = Integer.parseInt(rtrans.getString("ORDERCOUNT"));
//
//					if (orderState.equals(2)) {
//						orderSuccess = orderCountDetail;
//					}else if (orderState.equals(3)) {
//						orderFailed = orderCountDetail;
//					}else if (!orderState.equals(0)) {
//						orderPay +=orderCountDetail;
//					}
//					label = new Label(10, raw, String.valueOf(orderSuccess));
//					sheet.addCell(label);
//					label = new Label(9, raw, String.valueOf(orderFailed));
//					sheet.addCell(label);
//				}
//				label = new Label(7, raw, String.valueOf(orderPay));
//				sheet.addCell(label);
//				//payRate支付转化率=支付数/订单数
//				String payRate = Util.percent(orderPay, orderAll);
//				label = new Label(8, raw, payRate);
//				sheet.addCell(label);
//				//OrderSuccessRate支付成功率=支付成功数/支付数
//				String OrderSuccessRate = Util.percent(orderSuccess, orderPay);
//				label = new Label(11, raw, OrderSuccessRate);
//				sheet.addCell(label);
//				//TradeSuccessRate交易成功率=支付成功数/订单数
//				String TradeSuccessRate = Util.percent(orderSuccess, orderAll);
//				label = new Label(12, raw, TradeSuccessRate);
//				sheet.addCell(label);
//					}
//				} catch (RowsExceededException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (WriteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (NumberFormatException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//	}
//
//}
//
//
//
//
//
//
