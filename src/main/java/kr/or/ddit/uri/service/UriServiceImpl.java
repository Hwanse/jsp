package kr.or.ddit.uri.service;

import java.util.List;

import kr.or.ddit.uri.dao.IUriDao;
import kr.or.ddit.uri.dao.UriDaoImpl;
import kr.or.ddit.uri.model.UriVO;

public class UriServiceImpl implements IUriService {

	private IUriDao dao;
	
	public UriServiceImpl() {
		dao = new UriDaoImpl();
	}
	
	@Override
	public List<UriVO> getAllUriMapping() {
		List<UriVO> uriList = dao.getAllUriMapping();
		return uriList;
	}

	@Override
	public UriVO getUriMapping(String uri) {
		UriVO uriVO = dao.getUriMapping(uri);
		return uriVO;
	}

}
