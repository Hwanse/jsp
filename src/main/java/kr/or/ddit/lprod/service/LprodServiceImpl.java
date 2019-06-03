package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public class LprodServiceImpl implements ILprodService{

	private static final Logger logger = LoggerFactory
			.getLogger(LprodServiceImpl.class);
	
	private ILprodDao dao;

	public LprodServiceImpl() {
		dao = new LprodDaoImpl();
	}
	
	@Override
	public List<LprodVO> getAllLprodList() {
		List<LprodVO> allList = dao.getAllLprodList();
		return allList;
	}

	@Override
	public Map<String, Object> lprodPagingList(PageVO pageVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
	
		List<LprodVO> pagingList = dao.lprodPagingList(pageVO);
		int lprodsCnt = dao.lprodsCnt();
		
		resultMap.put("lprodPagingList", pagingList);
		resultMap.put("lprodsCnt", lprodsCnt);
		
		int paginationSize = 0;
		if( lprodsCnt % pageVO.getPageSize() == 0){
			paginationSize = lprodsCnt / pageVO.getPageSize();
		} else{
			paginationSize = lprodsCnt / pageVO.getPageSize() + 1;
		}
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public LprodVO getLprodInfo(int lprod_id) {
		LprodVO lprodVO = dao.getLprodInfo(lprod_id);
		return lprodVO;
	}
	
	
}
