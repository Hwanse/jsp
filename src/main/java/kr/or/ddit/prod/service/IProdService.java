package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

public interface IProdService {

	/**
	* Method : getProdList
	* 작성자 : PC14
	* 변경이력 :
	* @param prod_lgu
	* @return
	* Method 설명 : 상품분류 코드값에 해당되는 prod리스트 조회
	*/
	public List<ProdVO> getProdList(String prod_lgu);
	
}
