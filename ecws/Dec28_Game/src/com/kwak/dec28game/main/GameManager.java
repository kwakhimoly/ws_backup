package com.kwak.dec28game.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
	List<GameDTO> gameList = new ArrayList<GameDTO>();
//	게임에 대한 정보를 저장할 list ctrl-shift-o
	Scanner k = new Scanner(System.in);

	public void gameStart() {
		while (true) {
			GameDTO dto = new GameDTO();
			System.out.println("1.가위 2.바위 3.보: ");
			dto.setPerson(k.nextInt());
			if (dto.isWinner() == 1) {
				System.out.println("컴퓨터승");
			} else if (dto.isWinner() == 2) {
				System.out.println("사람승");
			} else {
				System.out.println("무승부");
			}
			gameList.add(dto);
			System.out.println("계속?");
			String again = k.next();
			if (again.equals("N")) {
				break;
			}
		}
	}
	
	public void staticDisplay() {
		int comWin = 0;
		int perWin = 0;
		int none = 0;
		for (GameDTO gameDTO : gameList) {
			if(gameDTO.getWinner()==1) {
				comWin++;
			}else if(gameDTO.getWinner()==2) {
				perWin++;
			}else {
				none++;
			}
			System.out.println(gameDTO);
		}
		
		int total = comWin+perWin+none;
		if(perWin==0) {
			System.out.println("승률은 0입니다.");
		} else {
			System.out.printf("승률은 %.2f입니다.", (double)perWin/total);
		}
	}
}
