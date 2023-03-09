package com.kosa.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.domain.SampleDto;
import com.kosa.myapp.repository.SampleDao;
@Service
public class SampleService {
	@Autowired
	private SampleDao dao;

	public List<SampleDto> getList(SampleDto dto) {
		List<SampleDto> list = dao.findAll();
		return list;
	}
	
	public List<SampleDto> findTest(SampleDto dto){
		return dao.findByTestOrderBySeqDesc(dto.getTest());
	}
	
	public List<SampleDto> searchTest(SampleDto dto){
		return dao.searchByTest(dto.getTest());
	}
	
	public void insert(SampleDto dto) {
		dao.save(dto);
//		insert 함수 = save, update를 하고 싶으면 seq 값 넣기 -> 그럼 update로 알아듣고 update로 진행함
//		seq이 없으면 insert로 진행
	}
	
	public void update(SampleDto dto) {
		dao.save(dto);
	}
	
	public void delete(SampleDto dto) {
		dao.delete(dto);
	}
}
