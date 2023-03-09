package com.kosa.mvc1.common;
//공통으로 사용하는 사항 클래스로 묶어서 빼내고 상속해서 사용하기
public class BaseDto {
	protected int pg = 0;
	protected int rnum = 0;
	protected String searchOpt=""; //검색어 키워드(제목, 제목+내용)...
	protected String searchKeyword=""; //검색어
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public String getSearchOpt() {
		return searchOpt;
	}
	public void setSearchOpt(String searchOpt) {
		this.searchOpt = searchOpt;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}
