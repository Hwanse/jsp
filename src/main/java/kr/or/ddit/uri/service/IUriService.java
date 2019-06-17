package kr.or.ddit.uri.service;

import java.util.List;

import kr.or.ddit.uri.model.UriVO;

public interface IUriService {

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
