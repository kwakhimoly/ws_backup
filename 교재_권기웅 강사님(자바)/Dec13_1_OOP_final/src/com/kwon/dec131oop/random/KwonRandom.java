package com.kwon.dec131oop.random;

import java.util.Random;

// 랜덤한 정수(짝수만) 나오는 기능
// 원래 쓰던 Random : 랜덤한 정수 나오게 해주
// + 짝수만 나오게 추가
public class KwonRandom extends Random {
	@Override
	public int nextInt(int bound) {
		int a = super.nextInt(bound);
		return (a % 2 == 1) ? nextInt(bound) : a; 
	}
}





