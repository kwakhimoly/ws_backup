package com.kosa.myapp.guestbook;

import lombok.Getter;
import lombok.Setter;

//	annotation으로 getter / setter 지원. lombok에서 지원.
@Setter
@Getter
public class GuestbookDto {
	private String id="";
	private String title="";
	private String writer ="";
	private String contents="";
	private String wdate="";
}
