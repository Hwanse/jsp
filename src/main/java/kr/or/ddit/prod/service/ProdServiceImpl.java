package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVO;

public class ProdServiceImpl implements IProdService {

	private static IProdService service;
	private IProdDao dao;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance(){
		if(service == null){
			service = new ProdServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<ProdVO> getProdList(String prod_lgu) {
		List<ProdVO> prodList = dao.getProdList(prod_lgu); 
		return prodList;
	}

}
