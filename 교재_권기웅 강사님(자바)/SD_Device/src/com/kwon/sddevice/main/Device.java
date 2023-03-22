package com.kwon.sddevice.main;

// 멤버변수명 DB필드명 같을 필요는 없
public class Device {
	private int no;
	private String name;
	private String cate;
	private int price;
	private String where;

	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Device(int no, String name, String cate, int price, String where) {
		super();
		this.no = no;
		this.name = name;
		this.cate = cate;
		this.price = price;
		this.where = where;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}
