package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao{

	@Override
	public List<LprodVO> getAllLprodList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.getAllLprodList");
		
		sqlSession.close();
		return lprodList;
	}

	@Override
	public int lprodsCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodsCnt = sqlSession.selectOne("lprod.lprodsCnt");

		sqlSession.close();
		return lprodsCnt;
	}

	@Override
	public List<LprodVO> lprodPagingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> pagingList = sqlSession.selectList("lprod.lprodPagingList", pageVO);
		
		sqlSession.close();
		return pagingList;
	}

	@Override
	public LprodVO getLprodInfo(String lprod_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		LprodVO lprodVO = sqlSession.selectOne("lprod.getLprodInfo", lprod_id);
		
		sqlSession.close();
		return lprodVO;
	}

}
