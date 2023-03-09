package com.kwak.dec232mvc.main;

public class CalcResult {
private int plus;
private int minus;
private int multiple;
private int division;

public CalcResult() {
	// TODO Auto-generated constructor stub
}

public CalcResult(int plus, int minus, int multiple, int division) {
	super();
	this.plus = plus;
	this.minus = minus;
	this.multiple = multiple;
	this.division = division;
}

public int getPlus() {
	return plus;
}

public void setPlus(int plus) {
	this.plus = plus;
}

public int getMinus() {
	return minus;
}

public void setMinus(int minus) {
	this.minus = minus;
}

public int getMultiple() {
	return multiple;
}

public void setMultiple(int multiple) {
	this.multiple = multiple;
}

public int getDivision() {
	return division;
}

public void setDivision(int division) {
	this.division = division;
}


}
