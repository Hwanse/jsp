package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {

	private IUserService userService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
		logger.debug("setup()");
	}
	
	
	/**
	* Method : userListTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Test
	public void userListTest() {
		
		/***Given***/
		
		
		/***When***/
		List<UserVO> userList = userService.userList();
		
		
		/***Then***/
		assertEquals(105, userList.size());
		logger.debug("userList size : {}" , userList.size());
		
	}

	
	@Test
	public void getUserTest(){
		
		/***Given***/
		IUserService userService = new UserServiceImpl();
		String userId = "brown";
		/***When***/
		UserVO userVO = userService.getUser(userId);
		
		/***Then***/
		assertNotNull(userVO);
		logger.debug("user name : {}", userVO.getName());
	}
}
