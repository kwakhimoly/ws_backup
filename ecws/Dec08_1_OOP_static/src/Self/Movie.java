package Self;

public class Movie {
	String title;
	int yearMonthDay;
	double rate;
	boolean again;
	String where;
	static String who = "I watched";
	
	public void printInfo() {
		System.out.printf("영화 제목: %s\n", title);
		System.out.printf("개봉날짜: %d\n", yearMonthDay);
		System.out.printf("별점: %.1f / 5.0\n", rate);
		System.out.printf("다시 볼 생각 있어?: %b\n", again);
		System.out.printf("관람 장소: %s\n", where);
		System.out.println(who);
	}
}
