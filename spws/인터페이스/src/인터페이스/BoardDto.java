package 인터페이스;

public class BoardDto {
	private String title = "";
	private String writer = "";
	private String content = "";

	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub

		//		기본 생성자의 경우에는 사용자가 만들지 않으면 시스템이 만들어서라도 호출함.
		//		근데, 사용자가 디폴트 생성자(매개변수 없는 생성자)를 만들지 않고 
		//		매개 변수 있는 다른 생성자를 만들면 시스템이 만들던 디폴트 생성자를 안 만들어 줌.
		//		그래서 객체 생성 시 기본 생성이 안된다. 다른 생성자 만들 때 꼭 디폴트 생성자도 만들자.
	}

	public BoardDto(String title, String writer, String content) {
		//		DB에선 생성자가 필요 없음.
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s", title, writer, content);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
