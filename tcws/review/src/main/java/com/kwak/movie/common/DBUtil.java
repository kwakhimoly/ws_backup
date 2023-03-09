package com.kwak.movie.common;

public final class DBUtil {

	public final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static String USERID = "k";
	public final static String PWD = "1234";

//	public(외부에서 접근 가능), final(상수), static(객체 없이 사용 가능)

	private DBUtil() {
		// 클래스 외부에서 객체 생성 못하게 막기
	}
}
