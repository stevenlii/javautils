package com.paymoon.demo.statistics;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ConversionRate2 {
	private static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) throws SQLException {
		ConversionRate2 conversionRate = new ConversionRate2();
		conversionRate.exportTradeVolume("20141112");
	}
	
	private void exportTradeVolume(String dataDate)  throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = this.getConn();
			
			StringBuffer transBuffer = new StringBuffer();
			
			transBuffer.append(" select trans.platordid, trans.merid, trans.goodsid, trans.bankid, trans.transtate, trans.amount");
			transBuffer.append(" from umpay.T_UPTRANS_1411 trans");
			transBuffer.append(" where trans.transdate=?");
			transBuffer.append(" order by trans.intime desc");
			
			ps = conn.prepareStatement(transBuffer.toString());
			
			ps.setString(1, dataDate);
			
			rs = ps.executeQuery();
			
			Map<String, Long> succPayCountMap = new HashMap<String, Long>();
			Map<String, Double> succPayAmountMap = new HashMap<String, Double>();
			
			Map<String, Long> payCountMap = new HashMap<String, Long>();
			
			Map<String, String> nameMap = new HashMap<String, String>();
			
			List<String> platordidList = new ArrayList<String>();
			while(rs.next()){
				// 筛选去重
				String platordid = trim(rs.getString("platordid"));
				if(platordidList.contains(platordid)){
					continue;
				}
				platordidList.add(platordid);
				
				String merid = trim(rs.getString("merid"));
				String goodsid = trim(rs.getString("goodsid"));
				String bankid = trim(rs.getString("bankid"));
				int transtate = rs.getInt("transtate");
				double amount = rs.getDouble("amount");
				
				String key = merid + "_" + goodsid + "_" + bankid;
				
				// 计算成功交易数 
				Long succPayCount = succPayCountMap.get(key);
				if(succPayCount == null){
					succPayCount = Long.valueOf(0);
				}
				// 计算交易额
				Double succPayAmount = succPayAmountMap.get(key);
				if(succPayAmount == null){
					succPayAmount = Double.valueOf(0);
				}
				
				if(transtate == 0){
					succPayCount++;
					succPayAmount += amount;
				}
				// 支付成功数
				succPayCountMap.put(key, succPayCount);
				// 支付成功金额
				succPayAmountMap.put(key, succPayAmount);
				
				// 支付数
				Long payCount = payCountMap.get(key);
				if(payCount == null){
					payCount = Long.valueOf(0);
				}
				payCount++;
				payCountMap.put(key, payCount);
			}
			
			rs.close();
			ps.close();
			
			StringBuffer orderSqlBuffer = new StringBuffer();
			
			orderSqlBuffer.append("select count(platordid) as ordercount, o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname");
			orderSqlBuffer.append(" from umpay.T_UPORDER_1411 o left join umpay.t_mer_inf mer on o.merid=mer.merid");
			orderSqlBuffer.append(" left join umpay.t_goods_inf goods on o.merid=goods.merid and o.goodsid=goods.goodsid");
			orderSqlBuffer.append(" left join umpay.t_bank_inf bank on o.bankid=bank.bankid");
			orderSqlBuffer.append(" where orderdate=?");
			orderSqlBuffer.append("group by o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname");
			
			ps = conn.prepareStatement(orderSqlBuffer.toString());
			ps.setString(1, dataDate);
			
			rs = ps.executeQuery();
			
			Map<String, Long> orderCountMap = new HashMap<String, Long>();
			while(rs.next()){
				// 订单总数
				int ordercount = rs.getInt("ordercount");
				String merid = trim(rs.getString("merid"));
				String goodsid = trim(rs.getString("goodsid"));
				String bankid = trim(rs.getString("bankid"));
				
				String key = merid + "_" + goodsid + "_" + bankid;
				
				String mername = trim(rs.getString("mername"));
				String goodsname = trim(rs.getString("goodsname"));
				String bankname = trim(rs.getString("bankname"));
				if(nameMap.get(key) == null){
					nameMap.put(key, mername + "_" + goodsname + "_" + bankname);
				}
				
				
				Long count = orderCountMap.get(key);
				if(count == null){
					count = Long.valueOf(0);
				}
				count += ordercount;
				orderCountMap.put(key, count);
			}
			
			// 输出交易额
			this.succPayAmountMap(succPayAmountMap);
			// 其他数据  以订单数据为维度
			Set<Entry<String, Long>> entrySet = orderCountMap.entrySet();
			Iterator<Entry<String, Long>> it = entrySet.iterator();
			while(it.hasNext()){
				Entry<String, Long> entry = it.next();
				String key = entry.getKey();
				
				// 维度订单总数
				Long orderCount = entry.getValue().longValue();
				if(orderCount == null){
					orderCount = 0L;
				}
				
				// 维度支付数
				Long payCount = payCountMap.get(key);
				if(payCount == null){
					payCount = 0L;
				}
				
				// 维度支付成功数
				Long succPayCount = succPayCountMap.get(key);
				if(succPayCount == null){
					succPayCount = 0L;
				}
				
				// 维度支付失败数
				Long errorPayCount = payCount - succPayCount;
				
				// 支付转化率
				double payRate = orderCount == 0 ? 0 : payCount/orderCount;
				
				// 支付成功率
				double succPayRate = payCount == 0 ? 0 : succPayCount/payCount;
				
				// 交易成功率
				double succOrderRate = orderCount == 0 ? 0 : succPayCount/orderCount;
				
				String[] name = nameMap.get(key).split("_");
				String mername = name[0];
				String goodsname = name[1];
				String bankname = name[2];
				
				String merid = key.split("_")[0];
				String goodsid = key.split("_")[1];
				String bankid = key.split("_")[2];
				
				System.out.println("商户：" + merid + "\t商户名：" + mername + "\t商品号：" + goodsid + "\t商品名：" + goodsname + "\t银行号：" + bankid + "\t银行名称：" + bankname + "\t订单数：" + orderCount + "\t支付数：" + payCount + "\t支付转化率：" + payRate + "\t支付失败数：" + errorPayCount + "\t支付成功数：" + succPayCount + "\t支付成功率：" + succPayRate + "\t交易转化率：" + succOrderRate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	private void succPayAmountMap(Map<String, Double> succPayAmountMap){
		System.out.println("*********************交易额start*************************");
		Set<Entry<String, Double>> entrySet = succPayAmountMap.entrySet();
		Iterator<Entry<String, Double>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String, Double> entry = it.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		System.out.println("*********************交易额end*************************");
		System.out.println();
		System.out.println();
	}
	
	private static String trim(String s){
		return s == null ? "" : s.trim();
	}
	
	private Connection getConn() throws Exception{
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		Connection conn = DriverManager.getConnection("jdbc:db2://10.10.67.74:50000/statdev", "ucollatb", "ucollatb");
		return conn;
	}
	
	public static WritableWorkbook createEXCEL() {
		String todayyyyMMdd = Util.calender();
		log.info("执行日期：" + todayyyyMMdd);
		String fileName = todayyyyMMdd + "交易统计.xls";
		
		File file = new File("D:/"+fileName);
		WritableWorkbook wwb = null;
		
		try {
			wwb = Workbook.createWorkbook(file);
		} catch (IOException e) {
			log.error("createEXCEL error!");
		}
		return wwb;
	}
	
}
