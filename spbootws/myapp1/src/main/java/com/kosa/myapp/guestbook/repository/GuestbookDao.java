package com.kosa.myapp.guestbook.repository;

import java.util.List;

import com.kosa.myapp.guestbook.domain.GuestbookDto;

public interface GuestbookDao {
	List<GuestbookDto> getList(GuestbookDto dto);
	void insert(GuestbookDto dto);
	GuestbookDto getView(GuestbookDto dto);
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
}
