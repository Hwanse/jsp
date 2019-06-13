package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ProdServiceTest.class);
	
	private IProdService service;
	
	@Before
	public void setup(){
		service = ProdServiceImpl.getInstance();
	}
	
	@Test
	public void getProdListTest() {
		/***Given***/
		String prod_lgu ="P101";

		/***When***/
		List<ProdVO> list = service.getProdList(prod_lgu);
		
		/***Then***/
		assertNotEquals(0,list.size());
		for(ProdVO prodVO : list){
			logger.debug("prodVO : {}", prodVO);
		}
	}

}
