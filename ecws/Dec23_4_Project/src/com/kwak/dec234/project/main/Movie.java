package com.kwak.dec234.project.main;


public class Movie {
	private int m_no;
	private String m_title;
	private String m_director;
	private String m_date;
	private int m_time;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(int m_no, String m_title, String m_director, String m_date, int m_time) {
		super();
		this.m_no = m_no;
		this.m_title = m_title;
		this.m_director = m_director;
		this.m_date = m_date;
		this.m_time = m_time;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
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

	public String getM_date() {
		return m_date;
	}

	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	public int getM_time() {
		return m_time;
	}

	public void setM_time(int m_time) {
		this.m_time = m_time;
	}


	




}
