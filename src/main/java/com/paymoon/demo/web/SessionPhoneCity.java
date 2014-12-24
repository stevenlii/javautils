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
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.paymoon.demo.web.webserivice.PhoneNum;

/**
 * 
 * @ClassName: SessionPhoneCity
 * @Description: show the session and the phone number city demo
 * @author StevenLii
 * @date 2014年11月22日 下午5:56:41
 *
 */
public class SessionPhoneCity extends HttpServlet{

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
		resp.setContentType("text/html;charset=utf8");
		HttpSession session = req.getSession(true);
		String sessionId = session.getId();
		String sessionTime = new Date(session.getCreationTime()).toString();
		Object phone = req.getParameter("phone");
		PhoneNum pn = new PhoneNum();
		String city = null;
		try {
			if (phone != null) {
				
				city = pn.GetCityByPhone((String)phone);
			}else {
				city = "plz fill your phone Number!";
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("sessionId", sessionId);
		session.setAttribute("sessionTime", sessionTime);
		session.setAttribute("city", city);
		session.setAttribute("sessionId", sessionId);
		PrintWriter out = resp.getWriter();
		
		out.print("手机信息: " + city);
		out.print("<br/>");
		out.print("session Msg: " + session.isNew());
		out.print("<br/>");

		out.print("sessionId: " +sessionId);
		out.print("<br/>");

		out.print("Time: " + sessionTime);
		out.print("<br/>");
		
		out.print(req.isRequestedSessionIdFromCookie());
		out.print("<br/>");
		out.print(req.isRequestedSessionIdFromURL());
		out.print("<br/>");
		out.print(resp.encodeURL(req.getRequestURI()));
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
