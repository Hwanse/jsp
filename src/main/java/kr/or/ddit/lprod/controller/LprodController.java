package kr.or.ddit.lprod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class LprodController
 */
@WebServlet("/lprod")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int lprod_id = Integer.parseInt(request.getParameter("lprodId"));
		
		LprodVO lprodVO = lprodService.getLprodInfo(lprod_id);
		
		request.setAttribute("SELECT_LPROD_INFO", lprodVO);
		
		request.getRequestDispatcher("/lprod/lprod.jsp").forward(request, response);
		
	}

}
