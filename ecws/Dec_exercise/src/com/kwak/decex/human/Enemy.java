package com.kwak.decex.human;

import java.util.Random;

public class Enemy {
	private Random cpu = null;
	
	public int enemyFire() {
		cpu = new Random(3);
		int enemyHand = cpu.nextInt(3)+1; 
	return enemyHand;
	}
	
}
