package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserService {

	/**
	 * 
	* Method : userList
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체리스트 조회
	 */
	public List<UserVO> userList();
	
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC14
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	public UserVO getUser(String id);
}
