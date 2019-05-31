package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
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

	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	public Map<String, Object> userPagingList(PageVO pageVO){
		IUserDao userDao = new UserDaoImpl();
		
		// 1. List<UserVO>, userCnt 를 필드로 하는 VO
		
		// 2. List<Object>, resultList = new ArrayList<Object>();
		// 	  resultList.add(userList);
		//	  rusultList.add(usersCnt);
		
		// 3. Map<String, Object> resultMap = new hashMap<String, Object>();
		//	  resultMap.put("userList", userList);
		//	  resultMap.put("usersCnt, usersCnt);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
//		resultMap.put("userList", userDao.userPagingList(pageVO));
//		resultMap.put("usersCnt", userDao.usersCnt());
		
		List<UserVO> userList = userDao.userPagingList(pageVO);
		int usersCnt = userDao.usersCnt();
		resultMap.put("userList", userList);
		resultMap.put("usersCnt", usersCnt);
		
		// usersCnt --> paginationSize 변경
		// pageSize --> pageVO.getPageSize();
		
//		int paginationSize = (int)Math.ceil( (double)usersCnt/ pageVO.getPageSize() );
		int paginationSize = 0;
		if(usersCnt % pageVO.getPageSize() == 0){
			paginationSize = usersCnt / pageVO.getPageSize();
		} else{
			paginationSize = usersCnt / pageVO.getPageSize() + 1;
		}
		
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVO userVO) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.insertUser(userVO);
		
		return result;
	}

	@Override
	public int updateUser(UserVO userVO) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.updateUser(userVO);
		return result;
	}
	
	
	
}
