package com.kwak.jan31.main;

import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {
		
		ProductManager pm = new ProductManager();
		ProductDto dto = new ProductDto();
		
		Scanner k = new Scanner(System.in);
		
		
		
	while(true){
		
		pm.showMenu();
		int select = k.nextInt();
		if(select==1) {
			pm.printInfo(dto);
		} else if(select==2) {
			System.out.print("제품 이름: ");
			String prdName = k.next();
			System.out.print("제품 가격(숫자만 입력): ");
			int prdPrice = k.nextInt();
			System.out.print("제품 출시일(yyyy-mm-dd): ");
			String prdDate = k.next();
			System.out.print("메이커: ");
			String prdMaker = k.next();
			pm.addInfo(prdName, prdPrice, prdDate, prdMaker);
		} else if(select==3) {
			System.out.print("수정할 제품의 제품 번호를 입력하세요: ");
			int i = k.nextInt();
			System.out.print("제품 이름: ");
			String prdName = k.next();
			System.out.print("제품 가격(숫자만 입력): ");
			int prdPrice = k.nextInt();
			System.out.print("제품 출시일(yyyy-mm-dd): ");
			String prdDate = k.next();
			System.out.print("메이커: ");
			String prdMaker = k.next();
			pm.updateInfo(i, prdName, prdPrice, prdDate, prdMaker);
		} else if(select==4) {
			System.out.print("삭제할 제품의 번호를 입력하세요: ");
			int i = k.nextInt();
			pm.deleteInfo(i);
		} else if(select==5) {
			k.close();
			return;
		} 
	}
		
	}
}
