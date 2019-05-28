package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoTest {

	private ILprodDao dao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDaoTest.class);

	@Before
	public void setup() {

		dao = new LprodDaoImpl();
		
	}
	
	@Test
	public void getAllLprodList() {
		
		/***Given***/


		/***When***/
		List<LprodVO> list = dao.getAllLprodList();
		
		/***Then***/
		logger.debug("lprodList : {}" , list);
		assertNotNull(list);
		assertEquals( 9,  list.size());

	
	}

	@Test
	public void lprodPagingList(){
		
		/***Given***/
		PageVO pageVO = new PageVO(1, 10);
		

		/***When***/
		List<LprodVO> pagingList = dao.lprodPagingList(pageVO);

		/***Then***/
		assertNotNull(pagingList);
		assertEquals(9, pagingList.size());

	}
	
	@Test
	public void lprodsCnt(){
		/***Given***/
		

		/***When***/
		int lprodCnt = dao.lprodsCnt();
		
		/***Then***/
		assertEquals(9, lprodCnt);

	}
	
}
