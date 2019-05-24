package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;

public class UserServiceImpl implements IUserService{

	
	/**
	 * 
	* Method : userList
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		IUserDao userDao = new UserDaoImpl();
		List<UserVO> userList = userDao.userList();
		return userList;
	}

	@Override
	public UserVO getUser(String id) {
		IUserDao userDao = new UserDaoImpl();
		UserVO vo = userDao.getUser(id);
		
		return vo;
	}

	
}
