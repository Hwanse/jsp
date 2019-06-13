package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ProdDaoTest.class);
	
	private IProdDao dao;
	
	@Before
	public void setup(){
		dao = ProdDaoImpl.getInstance();
	}
	
	/**
	* Method : getProdListTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 선택한 상품분류의 prodList 조회
	*/
	@Test
	public void getProdListTest() {
		/***Given***/
		String prod_lgu = "P101";

		/***When***/
		List<ProdVO> list = dao.getProdList(prod_lgu);
		
		/***Then***/
		assertNotEquals(list.size(), 0);
		for(ProdVO prodVO : list){
			logger.debug("prodVO : {}", prodVO);
		}

		
	}

}
