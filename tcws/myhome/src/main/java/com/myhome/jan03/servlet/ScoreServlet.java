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
@WebServlet("/Score")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8"); //한글 안깨지게
		String name = request.getParameter("userName");
		String sKor = request.getParameter("kor");
		String sEng = request.getParameter("eng");
		String sMat = request.getParameter("mat");
		
		int kor = Integer.parseInt(sKor);
		int eng = Integer.parseInt(sEng);
		int mat = Integer.parseInt(sMat);
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>"+String.format("이름: %s <br> 국어: %d <br> 영어: %d <br> 수학: %d", name, kor, eng, mat)+"</h1>");
		out.println("<h1>"+String.format("총점은 %d점, 평균은 %.2f점입니다.", (kor+eng+mat), ((double)kor+eng+mat)/3)+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
