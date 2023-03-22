import java.util.Scanner;

// OOP
//		1. 실생활묘사 -> 코드 보기 쉽
//		2. 실생활스럽게 데이터를 묶어 다닐 수

// DTO(Data Temp/Transfer Obj)

public class Guest {
	String name;
	double height;
	double weight;
	double bmi;
	String status;
	Scanner mouth = new Scanner(System.in);

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
