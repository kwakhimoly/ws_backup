package bmiTest;

import java.util.Scanner;

/*첫 실행은 main 가서 해야 이클립스가 잘 알아먹음
두번째부터는 대충 알아서*/


public class Patient {
	String name;
	double height;
	double weight;
	double bmi;
	String status;
	Scanner mouth = new Scanner(System.in);
//	-> 타고난 속성: 멤버 변수

	public String tellName() {
		return mouth.next();
	}

	public double tellHeight() {
		return mouth.nextDouble();
	}

	public double tellWeight() {
		return mouth.nextDouble();
	}
}
