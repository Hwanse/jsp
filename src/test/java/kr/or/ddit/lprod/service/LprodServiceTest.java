package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceTest {

	ILprodService service;
	
	@Before
	public void setUp(){
		service = new LprodServiceImpl();
	}
	

	@Test
	public void getAllLprodList(){
		
		/***Given***/
		
		

		/***When***/
		List<LprodVO> allList = service.getAllLprodList();

		/***Then***/
		assertEquals(9, allList.size());

		
	}
	
	@Test
	public void lprodPagingList(){
		
		
		/***Given***/
		PageVO pageVO = new PageVO(1,10);
		

		/***When***/
		Map<String, Object> resultMap = service.lprodPagingList(pageVO);
		
		List<LprodVO> pagingList = (List<LprodVO>) resultMap.get("lprodPagingList");
		int lprodsCnt = (int) resultMap.get("lprodsCnt");
		
		/***Then***/
		assertEquals(9, pagingList.size());
		assertEquals(9, lprodsCnt);

		
		
	}
	
	
}
