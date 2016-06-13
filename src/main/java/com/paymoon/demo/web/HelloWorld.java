/**   
* @Title: HelloWorld.java
 * @Package com.paymoon.demo.web
 * @Description: TODO
 * @author StevenLii  
* @date 2014年11月19日 下午11:01:24
 * @version V1.0   
*/
package com.paymoon.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HelloWorld
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class HelloWorld extends HttpServlet{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * <p>Title: doGet</p>
	 * <p>Description: </p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object string = req.getParameter("hee");
		System.out.println(string);
		resp.setContentType("text/html;charset=utf8");
		PrintWriter out = resp.getWriter();
		out.print(string);
		out.close();
	}

	/* (non-Javadoc)
	 * <p>Title: doPost</p>
	 * <p>Description: </p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object string = req.getAttribute("hee");
		System.out.println(string);
		resp.setContentType("text/html;charset=utf8");
		PrintWriter out = resp.getWriter();
		out.print(string);
		out.close();
	}

}
