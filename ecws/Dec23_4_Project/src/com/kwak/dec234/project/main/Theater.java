package com.kwak.dec234.project.main;

public class Theater {
	private int t_no;
	private String t_name;
	private String t_cgv_name;
	private int t_number;

	public Theater() {
		// TODO Auto-generated constructor stub
	}

	public Theater(int t_no, String t_name, String t_cgv_name, int t_number) {
		super();
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
		this.t_number = t_number;
	}
	

	public Theater(String t_name, String t_cgv_name) {
		super();
		this.t_name = t_name;
		this.t_cgv_name = t_cgv_name;
	}

	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
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

	public int getT_number() {
		return t_number;
	}

	public void setT_number(int t_number) {
		this.t_number = t_number;
	}

}
