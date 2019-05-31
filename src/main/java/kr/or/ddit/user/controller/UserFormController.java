package kr.or.ddit.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserFormController
 */
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	// 사용자 등록 화면 요청처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
	}

	// 사용자 등록 요청처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("UserForm doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		// 사용자가 보낸 파라미터를 사용해서 UserVO인스턴스를 만든다
		String userId 	= 	request.getParameter("userId");
		String name 	= 	request.getParameter("name");
		String alias 	= 	request.getParameter("alias");
		String addr1 	= 	request.getParameter("addr1");
		String addr2 	= 	request.getParameter("addr2");
		String zipcd 	= 	request.getParameter("zipcd");
		String birth 	= 	request.getParameter("birth");
		String pass 	= 	request.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVO = null;
		try {
			userVO = new UserVO(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO dbUser = userService.getUser(userId);
		
		// 등록된 사용자가 아닌경우 --> 정상 입력이 가능한 상황
		if(dbUser == null){
			
			if(userService.insertUser(userVO) > 0){
				response.sendRedirect(request.getContextPath()+ "/userPagingList");
			}else{
				request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
			}
			
		} else{
			request.setAttribute("msg", "이미 존재하는 사용자 입니다.");
			request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		}
		// 존재하지 않은경우{
		// 		userService 객체를 통해 insertUser(userVO)
		
		// 		정상적으로 입력이 된 경우
		// 			사용자 페이징 리스트 1페이지로 이동
		
		//		정삭적으로 입력되지 않은 경우
		//			사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		// }
		
		// 존재할 경우
		//	사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		//	이미 존재하는 userId입니다.(alert or text로 표시)
		
	}

}
