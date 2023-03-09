package com.kosa.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	List<ProductDto> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public ProductManager() {
		super(); //안 써도 원래 부모 생성자 호출
		list.add(new ProductDto(1, "노트북", 1200000, "2020-09-09", "삼성전자"));
		list.add(new ProductDto(2, "갤럭시 S", 7500000, "2022-07-08", "삼성전자"));
		list.add(new ProductDto(3, "노트북", 1200000, "2022-02-07", "엘지전자"));
	}
	
	public void insert() {
		ProductDto dto = new ProductDto();
		int num = list.get(list.size()-1).getPrdNum()+1;
		
		
		dto.setPrdNum(num);
		System.out.print("제품명: ");
		dto.setPrdName(sc.next());
		System.out.print("가격: ");
		dto.setPrdPrice(sc.nextInt());
		System.out.print("제조일: ");
		dto.setPrdDate(sc.next());
		System.out.print("제조사: ");
		dto.setPrdMaker(sc.next());
		
		
		list.add(dto);
	}
	
	void output() {
		for (ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}
	
	void menuDisplay() {
		System.out.println("1.출럭");
		System.out.println("2.추가");
		System.out.println("3.수정");
		System.out.println("4.삭제");
		System.out.println("5.종료");
	}
	
	void start() {
		int menu;
		while (true) {
			menuDisplay();
			
			System.out.println("선택: ");
			menu=sc.nextInt();
			
			switch(menu) {
			case 1:output(); break;
			case 2:insert(); break;
			case 3:modify(); break;
			case 4:delete(); break;
			case 0: return; //함수 종료하기
			}
		}
	}
	
	void modify() {
		System.out.print("수정할 제품 번호: ");
		int num = sc.nextInt();
		int pos = list.indexOf(new ProductDto(num));
//		내부적으로 equlas를 호출해서 원하는 데이터 위치를 찾는다.
//		자바언어는 오류가 발생하면 -1을 리턴하는 식으로 함수를 구성
		
		if(pos==-1) {
//			데이터가 없을 때
			System.out.println("제품을 찾을 수 없습니다.");
			return;
		}
		
		ProductDto dto = list.get(pos);
		System.out.print("제품명 : ");
		dto.setPrdName(sc.next());
		System.out.print("가격 : ");
		dto.setPrdPrice(sc.nextInt());
		System.out.print("제조일 : ");
		dto.setPrdDate(sc.next());
		System.out.print("제조사 : ");
		dto.setPrdMaker(sc.next());	
	}
	
	void delete() {
		System.out.print("수정할 제품 번호: ");
		int num = sc.nextInt();
		int pos = list.indexOf(new ProductDto(num));
//		내부적으로 equlas를 호출해서 원하는 데이터 위치를 찾는다.
//		자바언어는 오류가 발생하면 -1을 리턴하는 식으로 함수를 구성
		
		if(pos==-1) {
//			데이터가 없을 때
			System.out.println("제품을 찾을 수 없습니다.");
			return;
		}
		
		list.remove(new ProductDto(num));
//		여기도 equals 호출함
	}

}
