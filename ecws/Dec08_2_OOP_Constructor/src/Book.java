
public class Book {
//	1. 속성 생각해서 멤버변수들 배치(100% 수작업)
	String title;
	String author;
	int price;
	
//	2. 기본생성자(ctrl+space)
	public Book() {
		// TODO Auto-generated constructor stub
	}

//	3. 오버로딩 된 생성자(Ctrl+Shift+A)
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

//	4. 기타 메소드
	
	public void printBook() {
		System.out.printf("제목: %s\n", title);
		System.out.printf("작가: %s\n", author);
		System.out.printf("가격: %d원\n", price);
	}

}
