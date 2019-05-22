<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.write("application.getContextPath() : " +  application.getContextPath() +"<br>");
		out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>" );
		out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
		out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
		out.write("application.getInitParameter(\"ADMIN\") : "
				+ application.getInitParameter("ADMIN") + "<br>");
		
		
		application.getRealPath("/res/190522.txt");
		
		out.write("application.getRealPath('/res/190522.txt'): "
				 + application.getRealPath("/res/190522.txt") +"<br><br><br>" );
		
		
		
		FileInputStream fin = null;
		FileOutputStream fou = null;
		try{
			fin = new FileInputStream( application.getRealPath("/res/190522.txt") );
			fou = new FileOutputStream( new File("D:/D_Other/test.txt") );	
			
			InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fou, "UTF-8");
			
			byte[] buffer = new byte[512];
			
			int c;
			
			System.out.println("전송 시작 ...");
			while( ( c = fin.read(buffer)) != -1){
				if( (char)c == '\n'){
					out.write("<br>");
				}
				out.write(c);
				osw.write(c);
			}
			
			System.out.println("전송 끝 ...");
			
			
			isr.close();
			osw.close();
			fin.close();
			fou.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	%>
</body>
</html>