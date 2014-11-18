package com.paymoon.demo.statistics;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MailSend
{
	private static final Logger log = LogManager.getLogger("MailSend");
  private MimeMessage mimeMsg;
  private Session session;
  private Properties props;
  private String username = "";
  private String password = "";
  private Multipart mp;

  public MailSend()
  {
    createMimeMessage();
  }

  public MailSend(String smtp)
  {
    setSmtpHost(smtp);
    createMimeMessage();
  }

  public void setSmtpHost(String hostName)
  {
    if (this.props == null) {
      this.props = System.getProperties();
    }

    this.props.put("mail.smtp.host", hostName);
    this.props.put("mail.smtp.localhost", hostName);
    log.debug(new Object[] { "mail.smtp.host = ", hostName });
  }

  public boolean createMimeMessage()
  {
    log.debug("createMimeMessage> get session...");
    try {
      this.session = Session.getDefaultInstance(this.props, null);
    } catch (Exception e) {
      log.error(e);
      return false;
    }

    log.debug("createMimeMessage> create MIME object...");
    try {
      this.mimeMsg = new MimeMessage(this.session);
      this.mp = new MimeMultipart();
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public void setNeedAuth(boolean need)
  {
    if (this.props == null) {
      this.props = System.getProperties();
    }
    if (need)
      this.props.put("mail.smtp.auth", "true");
    else {
      this.props.put("mail.smtp.auth", "false");
    }
    log.debug(new Object[] { "mail.smtp.auth = ", Boolean.valueOf(need) });
  }

  public void setNamePass(String name, String pass)
  {
    log.debug("setNamePass> ...");
    this.username = name;
    this.password = pass;
  }

  public boolean setSubject(String mailSubject)
  {
    log.debug(new Object[] { "setSubject> ", mailSubject });
    try {
      this.mimeMsg.setSubject(mailSubject);
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean setBody(String mailBody)
  {
    log.debug(new Object[] { "setBody> ", mailBody });
    try {
      BodyPart bp = new MimeBodyPart();

      bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=GBK>" + mailBody, "text/html;charset=GBK");
      this.mp.addBodyPart(bp);
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean addFileAffix(String filename)
  {
    log.debug(new Object[] { "addFileAffix> ", filename });
    try {
      BodyPart bp = new MimeBodyPart();
      FileDataSource fileds = new FileDataSource(filename);
      bp.setDataHandler(new DataHandler(fileds));
     //    bp.setFileName(fileds.getName());
      bp.setFileName( MimeUtility.encodeText(fileds.getName()));  //附件中文名的正常显示
      this.mp.addBodyPart(bp);
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean addFileAffix(String filename, String fname)
  {
    log.debug(new Object[] { "addFileAffix> ", filename });
    try {
      BodyPart bp = new MimeBodyPart();
      FileDataSource fileds = new FileDataSource(filename);
      bp.setDataHandler(new DataHandler(fileds));
    //  bp.setFileName(fname);
      bp.setFileName( MimeUtility.encodeText(fname));  //附件中文名的正常显示
      this.mp.addBodyPart(bp);
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean setFrom(String from)
  {
    log.debug(new Object[] { "setFrom> ", from });
    try {
      this.mimeMsg.setFrom(new InternetAddress(from));
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean setTo(String to)
  {
    log.debug(new Object[] { "setTo> ", to });
    if (to == null)
      return false;
    try
    {
      this.mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean setCopyTo(String copyto)
  {
    log.debug(new Object[] { "setCopyTo> ", copyto });
    if (copyto == null)
      return false;
    try
    {
      this.mimeMsg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(copyto));
      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public boolean sendout()
  {
    try
    {
      this.mimeMsg.setContent(this.mp);
      this.mimeMsg.saveChanges();

      log.debug("sendout> sending....");

      Transport transport = this.session.getTransport("smtp");
      transport.connect((String)(String)this.props.get("mail.smtp.host"), this.username, this.password);
      transport.sendMessage(this.mimeMsg, this.mimeMsg.getRecipients(Message.RecipientType.TO));
      transport.close();
      log.debug("sendout> ok");

      return true;
    } catch (Exception e) {
      log.error(e);
    }return false;
  }

  public static void main(String[] args)
  {
	  String today = Util.calender();
    MailSend themail = new MailSend("smtp.umpay.com");
    themail.setNeedAuth(true);
    themail.setSubject(today+"交易统计");
    themail.setFrom("lizhiqiang@umpay.com");
    themail.setNamePass("lizhiqiang@umpay.com", "OOO000");
   
    themail.setTo("lizhiqiang@umpay.com;1098989547@qq.com");
    themail.setBody(today+"测试maintest1<br>测试test2<br>测试test3from local");
    themail.addFileAffix(today+"交易统计.xls");

    themail.sendout();
  }
  public static void send()
  {

	  String today = Util.calender();
    MailSend themail = new MailSend("smtp.umpay.com");
    themail.setNeedAuth(true);
    themail.setSubject(today+"交易统计");
    themail.setFrom("lizhiqiang@umpay.com");
    themail.setNamePass("lizhiqiang@umpay.com", "OOO000");
   
    themail.setTo("lizhiqiang@umpay.com");
    themail.setBody(today+"测试test1<br>测试test2<br>测试test3");
    themail.addFileAffix(today+"交易统计.xls");

    themail.sendout();
  
  }
} 
