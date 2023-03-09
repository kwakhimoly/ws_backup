
public class Movie {
	String name;
	String director;
	String actor;
	int year;
	int month;
	int day;
	String genre;
	boolean fun;
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(director);
		System.out.println(actor);
		System.out.printf("%d년 %d월 %d일 개봉\n", year, month, day);
		System.out.println(genre);
		System.out.println(fun);
	}
}
