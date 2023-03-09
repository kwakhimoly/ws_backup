package com.kwak.decex.human;

import java.util.ArrayList;
import java.util.Comparator;

public class Jury {
	private ArrayList<String> Rulebook = new ArrayList<>();

	public void start() {
		readRulebok();
		pronounce(userPick(), enemyPick());
	}

	public void readRulebok() {
		Rulebook.add("가위");
		Rulebook.add("바위");
		Rulebook.add("보");

		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};

		Rulebook.sort(c);

		for (int i = 1; i <= Rulebook.size(); i++) {
			System.out.printf("%d. %s\r\n", i, Rulebook.get(i-1));
		}
		
	}

	public int userPick() {
		User u = new User();
		System.out.print("뭐: ");
		int user = u.userFire();
		return user;
	}

	public int enemyPick() {
		Enemy e = new Enemy();
		int enemy = e.enemyFire();
		return enemy;
	}
	
	public void pronounce(int user, int enemy) {
		if(user == 1) {
			System.out.println(Rulebook.get(0));
		} else if(user==2) {
			System.out.println(Rulebook.get(1));
		} else if(user==3) {
			System.out.println(Rulebook.get(2));
		}
		
		if(enemy==1){
			System.out.println(Rulebook.get(0));
		} else if(enemy==2) {
			System.out.println(Rulebook.get(1));
		} else if(enemy==3) {
			System.out.println(Rulebook.get(2));
		}
	}

}
