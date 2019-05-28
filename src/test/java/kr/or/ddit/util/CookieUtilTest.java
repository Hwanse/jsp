package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtilTest {

	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtilTest.class);
	
	/**
	* Method : getCookieTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 :	getCookie를 테스트하는 메서드
	*/
	@Test
	public void getCookieTest() {
		
		//***Given***//
		String cookieString = "rememberme=true; userId=brown; test=testValue";
		CookieUtil.setCookieString(cookieString);
		
		//***When***//
		String cookieValue = CookieUtil.getCookie("userId");
		String cookieValue1 = CookieUtil.getCookie("rememberme");
		String cookieValue2 = CookieUtil.getCookie("test");
		String cookieValue3 = CookieUtil.getCookie("test11q24521");
		String cookieValue4 = CookieUtil.getCookie("userI");
		String cookieValue5 = CookieUtil.getCookie("remember");
		String cookieValue6 = CookieUtil.getCookie("tes");
		
		//***Then***//
		assertEquals("brown", cookieValue);
		assertEquals("true", cookieValue1);
		assertEquals("testValue", cookieValue2);
		assertEquals("", cookieValue3);
		assertEquals("", cookieValue4);
		assertEquals("", cookieValue5);
		assertEquals("", cookieValue6);
		
	}

	
	/**
	 * Method : getCookieTest
	 * 작성자 : PC14
	 * 변경이력 :
	 * Method 설명 :	getCookie를 테스트하는 메서드
	 */
	@Test
	public void getCookieTest2() {
		
		//***Given***//
		String cookieString = "rememberme=true; userId=brown; test=testValue";
		CookieUtil.setCookieString(cookieString);
		
		//***When***//
		String cookieValue = CookieUtil.getCookie2("userId");
		String cookieValue2 = CookieUtil.getCookie2("rememberme");
		String cookieValue3 = CookieUtil.getCookie2("test");
		String cookieValue4 = CookieUtil.getCookie2("test11q24521");
		String cookieValue5 = CookieUtil.getCookie2("userI");

		//***Then***//
		assertEquals("brown", cookieValue);
		assertEquals("true", cookieValue2);
		assertEquals("testValue", cookieValue3);
		assertEquals("", cookieValue4);
		assertEquals("", cookieValue5);
		
	}
}
