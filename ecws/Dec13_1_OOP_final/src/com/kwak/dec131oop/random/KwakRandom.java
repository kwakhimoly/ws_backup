package com.kwak.dec131oop.random;

import java.util.Random;

public class KwakRandom extends Random /*java.util.Random 소환*/ {

	@Override
	public int nextInt(int bound) {
		int a = super.nextInt(bound);
		return (a % 2 == 1) ? nextInt(bound) : a;
	}

}
