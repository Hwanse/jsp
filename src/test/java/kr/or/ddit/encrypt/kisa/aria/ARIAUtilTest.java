package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIAUtilTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ARIAUtilTest.class);
	
	/**
	* Method : ecryptTEst
	* 작성자 : PC14
	* 변경이력 :
	* @throws InvalidKeyException
	* @throws UnsupportedEncodingException
	* Method 설명 : 암호화/복호화 처리가 가능한 ARIA 암호화 방식의 테스팅
	*/
	@Test
	public void ecryptTEst() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String plainText = "brown1234";

		/***When***/
		// 평문을 암호화 처리
		String encryptText = ARIAUtil.ariaEncrypt(plainText);
		
		// 암호문을 복호화 처리
		String decrpytText = ARIAUtil.ariaDecrypt(encryptText);
		
		/***Then***/
		logger.debug("encryptText : {}", encryptText);
		// brown1234 : ED4024DC5EB54D47E7041B4FA0A34F3D
		
		assertEquals(plainText, decrpytText);

	
	}

}
