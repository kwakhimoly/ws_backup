package com.kwak.mycompany.gallery;

import java.util.List;

public interface GalleryDao {
	public List<GalleryDto> getList(GalleryDto dto);
	public int getTotalCnt(GalleryDto dto);
	public void insert(GalleryDto dto);
}
