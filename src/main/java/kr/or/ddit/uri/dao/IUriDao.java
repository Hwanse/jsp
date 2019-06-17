package kr.or.ddit.uri.dao;

import java.util.List;

import kr.or.ddit.uri.model.UriVO;

/**
* IUriDao.java
*
* @author PC14
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC14 최초 생성
*
* </pre>
*/
public interface IUriDao {
	
	/**
	* Method : getAllUriMapping
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : uri리스트 조회
	*/
	public List<UriVO> getAllUriMapping();
	
	/**
	* Method : getUriMapping
	* 작성자 : PC14
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : 특정 uri조회
	*/
	public UriVO getUriMapping(String uri);
	
}
