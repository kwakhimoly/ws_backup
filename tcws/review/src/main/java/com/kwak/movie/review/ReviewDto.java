package com.kwak.movie.review;

import com.kwak.movie.common.BaseDto;

public class ReviewDto extends BaseDto {
	private String m_seq="";
	private String m_password="";
	private String m_title="";
	private String m_writer="";
	private String m_director="";
	private String m_actor="";
	private String m_rate="";
	private String m_review="";
	private String m_date="";
	private String m_poster="";
	private String m_wdate="";
	
	
	public String getM_wdate() {
		return m_wdate;
	}
	public void setM_wdate(String m_wdate) {
		this.m_wdate = m_wdate;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_writer() {
		return m_writer;
	}
	public void setM_writer(String m_writer) {
		this.m_writer = m_writer;
	}
	public String getM_seq() {
		return m_seq;
	}
	public void setM_seq(String m_seq) {
		this.m_seq = m_seq;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_director() {
		return m_director;
	}
	public void setM_director(String m_director) {
		this.m_director = m_director;
	}
	public String getM_actor() {
		return m_actor;
	}
	public void setM_actor(String m_actor) {
		this.m_actor = m_actor;
	}
	public String getM_rate() {
		return m_rate;
	}
	public void setM_rate(String m_rate) {
		this.m_rate = m_rate;
	}
	public String getM_review() {
		return m_review;
	}
	public void setM_review(String m_review) {
		this.m_review = m_review;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getM_poster() {
		return m_poster;
	}
	public void setM_poster(String m_poster) {
		this.m_poster = m_poster;
	}
	
	
}
