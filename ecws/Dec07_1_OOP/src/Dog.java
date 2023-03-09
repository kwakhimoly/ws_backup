
public class Dog {
//	클래스 안에 들어가는 것: 멤버
	
	String name;
	int age;
//	ㄴ멤버변수들 (member variable)
	
	public void bark() {
		System.out.println("멍");
	}
	
	public void printInfo() {
		System.out.println(this.name);
//		this는 생략 가능
		System.out.println(age);
	}
}

//	main이 빠져있으니깐 실행안됨 콘솔에 출력되는건 전에 출력했던게 다시 나오는거야!