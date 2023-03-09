
public class Snack extends Product{
int exp;
public Snack() {
	// TODO Auto-generated constructor stub
}

public Snack(String name, int price, int exp) {
//	super(); 
// 기본 생성자 소환 -> 어차피 있으나 없으나 기본생성자 소환은 기본값이기 때문에 별 상관 없음
//	-> 이거 소환하면 이름, 가격 값이 안 소환돼서 null/0 으로 표시되는 대신에 기본 생성자에 있던 hi가 소환됨
	super(name, price); // 생성자 소환
	this.exp = exp;
}

@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(exp);
	}
}
