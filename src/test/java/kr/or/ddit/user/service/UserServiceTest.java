package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
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
	
	
	@Test
	public void userPagingListTest(){
		
		/***Given***/
		PageVO pageVO = new PageVO(1, 10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int	paginationSize = (Integer)resultMap.get("paginationSize");
		/***Then***/

		assertNotNull(userList);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest(){
		
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		
		/***When***/
		double paginationSize = Math.ceil( (double)usersCnt / pageSize);
		logger.debug("paginationSize : {} " , paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
		
	}
	
}
