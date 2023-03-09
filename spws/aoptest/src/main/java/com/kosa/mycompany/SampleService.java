package com.kosa.mycompany;

public interface SampleService {
	public void displayName();
	public void displayNumber();
	
	
//	중요사항: AOP에서 사용할 메소드는 반환값이 Object 류여야 함.
	public Object displayNumber(int limit);
	
	public void guguDan(int dan);
}
