//package com.paymoon.demo.statistics;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
///**
// *
//* @ClassName: TurnoverStatistics6
//* @Description:优化5基本版本[SQL.log]
//* @author lizhiqiang
//* @date 2014年11月14日 14:21:54
//*
// */
//public class TurnoverStatistics8 {
//
//	private static final Logger log = LogManager.getLogger();
//	/**
//	 * @param args
//	 * @throws ClassNotFoundException
//	 */
//	public static void main(String[] args)  {
//		new TurnoverStatistics8().connectDB2();
////		MailSend.send();
//	}
//
//	public static WritableWorkbook createEXCEL() {
//		String todayyyyMMdd = Util.calender();
//		log.info("执行日期：" + todayyyyMMdd);
//		String fileName = todayyyyMMdd + "交易统计.xls";
//
//		File file = new File(fileName);
//		WritableWorkbook wwb = null;
//
//		try {
//			wwb = Workbook.createWorkbook(file);
//		} catch (IOException e) {
//			log.error("createEXCEL error!");
//		}
//		return wwb;
//	}
//
//	//数据库连接程序
//	public void connectDB2() {
//		Connection conn = null;
//		ResultSet rs = null;
//		Statement stmt = null;
//		Statement stmt2 = null;
//		WritableWorkbook wwb = createEXCEL();
//		try {
//
//			Class.forName("com.ibm.db2.jcc.DB2Driver");
//			conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/statdev:retrieveMessagesFromServerOnGetMessage=true;", "ucollatb", "ucollatb");
//			stmt =  conn.createStatement();
//			stmt2 =  conn.createStatement();
//
//			String tableSuf = Util.calender("yyMM");
//			String todayyyyMMdd = Util.calender();
//
//			Map<String, String> queryMap = new HashMap<String, String>();
//			//统计分析
//			String tradeStatisticsSQL =  "select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, trans.PLATORDID,count(trans.transtate) as TRANSCOUNT,sum(trans.amount) as TOTALAMOUNT	"
//										+"from ( "
//										+"select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.PLATORDID, t.amount, max(t.INTIME) initime from UMPAY.T_UPTRANS_" + tableSuf + " as t "
//										+"where t.transdate='" + todayyyyMMdd + "' group by t.merid,t.goodsid,t.bankid,t.PLATORDID,t.TRANSDATE,t.TRANSTATE,t.amount	"
//										+") trans "
//										+"left join umpay.t_mer_inf mer on trans.merid=mer.merid	"
//										+"left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid	"
//										+"left join umpay.t_bank_inf bank on trans.bankid=bank.bankid	"
//										+"where trans.transdate='" + todayyyyMMdd + "'	"
//										+"group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate,trans.PLATORDID";
//			rs = stmt.executeQuery(tradeStatisticsSQL);
//			turnoverStatistics(wwb,rs, queryMap);
//
//			//转化率
//			String transRateSQL =  "select o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname, count(o.orderstate) as ORDERCOUNT,sum(amount) as TOTALAMOUNT  from umpay.T_UPORDER_" + tableSuf + " o left join umpay.t_mer_inf mer on o.merid=mer.merid left join umpay.t_goods_inf goods on o.merid=goods.merid and o.goodsid=goods.goodsid left join umpay.t_bank_inf bank on o.bankid=bank.bankid  where o.orderdate='" + todayyyyMMdd + "' group by o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname";
//			rs = stmt.executeQuery(transRateSQL);
//			transRate(wwb,stmt2,rs, queryMap);
//
//
//		} catch (ClassNotFoundException e) {
//			log.error(e);
//		} catch (SQLException e) {
//			log.error(e);
//		}
//		finally {
//			try {
//
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
//				if (wwb != null) {
//					wwb.write();
//					wwb.close();
//					wwb = null;
//				}
//			} catch (SQLException e) {
//				log.error("SQL运行出错！");
//			} catch (IOException e) {
//				log.error(e);
//			} catch (WriteException e) {
//				log.error("WritableWorkbook 写入出错！");
//			}
//
//		}
//
//
//	}
//	//交易额统计
//	public void turnoverStatistics(WritableWorkbook wwb,ResultSet rs, Map<String, String> queryMap ) {
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
//					List<String> platordidList = new ArrayList<String>();
//					while(rs.next()){
//						// 筛选去重
//						String platordid = trim(rs.getString("platordid"));
//						if(platordidList.contains(platordid)){
//
//							continue;
//						}
//
//						platordidList.add(platordid);
//						String merid = rs.getString("MERID").trim();
//						String goodsid = rs.getString("GOODSID").trim();
//						String bankid = rs.getString("BANKID").trim();
//						String reKey = trim(merid+"_"+goodsid+"_"+bankid);
//
//						String totalAmount = rs.getString("TOTALAMOUNT");
//						//交易额
//						Double totalAmt = Double.parseDouble(totalAmount);
//						//非成功交易额
//						totalAmt = (double) 0;
//						String transtate = rs.getString("TRANSTATE");
//						String trancount = rs.getString("TRANSCOUNT");
//						String key = merid+"-"+goodsid+"-"+bankid+"-"+transtate;
//						if (transtate.equals("0")) {
//							//交易成功
//							queryMap.put(merid+"-"+goodsid+"-"+bankid+"-trans0", trancount);
//							//成功交易额
//							totalAmt = totalAmt/100;
//
//						}else{
//							//交易失败
//							String failKey = merid+"-"+goodsid+"-"+bankid+"-trans-1";
//							String failNum = queryMap.get(failKey);
//							if ( failNum == null) {
//								queryMap.put(failKey, trancount);
//							}else {
//								failNum = String.valueOf(Long.valueOf(failNum) + Long.valueOf(trancount));
//								queryMap.put(failKey, failNum);
//							}
//						}
//						if (transtate != null) {
//							//全部支付数
//							String transAll = trancount;
//							String transAllKey = merid+"-"+goodsid+"-"+bankid+"-trans99";
//
//							if (queryMap == null || !(queryMap.containsKey(transAllKey))) {
//								queryMap.put(transAllKey, transAll);
//							}else if (queryMap.containsKey(transAllKey)) {
//								long oldCount = Long.parseLong(queryMap.get(transAllKey));
//								long trancountLong = Long.parseLong(trancount);
//								transAll = String.valueOf(oldCount + trancountLong);
//								queryMap.put(transAllKey, transAll);
//							}
//						}
//						if(platordidList.contains(reKey)){
//							continue;
//						}
//						platordidList.add(reKey);
//						//序号
//						raw++;
//						col=0;
//						label = new Label(col++, raw, String.valueOf(raw));
//						sheet.addCell(label);
//						label = new Label(col++, raw, merid);
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("MERNAME"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, goodsid);
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("GOODSNAME"));
//						sheet.addCell(label);
//						label = new Label(col++, raw, rs.getString("BANKNAME"));
//						sheet.addCell(label);
//						//最终交易额操作
//						label = new Label(col, raw, String.valueOf(totalAmt));
//						sheet.addCell(label);
//					}
//				} catch (RowsExceededException e) {
//					log.error("sheet 写入 label 行处理错误");
//				} catch (WriteException e) {
//					log.error(e);
//				} catch (NumberFormatException e) {
//					log.error("数据格式出错！");
//					e.printStackTrace();
//				} catch (SQLException e) {
//					log.error("SQL运行出错！");
//					e.printStackTrace();
//				}
//	}
//	/**
//	 *
//		 * ***************** 转化率  *****************<br>
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
//	public void transRate(WritableWorkbook wwb,Statement stmt,ResultSet rs, Map<String, String> queryMap) {
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
//					int raw = 0;//行
//					List<String> platordidList = new ArrayList<String>();
//					while(rs.next()){
//						// 筛选去重
//						String merid = rs.getString("MERID").trim();
//						String goodsid = rs.getString("GOODSID").trim();
//						String bankid = rs.getString("BANKID").trim();
//						String reKey = trim(merid+"_"+goodsid+"_"+bankid);
//						if(platordidList.contains(reKey)){
//							continue;
//						}
//						platordidList.add(reKey);
//						//序号
//						raw++;
//						label = new Label(0, raw, String.valueOf(raw));
//						sheet.addCell(label);
//
//
//						label = new Label(1, raw, merid);
//						sheet.addCell(label);
//						label = new Label(2, raw, rs.getString("MERNAME"));
//						sheet.addCell(label);
//
//						label = new Label(3, raw, goodsid);
//						sheet.addCell(label);
//						label = new Label(4, raw, rs.getString("GOODSNAME"));
//						sheet.addCell(label);
//						String bankname = rs.getString("BANKNAME");
//
//
//						label = new Label(5, raw, bankname);
//						sheet.addCell(label);
//
//						String orderCount = rs.getString("ORDERCOUNT");
//
//						Long orderCt = Long.parseLong(orderCount);
//						//订单数
//						Long orderAll = orderCt;
//						queryMap.put(merid+"-"+goodsid+"-"+bankid+"-order99", orderCount);
//						label = new Label(6, raw, String.valueOf(orderCount));
//						sheet.addCell(label);
//				//支付数
//				String orderPayKey = merid + "-" + goodsid + "-" + bankid+ "-trans99";
//				Long orderPay = 0L;
//				if (queryMap.get(orderPayKey)!= null) {
//
//					orderPay = Long.parseLong(queryMap.get(orderPayKey));
//				}
//				//失败数
//				String orderFailedKey = merid + "-" + goodsid + "-" + bankid+ "-trans-1";
//				Long orderFailed = 0L;
//				if (queryMap.get(orderFailedKey)!= null) {
//
//					orderFailed = Long.parseLong(queryMap.get(orderFailedKey));
//				}
//				//成功数
//				String orderSuccessKey = merid + "-" + goodsid + "-" + bankid+ "-trans0";
//				Long orderSuccess = 0L;
//				if (queryMap.get(orderSuccessKey)!= null) {
//
//					orderSuccess = Long.parseLong(queryMap.get(orderSuccessKey));
//				}
//
//				label = new Label(9, raw, String.valueOf(orderFailed));
//				sheet.addCell(label);
//				label = new Label(10, raw, String.valueOf(orderSuccess));
//				sheet.addCell(label);
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
//					log.error("sheet 写入 label 行处理错误");
//				} catch (WriteException e) {
//					log.error(e);
//				} catch (NumberFormatException e) {
//					e.printStackTrace();
//					log.error("数据格式出错！");
//				} catch (SQLException e) {
//					log.error("SQL运行出错！");
//				}
//
//	}
//	private static String trim(String s){
//		return s == null ? "" : s.trim();
//	}
//}
//
//
//
//
//
//
