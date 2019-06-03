package kr.or.ddit.encrypt.kisa.sha256;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_test {

	private static final Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_test.class);
	
	
	
	/**
	* Method : SHA256Test
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 복호화가 불가능한 hash알고리즘
	*/
	@Test
	public void SHA256Test() {
		/***Given***/
		String plainText = "brown1234";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		logger.debug("encrytTest : {}", encryptText);
		
		/***Then***/
		
		
	}

}
