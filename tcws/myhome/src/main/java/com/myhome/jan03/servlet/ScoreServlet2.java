package com.myhome.jan03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Score
 */
@WebServlet("/teacherscore")
public class ScoreServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		한글 문자셋 받을 때 안 깨지게
		response.setCharacterEncoding("UTF-8");
//		한글 문자셋 응답 시에도 안 깨지게
		
//		request 값을 받아오는 객체(요구사항을 클라이언트로부터 받아온다)
//		request.getParameter("input 태그의 name 속성"); 을 통해 값을 받아온다.
//		getParameter 는 String으로 된 파라미터를 받아 String을 반환한다.
//		<input type = "text" name = "userName" value="홍길동"> 이라는 태그가 있을 경우에,
//		getParameter("userName")이라고 요청을 하면 value 속성에 저장된 값을 반환한다.
//		한글은 인코딩을 안 할 경우에 깨진다.
		
		String name = request.getParameter("userName");
		String sKor = request.getParameter("kor"); //정수로 못 받아온다.
//		먼저 String으로 받아와서 int로 바꾸어야 한다.
		String sEng = request.getParameter("eng");
		String sMat = request.getParameter("mat");
		
//		정수 변수로 전환. 만약 파라미터가 존재하지 않으면 null, 존재해도 값이 없으면 ""이 넘어온다
//		값이 없을 경우 Integer.parseInt()는 예외를 발생시킨다. 제대로 된 값이 넘어왔는지 확인은 개발자가 해야한다.
		
		int nKor, nEng, nMat;
		nKor = Integer.parseInt(CommonUtil.nullToVal(sKor,"0"));
//		CommonUtil.nullToVal()은 static 함수라서 클래스로 호출이 가능하다.
//		CommonUtil 클래스는 생성자가 private라서 객체를 생성하지 못한다.
//		클래스 설계방법 중에 하나인데, 클래스 내부에서 공통의 데이터가 없이 기능상 공유만 있을 경우에 이런 식으로 설계한다.
//		CommonUtil util = new CommonUtil(); 은 현재 에러가 발생한다.
		nEng = Integer.parseInt(CommonUtil.nullToVal(sEng, "0"));
		nMat = Integer.parseInt(CommonUtil.nullToVal(sMat, "0"));
		
		int total = nKor + nEng + nMat;
		float avg = total/3.0f; 
		//total/3으로 쓰면 정수/정수라서 결과도 정수이다. 나중에 float로 형전환을 해도 이미 소수점 이하가 없어진 상태에서 뒤에 소수점만 붙는다.
		//두 개의 값 중 하나를 float으로 전환하면 나머지 하나도 float으로 전환되어서 연산되기 때문에 결과도 float이다.
		//3.0으로 쓰면 자바가 double형 상수로 알아듣기 때문에 경고나 에러가 뜬다. 좌변의 변수 avg가 float 이라서 double 형 값을 입력하면
		//메모리 크기가 달라서 데이터 손실이 벌어지기 때문에 자동 형 전환이 안 된다. 그래서 3.0f로 나눈다. 
		
		String result = String.format("%s 님의 총점은 %d이고 평균은 %.2f입니다.", name, total, avg);
		
		PrintWriter out = response.getWriter();
//		print writer : 브라우저에 정보를 출력하는 객체
		
		out.println("<html>"); // 보내는 정보가 html임을 알린다. 그래야 태그가 태그로 작동한다.
		out.println("<meta charset='utf-8'>");
		out.println("<h1>"+result+"</h1>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
