package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.uri.model.UriVO;
import kr.or.ddit.uri.service.IUriService;
import kr.or.ddit.uri.service.UriServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	// /main.do -> MainController
	// /userList.do -> UserListController
	private static IUriService uriService = new UriServiceImpl();
	
	private static Map<String , Controller> requestMapping;
	
	static {
		List<UriVO> uriClassMappingList = uriService.getAllUriMapping();
		requestMapping = new HashMap<String, Controller>();
		
		for(UriVO uriVO : uriClassMappingList){
			//classInfo : "kr.or.ddit.controller.MainController"
			String classInfo = uriVO.getClassName();
			try {
				// 클래스를 동적으로 생성해주기 위한 로직
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(uriVO.getUri(), (Controller)obj);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}

}
