package com.kwak.dec234.project.main;

public class Every {
	private int r_no;
	private int t_no;
	private int m_no;
	private String t_name;
	private String t_cgv_name;
	private String m_title;

	public Every() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Every(int r_no, int t_no, int m_no, String t_name, String t_cgv_name, String m_title) {
		super();
		this.r_no = r_no;
		this.t_no = t_no;
		this.m_no = m_no;
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
		this.m_title = m_title;
	}



	public Every(int t_no, int m_no, String t_name, String t_cgv_name, String m_title) {
		super();
		this.t_no = t_no;
		this.m_no = m_no;
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
		this.m_title = m_title;
	}

	public Every(int m_no, String m_title) {
		super();
		this.m_no = m_no;
		this.m_title = m_title;
	}
	

	public Every(int t_no, String t_name, String t_cgv_name) {
		super();
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
	}

	public Every(String m_title, String t_cgv_name, String t_name) {
		super();
		this.m_title = m_title;
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
	}



	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_cgv_name() {
		return t_cgv_name;
	}

	public void setT_cgv_name(String t_cgv_name) {
		this.t_cgv_name = t_cgv_name;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}



	public int getR_no() {
		return r_no;
	}



	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

}
