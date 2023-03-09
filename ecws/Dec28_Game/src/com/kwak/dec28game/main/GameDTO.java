package com.kwak.dec28game.main;

public class GameDTO {
	int computer; // 컴퓨터의 생각
	int person = 0; // 사람의 생각
	int winner = 0; // 승자 1.컴퓨터 2.사람 3.무승부

	public int isWinner() {
		if (computer == person) {
			winner = 3; // 무승부
			return winner; // 일이 종료한 상태니까 return
		}

		if (computer == 1 && person == 2) {
			winner = 2; // 사람승
		} else if (computer == 1 && person == 3) {
			winner = 1;
		} else if (computer == 2 && person == 1) {
			winner = 1;
		} else if (computer == 2 && person == 3) {
			winner = 2;
		} else if (computer == 3 && person == 1) {
			winner = 2;
		} else if (computer == 3 && person == 2) {
			winner = 1;
		}
		return winner;
	}

	public GameDTO() {
		super();
		computer = (int) Math.random() * 3 + 1;
	}

	@Override
	public String toString() {
		return String.format("컴: %d, 사람: %d, 승자: %d", computer, person, winner);

	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

}
