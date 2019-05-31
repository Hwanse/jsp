package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO vo = (UserVO) request.getSession().getAttribute("vo");
		logger.debug("vo: {}", vo);
		
//		String birth = vo.getBirth().getYear()+1900 + "-" + vo.getBirth().getMonth() + "-" + vo.getBirth().getDate();
		String birth = null;
		birth = sdf.format(vo.getBirth());
		logger.debug("birth :  {} ", birth);
		request.setAttribute("birth", birth);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		String pass = request.getParameter("pass");
		String file = request.getParameter("filename");
		int idx = file.lastIndexOf("\\");
		String filename = file.substring(idx+1);
		String path = "D:\\upload\\"+filename;

		UserVO userVO = null;
		try {
			userVO = new UserVO(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth), path, filename);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(userService.updateUser(userVO) > 0){
			request.getSession().removeAttribute("vo");
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		} else{
			request.getSession().setAttribute("vo", userVO);
			request.getRequestDispatcher("/user/userModify.jsp");
		}
		
	}

}
