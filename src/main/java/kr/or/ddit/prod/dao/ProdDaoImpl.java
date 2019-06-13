package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVO;

public class ProdDaoImpl implements IProdDao {

	private static IProdDao dao;
	
	private ProdDaoImpl() {

	}
	
	public static IProdDao getInstance(){
		if(dao == null){
			dao = new ProdDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<ProdVO> getProdList(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVO> prodList = sqlSession.selectList("prod.getProdList", prod_lgu);
		sqlSession.close();
		return prodList;
	}

}
