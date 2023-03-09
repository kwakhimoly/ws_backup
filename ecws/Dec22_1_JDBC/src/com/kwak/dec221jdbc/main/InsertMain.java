package com.kwak.dec221jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain {
//	지점명: 교보문고 합정점
//		위치: 합정
//			크기: 130
	

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		Scanner k = new Scanner(System.in);
		try {
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
			con = DriverManager.getConnection(url, "khy", "sol0415");
			
//			데이터 확보(입력받기)
			System.out.print("지점명: ");
			String n = k.next();
			
			System.out.print("위치: ");
			String a = k.next();
			
			System.out.print("매장 크기: ");
			int s = k.nextInt();
			
//			sql
//			값 들어갈 부분은 ? 로 처리, insert~(; 빼고)해서 미완성으로 놔두기
			String sql 	= "insert into dec22_store values " // 엔터칠 땐 띄어쓰기 조심!
						+ "(?, ?, ?)"; // "" 안에 ; 빼고
//							1, 2, 3
			
//			DB 관련 작업들 다 해주는 매니저 있음 -> 1회용
			psmt = con.prepareStatement(sql);	
			
//			1. sql완성 : psmt.setXXX(물음표 번호(1번부터), 값);
			psmt.setString(1, n);
			psmt.setString(2, a);
			psmt.setInt(3, s);
			
//			2.db 서버로 전송
//			3.서버에서 원격 실행
//			4.결과 받아와서..
//			=> 
			int row = psmt.executeUpdate();
//				1줄 등록
			
			if(row == 1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

//		닫는 것도 순서 중요함 -> 가장 안에 있는 걸 먼저 닫고 그 다음에 밖에 있는 걸 닫아야 안에 있는 걸 무사히 닫을 수 있음
//		ex) psmt=소속=>con (순서대로 만든다면 만들어진 역순으로 닫아야함)
		try {psmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}
