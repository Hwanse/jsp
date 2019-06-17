package kr.or.ddit.uri.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.uri.model.UriVO;

public class UriDaoImpl implements IUriDao {

	/**
	* Method : getAllUriMapping
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : uri리스트 조회
	*/
	@Override
	public List<UriVO> getAllUriMapping() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UriVO> uriList = sqlSession.selectList("uri.getAllUriMapping");
		return uriList;
	}
	
	/**
	* Method : getUriMapping
	* 작성자 : PC14
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : 특정 uri조회
	*/
	@Override
	public UriVO getUriMapping(String uri) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UriVO uriVO = sqlSession.selectOne("uri.getUriMapping",uri);
		return uriVO;
	}

}
