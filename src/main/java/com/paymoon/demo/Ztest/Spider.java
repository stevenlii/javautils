package com.paymoon.demo.Ztest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @ClassName: Spider
 * @Description: TODO 蜘蛛爬虫
 * @author StevenLii
 * @date 2014年11月16日 下午9:31:05
 * 
 */
public class Spider {

	public static void main(String[] args) throws Exception {
		new Spider().spider();
	}

	/**
	 * 
	 * @Title: spider
	 * @Description: TODO 蜘蛛爬虫
	 * @param URL
	 *            the url needs spider goto
	 * @param port
	 *            the port, eg.80
	 * @throws Exception
	 * @return void
	 */
	public void spider(String URL, int port) throws Exception {

		Socket socket = new Socket(URL, port);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream()));

		bw.write("GET / HTTP/1.1");
		bw.newLine();
		bw.write("Host:" + URL + ":" + port);
		bw.newLine();
		bw.write("Content-Type:text/html");
		bw.newLine();
		bw.newLine();
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String string = null;
		while ((string = br.readLine()) != null) {
			System.out.println(string);
		}
		bw.close();
		br.close();
		socket.close();

	}

	/**
	 * 
	 * @Title: spider
	 * @Description: TODO
	 * @param URL
	 * @throws Exception
	 * @return void
	 */
	public void spider(String URL) throws Exception {
		spider(URL, 80);
	}

	/**
	 * 
	 * @Title: spider
	 * @Description: TODO
	 * @throws Exception
	 * @return void
	 */
	public void spider() throws Exception {
		spider("www.baidu.com", 80);
	}

}
