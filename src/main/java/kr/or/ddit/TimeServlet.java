package kr.or.ddit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeServlet extends HttpServlet {
   
	
	// kr.or.ddit.
   private Logger logger = LoggerFactory.getLogger(TimeServlet.class);
   

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

      resp.setContentType("text/html; charset=utf-8"); 
      
      PrintWriter pw = resp.getWriter();
      
//      localhost/jsp/timesServlet?param=6
/*
      String param = req.getParameter("param");
      System.out.println("param : " + param);
*/
      
//      localhost/jsp/timeSErvlet?param=2&6
      String param1 = req.getParameter("gob");
      logger.debug("param1 : {}", param1 );
      
      String param2 = req.getParameter("dan");
      logger.debug("param2 : {}", param2);
      
      
      pw.write("<html>");
      pw.write("<head>");
      pw.write("   <title>TimesTableServlet</title>");
      pw.write("   <style>");
      pw.write("      body{ text-align : center; }");
      pw.write("      span{ color : red; font-weight : bold; font-size : 1.5em; }");
      pw.write("      td { border : 1px solid red;    width : 250px;   height : 77px;       collapse : collapse;   text-align : center; }");
      pw.write("   </style>");
      pw.write("</head>");
      pw.write("<body>");
      
      pw.write("<span>SHOOKIE's Table :D<span>");
      pw.write("<br>");
      
      pw.write("<table>");
      
      for(int i = 1; i <= Integer.parseInt(param1); i ++) {
         pw.write("<tr>");
         for(int j = 2; j <= Integer.parseInt(param2); j++) {
            pw.write("   <td>");
            pw.write(j + " * " + i + " = " + i*j);
            pw.write("   </td>");
         }
         pw.write("</tr>");
      }
      
      
      pw.write("</table>");
      
      pw.write("</body>");
      pw.write("</html>");
      pw.close();
   }
   
}