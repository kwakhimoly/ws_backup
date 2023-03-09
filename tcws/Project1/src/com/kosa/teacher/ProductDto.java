package com.kosa.teacher;


public class ProductDto {
	private int prdNum;
	private String prdName;
	private int prdPrice;
	private String prdDate;
	private String prdMaker;
	
//	기본 생성자는 아무것도 안 만들었을 때
//	ProductDto dto = new ProductDto(); -> 이 때 기본생성자 호출 됨
//	사용자가 생성자를 별도로 만들기 시작하면 기본 생성자를 안 만들어줌 -> 꼭 기본 생성자 같이 만들어줘야 함.
	
	public ProductDto() {
		
	}
	
	
//	객체 값 비교 시 사용한다.
//	ProductDto d1 = new ProductDto();
//	ProductDto d2 = new ProductDto();
//	d1==d2 : 서로 같은 메모리를 공유하고 있느냐
//	d1.equals(d2) : 서로 같은 내용을 갖고 있느냐
//	Object의 자식 - equlas 함수
//	자바 쪽에서 equals 메소드와 hashCode 메소드는 같이 오버라이딩 해달라.
	@Override
	public boolean equals(Object obj) {
//		ProductDto 타입 -> Object 타입으로 전환 : upcasting => downcasting을 해줘야 접근 가능
		ProductDto tempDto = (ProductDto)obj;
//		매개변수로 전달되는 Object 타입은 실제로 값을 비교할 객체의 타입(ProductDto)
		return this.prdNum==tempDto.prdNum; // 번호만 같으면 두 객체가 같다고 판단
//		list 클래스에 indexOf 함수에서 이 부분을 호출한다. -> 선형검색 함수 사용하려고
	}

	@Override
	public int hashCode() {
		return this.prdNum;
	}


	@Override
	public String toString() {
		return String.format("%d, %s, %d, %s, %s", this.prdNum, this.prdName, this.prdPrice, this.prdDate, this.prdMaker);
	}

	public ProductDto(int num) {
		this.prdNum=num;
	}

	public ProductDto(int prdNum, String prdName, int prdPrice, String prdDate, String prdMaker) {
		super();
		this.prdNum = prdNum;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdDate = prdDate;
		this.prdMaker = prdMaker;
	}



	public int getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdDate() {
		return prdDate;
	}

	public void setPrdDate(String prdDate) {
		this.prdDate = prdDate;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

}
