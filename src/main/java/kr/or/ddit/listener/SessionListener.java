package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener{

	private static final Logger logger = LoggerFactory
			.getLogger(SessionListener.class);

	private Map<String, HttpSession> serssionMap = new HashMap<String, HttpSession>();
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().setAttribute("sessionMap", serssionMap);
		logger.debug("session created : {}", se.getSession().getId());
		serssionMap.put(se.getSession().getId(), se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("session destroyed : {}", se.getSession().getId());
		serssionMap.remove(se.getSession().getId());
		
	}
	
}
