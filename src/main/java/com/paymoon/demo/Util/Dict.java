package com.paymoon.demo.Util;
//
public class Dict {

	public static final String AGENT_ID = "agent_id";

	/*
	 * 响应时间
	 */
	public static final String RESPONSE_TIME = "responsetime";
	/*
	 * 丢包率
	 */
	public static final String PACKET_LOSS_PERCENT = "packetlosspercent";
	/*
	 * 最长
	 */
	public static final String RESPONSE_TIME_MAX = "responsetimemax";
	/*
	 * 最短
	 */
	public static final String RESPONSE_TIME_MIN = "responsetimemin";
	/*
	 * targetUrl
	 */
	public static final String TARGET_URL = "targetUrl";

	// json return data[ping]

	public static final String DETECT_ID = "id"; // 1001检测实体的id

	/**
	 * 创建时间
	 */
	public static final String CREATION_TIME = "creationtime";// null

	public static final String MODIFIED_TIME = "modifiedTime";// null

	public static final String DELETED = "deleted";// 0

	public static final String STATUS = "status";// ACTIVE

	public static final String DESCRIPTION = "description";// 百度

	public static final String URL = "url";// www.baidu.com

	public static final String USER = "user";// null

	public static final String TYPE = "type";// ping

	public static final String SUBTYPE = "subtype";// router

	public static final String APP = "app";// shanghai

	public static final String APP_DESCRIPTION = "appDescription";// null

	public static final String METRIC = "metric";// PingTime

	public static final String METRIC_DESCRIPTION = "metricDescription";// Ping响应时间
	
	
	// appdescription
		public static final String APP_BEI_JING = "北京资源池";//
		public static final String APP_GUANG_ZHOU = "广州-vCenter,广州资源池";//
		public static final String APP_NEI_MENG = "内蒙资源池";//
		public static final String APP_SHANG_HAI = "上海资源池";//
		public static final String APP_SI_CHUAN = "四川资源池";//
	// protocol tcp udp
	
	public static final String PROTOCL_CONNECTION_NUM = "protocl_connection_num";// 连接次数
	public static final String UDP_SEND_DATA_LENGTH = "udp_send_data_length";// 发包长度
	public static final String UDP_COST_TIME_RUN_BEFORE = "udp_cost_time_run_before";// udp开始时间
	public static final String UDP_COST_TIME_RUN_AFTER = "udp_cost_time_run_after";// 结束时间
	public static final String UDP_COST_TIME = "udp_cost_time";// 响应时间
	public static final String UDP_SEND_PACKAGE_NUM = "udp_send_package_num";// 发包数
	public static final String UDP_ICMP_SEQ_NUM = "udp_icmp_seq_num";// 收包
	public static final String UDP_SEND_PACKAGE_NUM_OK = "udp_send_package_num_ok";// 响应时间OK
	public static final String UDP_SEND_PACKAGE_NUM_OUT= "udp_send_package_num_out";// 响应时间超时
	public static final String UDP_TIME_OUT = "udp_time_out";// 响应时间超时
	public static final String UDP_CLIENT_PORT = "udp_client_port";// 响应时间超时
	public static final String UDP_SERVER_PORT = "udp_server_port";// 响应时间超时
	public static final String UDP_SERVER_LOCALHOST = "127.0.0.1";// localhost server
	public static final String UDP_SERVER_LOCALHOST118 = "118.85.194.45";// 118 server
	
	public static final String PROTOCOL_MESSAGE_PACKET_LOSS_PERCENT = "protocol_message_packet_loss_percent";// TCP/UDP/HTTP等protocol返回丢包率信息
	public static final String PROTOCOL_MESSAGE_RESPONSE_TIME = "protocol_message_response_time";// TCP/UDP/HTTP等protocol返回丢包率信息

}
