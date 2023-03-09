package com.kwak.jan02.myhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request -> 클라이언트로부터 요청을 받아오는 객체
//		response -> 서버에서 클라이언트에게 응답을 보내기 위한 객체 
		
//		ctrl+shift+o -> 한 번에 import 하기
//		한글을 안 깨지게 하려면 
		response.setCharacterEncoding("utf-8");
//		한글 받아올 때 안 깨지게 받아올 수 있다
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<meta charset = 'utf-8'>");
		out.println("<h1>Hello Servlet</h1>");
		out.println("안녕하세요");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
