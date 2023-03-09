package com.kwak.dec162uc.sub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StationInfo {
	private Date when;
	private String no;
	private String stationNo;
	private double enter;
	private double out;

	public StationInfo() {
		// TODO Auto-generated constructor stub
	}

	public StationInfo(String line) throws ParseException {
		String[] lineSplit = line.split(",");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		String w = lineSplit[0] + lineSplit[1] + lineSplit[2];
		when = sdf.parse(w);
		no = lineSplit[3];
		stationNo = lineSplit[4];
		enter = Double.parseDouble(lineSplit[5]);
		out = Double.parseDouble(lineSplit[6]);

	}

	public void print() {
		System.out.println(new SimpleDateFormat("yyyy/MM/dd(E)").format(when));
		System.out.println(no);
		System.out.println(stationNo);
		System.out.println(enter);
		System.out.println(out);
	}
	
	

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public double getEnter() {
		return enter;
	}

	public void setEnter(double enter) {
		this.enter = enter;
	}

	public double getOut() {
		return out;
	}

	public void setOut(double out) {
		this.out = out;
	}

}
