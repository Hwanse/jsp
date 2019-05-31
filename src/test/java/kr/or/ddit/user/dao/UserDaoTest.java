package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;
import oracle.net.nt.SdpNTAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {

	private IUserDao userDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);

	// junit 실행순서
	// @BeforeClass가 적용된 메서드가 최초 1회 실행
	
	// 다음 구간은 @Test가 적용된 모든 메서드에 대해 반복 적용
	// @Before가 적용된 메서드 실행
	// @Test가 적용 메서드가 실행
	// @After가 적용된 메서드가 실행
	
	// @AfterClass가 적용된 메서드가 1회 실행
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup(){
		userDao = new UserDaoImpl();
		logger.debug("setup");
	}
	
	@After
	public void tearDown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	// Test메서드는 반드시 @Test(테스트 어노테이션)이 붙어야있어야하고
	// 접근제어자는 반드시 public 반환타입은 void이어야 한다.
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		// 테스트
		/***Given***/

		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}

	
	/**
	* Method : getUserTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVO.getName());

		
	}
	
	
	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇번째 페이지 조회인지?, 페이징 몇건 씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	// 정렬 순서는? : 로직 --> 파라미터화 시킬 수 있다
	// --> 사용자 아이디 순으로 정렬
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		
		/***Given***/
		PageVO pageVO = new PageVO(1, 10);
		
		/***When***/
		List<UserVO> userList = userDao.userPagingList(pageVO);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		for(UserVO userVO : userList){
			logger.debug("userLists : {}", userVO);
		}

	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 전체 수 조회 테스트
	 */
	@Test
	public void usersCntTest(){
		
		int usersCnt = userDao.usersCnt();
		
		assertEquals(106, usersCnt);
		
	}
	
	
	/**
	* Method : insertUserTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	*/
	@Test
	public void insertUserTest(){
		/***Given***/
		// 사용자 정보를 담고있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO=null;
		try {
			userVO = new UserVO("애옹이", "userTest", "중앙로", "userTest1234", "대전광역시 중구 중앙로 76"
					, "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
		// userDao.insertUser();
		int insertRes = userDao.insertUser(userVO);
		/***Then***/
		// insertCnt(1)
		assertEquals(1, insertRes);
		// data 삭제
		userDao.deleteUser(userVO.getUserId());
		
	}
	
	
	/**
	* Method : updateUserTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 정보 수정
	*/
	@Test
	public void updateUserTest(){
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = null;
		try {
			userVO = new UserVO("황선홍", "userTest", "중앙", "1234", "대전광역시 동구 홍도동", "한남대학교"
								, "3412" , sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/***When***/
		int updateUser = userDao.updateUser(userVO);
		
		/***Then***/
		assertEquals(1, updateUser);
		
	}
	
}
