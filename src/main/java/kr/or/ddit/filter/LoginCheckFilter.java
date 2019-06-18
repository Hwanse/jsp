package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 접속 여부를 확인해서 (세션에 USER_INFO 속성이 존재하는지 체크)
// 접속이 안되어 있으면 --> login화면으로 이동
// 접속이 되어 잇으면 정상적으로 최초 요청한 resource로 위임

// ex: /user/userList --> /login
// ex: /user/userPagingList --> /login
// ex: /login
@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	
	public void init(FilterConfig fConfig) throws ServletException {

	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		
		// 세션이 없어도 처리가 되어야 되는 것들: /login, .js, .css, .png ==> /js, /css, /img
		//(다수의 파일형식을 효율적으로 받기위해 폴더로 묶는것이 중요)
		if(uri.startsWith("/login") || uri.startsWith("/js") || uri.startsWith("/css") || 
				uri.startsWith("/img") || uri.startsWith("/bootstrap") ){
			chain.doFilter(request, response);
		} else if(req.getSession().getAttribute("USER_INFO") != null){	// session을 체크해야하는 대상들
			chain.doFilter(request, response);
			
		} else{
			HttpServletResponse res= (HttpServletResponse)response;
			res.sendRedirect(req.getContextPath() + "/login");
		}
		
	}
	
	public void destroy() {

	
	}


}
