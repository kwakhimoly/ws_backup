package com.kwak.mycompany.gallery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService {
	@Resource(name = "galleryDao")
	GalleryDao dao;

	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(GalleryDto dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public void insert(GalleryDto dto) {
		dao.insert(dto);
	}
}
