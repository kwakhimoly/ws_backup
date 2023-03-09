package com.kwak.decex.human;

import java.util.Scanner;

public class User {
	private Scanner brain = null;

	public int userFire() {
		brain = new Scanner(System.in);
		int userHand = brain.nextInt();
		return (userHand > 3 || userHand < 1) ? userFire() : userHand;
	}

}
