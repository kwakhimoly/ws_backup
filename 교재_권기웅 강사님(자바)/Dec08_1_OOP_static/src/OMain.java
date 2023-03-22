// WORA(Write Once, Run Anywhere)

// 한국어로 설계
// -번역(coding)-> .java
// -번역(compile)-> .class
// -압축-> .jar
// -실행->
// 실행OS에 맞게 JVM(Java Virtual Machine)이 만들어져서 올라감 : 느려
// -> 1) 프로그램 소스가 stack에
// -> 2) static멤버변수가 static영역에
// -> 3) JVM이 OMain.main(...);을 실행
// -> ...

public class OMain {
	public static void main(String[] args) {
		UnitConverter.toInch(30);
		// UnitConverter uc = new UnitConverter();
		// uc.toInch(30);
		System.out.println("-----");
		
		System.out.println(Gejang.producer);
		Gejang.test();
		System.out.println("-----");
		
		Gejang g = new Gejang();
		g.name = "설날특선...";
		g.weight = 5;
		g.price = 39900;
		g.producer = "최수미";
		g.showInfo();
		System.out.println("-----");
		
		Gejang g2 = new Gejang();
		g2.name = "x-mas특선";
		g2.weight = 3;
		g2.price = 59900;
		//g2.producer = "김수미";
		g2.showInfo();
	}
}
