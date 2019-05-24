package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements IUserDao{
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);
	
	public static void main(String[] args) {
		
		// gwt입력 + ctrl + space ==> 아래와 같은 주석이 달린다.
		/***Given***/
		IUserDao userDao = new UserDaoImpl();
		String userId = "brown";

		/***When***/
		List<UserVO> userList = userDao.userList();
		UserVO userInfo = userDao.getUser(userId);

		/***Then***/
		logger.debug("userList : {} ", userList);
		logger.debug("userInfo - ( id = {} , name = {} ,pw = {} , alias = {} )" , userInfo.getUserId()
				, userInfo.getName(), userInfo.getPass(), userInfo.getAlias() );
		

	}
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		List<UserVO> userList = sqlSession.selectList("userList");
	
		return userList;
	}

	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		UserVO userInfo = sqlSession.selectOne("getUser", userId);
		
		return userInfo;
	}
	
}
