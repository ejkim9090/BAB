package kh.spring.bab.info.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.bab.info.domain.Info;
import kh.spring.bab.info.model.dao.InfoDao;

@Service
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	private InfoDao dao;

	//내정보수정 메인
	@Override
	public Info main(Info info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//내정보수정 업데이트
	@Override
	public Info update(Info info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
