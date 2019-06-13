package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectLocalController
 */
@WebServlet("/selectLocale")
public class SelectLocalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String locale = request.getParameter("locale");
		
		locale = locale!=null ? locale : "ko";
	
		
		request.setAttribute("locale", locale);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String locale = request.getParameter("locale");
		
		response.sendRedirect(request.getContextPath() + "/selectLocale?locale="+locale);
	}

}
