package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LprodPagingController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingController.class);
	
	private ILprodService service;
//	private int PAGESIZE;
	
	@Override
	public void init() throws ServletException {
		service = new LprodServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PAGESIZE = 10;
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 3 : Integer.parseInt(pageSizeString);
		
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap = service.lprodPagingList(pageVO);
		request.setAttribute("lprodPagingList", resultMap.get("lprodPagingList"));
		request.setAttribute("lprodsCnt", resultMap.get("lprodsCnt"));
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("paginationSize", resultMap.get("paginationSize"));
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

}
