package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtilTest {

	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);
	
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";
		logger.debug("contentDisposition : {}",contentDisposition);
		
		
		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("sally.png", fileName);
	
	}

	// uuid Test
	@Test
	public void uuidTest(){
		/***Given***/
		

		/***When***/
		logger.debug("UUID.randomUUID().toString() : {}", UUID.randomUUID().toString());
		
		/***Then***/

		
	}

	
	@Test
	public void getExtTest(){
		/***Given***/
		String fileName = "sally.png";
		String fileName2 = "sally.picture.png";
		String fileName3 = "sally";
		
		/***When***/
		String ext = PartUtil.getExt(fileName);
		String ext2 = PartUtil.getExt(fileName2);
		String ext3 = PartUtil.getExt(fileName3);
		
		/***Then***/
		assertEquals(".png", ext);
		assertEquals(".png", ext2);
		assertEquals("", ext3);
		
	}
	
	@Test
	public void splitTest(){
		/***Given***/
		String filename = "test";
		String filename2 = "test.png";

		/***When***/
		String splited = PartUtil.getExt(filename);
		String splited2 = PartUtil.getExt(filename2);
		
		/***Then***/
		assertEquals("", splited);
		assertEquals("png", splited2);
		
		
	}
	
	@Test
	public void subStringTest(){
		/***Given***/
		String yyyyMM = "201906";

		/***When***/
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);
		
		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);

		
	}
	
}
