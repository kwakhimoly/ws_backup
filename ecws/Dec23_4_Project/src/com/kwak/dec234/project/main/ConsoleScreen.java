package com.kwak.dec234.project.main;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleScreen {
	private Scanner inputSystem;

	public void InputSystem() {
		inputSystem = new Scanner(System.in);
	}

	public int showMainMenu() {
		System.out.println(
	"영화 관리 ======" + "\r\n" + 
	"1.cgv 등록" + "\r\n" + 
	"2.cgv 삭제" + "\r\n" + 
	"3.cgv 조회" + "\r\n" + 
	"4.영화 등록" + "\r\n" + 
	"5.영화 삭제" + "\r\n" + 
	"6.영화 조회" + "\r\n" + 
	"7.상영관 등록" + "\r\n" + 
	"8.상영관 삭제" + "\r\n" + 
	"9.상영관 조회" + "\r\n" + 
	"10.상영 영화 등록" + "\r\n" + 
	"11.상영 영화 삭제" + "\r\n" + 
	"12.상영 영화 조회" + "\r\n" + 
	"13.프로그램 종료" + "\r\n" 
	+ "=============");
		System.out.print("원하는 서비스 번호: ");
		return inputSystem.nextInt();
	}

	public void printResult(String result) {
		System.out.println(result);
	}

	public void printFailTheater() {
		System.out.println("상영 가능한 영화관 이름을 확인하세요.");
	}

	public CGV setCGVInfo() {
		System.out.print("영화관 이름: ");
		String name = inputSystem.next();
		System.out.print("영화관 위치: ");
		String location = inputSystem.next();
		System.out.print("상영관 수: ");
		int room = inputSystem.nextInt();
		return new CGV(name, location, room);
	}

	public Movie setMovieInfo() throws Exception {
		System.out.print("영화 제목: ");
		String m_title = inputSystem.next();
		System.out.print("영화 감독: ");
		String m_director = inputSystem.next();
		System.out.print("영화 개봉일(YYYYMMDD): ");
		String m_date = inputSystem.next();
		System.out.print("러닝타임: ");
		int m_time = inputSystem.nextInt();

		return new Movie(0, m_title, m_director, m_date, m_time);
	}

	public Theater setTheaterInfo() {
		System.out.print("상영관 이름: ");
		String t_name = inputSystem.next();
		System.out.print("상영 영화관 이름: ");
		String t_cgv_name = inputSystem.next();
		System.out.print("상영관 좌석 수: ");
		int t_number = inputSystem.nextInt();

		return new Theater(0, t_name, t_cgv_name, t_number);
	}

	public Every setRMInfo() {
		System.out.print("상영관 고유번호: ");
		int r_t_no = inputSystem.nextInt();
		System.out.print("영화 고유번호: ");
		int r_m_no = inputSystem.nextInt();
		System.out.print("상영관 이름: ");
		String r_t_name = inputSystem.next();
		System.out.print("상영 영화관 이름: ");
		String r_t_cgv_name = inputSystem.next();
		System.out.print("영화 제목: ");
		String r_m_title = inputSystem.next();

		return new Every(0, r_t_no, r_m_no, r_t_name, r_t_cgv_name, r_m_title);
	}

	public String setCGVName() {
		System.out.print("영화관 이름: ");
		String name = inputSystem.next();
		return name;
	}

	public String setMovieTitle() {
		System.out.print("영화 제목: ");
		String m_title = inputSystem.next();
		return m_title;
	}

	public Theater setTheaterCGVName() {
		System.out.println("상영관 이름과 상영 영화관 이름을 정확히 입력해주세요.");
		System.out.print("상영관 이름: ");
		String t_name = inputSystem.next();
		System.out.print("상영 영화관 이름: ");
		String t_cgv_name = inputSystem.next();
		return new Theater(t_name, t_cgv_name);
	}
	
	public Every setRMtm() {
		System.out.print("영화 제목: ");
		String title = inputSystem.next();
		System.out.print("상영 영화관 이름: ");
		String name = inputSystem.next();
		System.out.print("상영관 이름: ");
		String rmt_name = inputSystem.next();
		
		return new Every(title, name, rmt_name);
	}

	public String setRMTitle() {
		System.out.print("영화 제목: ");
		String title = inputSystem.next();
		return title;
	}

	public String setRMName() {
		System.out.print("상영 영화관 이름: ");
		String name = inputSystem.next();
		return name;
	}

	
	public void getCGVInfo(ArrayList<CGV> cgv) {
		for (CGV cgvinfo : cgv) {
			System.out.printf("영화관 이름: %s점\r\n", cgvinfo.getName());
			System.out.printf("영화관 위치: %s\r\n", cgvinfo.getLocation());
			System.out.printf("상영관 수: %d개\r\n", cgvinfo.getRoom());

			System.out.println("--------");
		}
	}

	public void getMovieInfo(ArrayList<Movie> mv) {
		for (Movie movie : mv) {
			System.out.printf("영화 제목: %s\r\n", movie.getM_title());
			System.out.printf("영화 감독: %s\r\n", movie.getM_director());
			System.out.printf("개봉일: %s\r\n", movie.getM_date());
			System.out.printf("러닝타임: %d분\r\n", movie.getM_time());
			System.out.println("---------");
		}
	}

	public void getTheaterInfo(ArrayList<Theater> tt) {
		for (Theater theater : tt) {
			System.out.printf("상영관 이름: %s\r\n", theater.getT_name());
			System.out.printf("상영 영화관 이름: %s\r\n", theater.getT_cgv_name());
			System.out.printf("좌석 수: %d\r\n", theater.getT_number());
			System.out.println("----------");
		}
	}

	public void getRMInfoM(ArrayList<Every> all) {
		for (Every every : all) {
			System.out.printf("영화 고유 번호: %d\r\n", every.getM_no());
			System.out.printf("상영 영화 제목: %s\r\n", every.getM_title());
			System.out.println("----");
		}
	}

	public void getRMInfoT(ArrayList<Every> all) {
		for (Every every2 : all) {
			System.out.printf("상영관 고유 번호: %d\r\n", every2.getT_no());
			System.out.printf("상영관 이름: %s\r\n", every2.getT_name());
			System.out.printf("상영 영화관 이름: %s\r\n", every2.getT_cgv_name());
			System.out.println("----");
		}
	}
	
	public void showRMInfo(ArrayList<Every> all) {
		for (Every ev : all) {
			System.out.printf("상영 영화관 이름: %s\r\n", ev.getT_cgv_name());
			System.out.printf("상영관 이름: %s\r\n", ev.getT_name());
			System.out.printf("영화 제목: %s\r\n", ev.getM_title());
			System.out.println("----");
		}
	}


	public int showSelectCGVPageMenu(int page) {
		System.out.printf("페이지[1~%d]: ", page);
		return inputSystem.nextInt();
	}

	public void bye() {
		inputSystem.close();
	}
}
