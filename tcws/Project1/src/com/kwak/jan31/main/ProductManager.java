package com.kwak.jan31.main;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	List<ProductDto> list = new ArrayList<>();
	public ProductManager() {
		list.add(new ProductDto(1, "노트북", 1200000, "2020-09-09", "삼성전자"));
		list.add(new ProductDto(2, "갤럭시 S", 7500000, "2022-07-08", "삼성전자"));
		list.add(new ProductDto(3, "노트북", 1200000, "2022-02-07", "엘지전자"));
	}
	
	public void showMenu() {
		System.out.println("메뉴");
		System.out.printf("1.출력\r\n2.추가\r\n3.수정\r\n4.삭제\r\n5.종료\r\n");
		System.out.print("입력하세요(1~5): \r\n");
	}
	
	public void printInfo(ProductDto dto) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPrdNum());
			System.out.println(list.get(i).getPrdName());
			System.out.println(list.get(i).getPrdPrice());
			System.out.println(list.get(i).getPrdDate());
			System.out.println(list.get(i).getPrdMaker());
			System.out.println("----------");
		}
		
	}

	public void addInfo(String prdName, int prdPrice, String prdDate, String prdMaker) {
		list.add(new ProductDto(list.get(list.size()-1).getPrdNum()+1, prdName, prdPrice, prdDate, prdMaker));
		System.out.println("추가 완료");
	}
	
	public void updateInfo(int i, String prdName, int prdPrice, String prdDate, String prdMaker) {
		int prdNum=i-1;
		ProductDto dto = list.get(prdNum);
		if(dto.getPrdNum()==i) {
			dto.setPrdName(prdName);
			dto.setPrdPrice(prdPrice);
			dto.setPrdDate(prdDate);
			dto.setPrdMaker(prdMaker);
			System.out.println("수정 완료");
			System.out.println("------");
		} else {
			System.out.println("제품 번호 확인");
			System.out.println("------");
		}
	}
	
	public void deleteInfo(int i) {
		int prdNum = i-1;
		list.remove(prdNum);
		System.out.println("삭제 완료");
		System.out.println("------");
	}
	
}
