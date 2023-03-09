package com.kwak.jan02.myhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sX = request.getParameter("x");
		String sY = request.getParameter("y");
//		에러 처리 하나도 안 한 상태 => 따로 해줘야 함(try-catch)
		
		String operator = CommonUtil.nullToVal(
				request.getParameter("operator"),"add");
		System.out.println(operator);
		
		int nX = Integer.parseInt(sX);
		int nY = Integer.parseInt(sY);
		
		PrintWriter out = response.getWriter();
		
		if (operator.equals("add")) {
			out.println("<h1>"+String.format("%d + %d = %d", nX, nY, nX + nY)+"</h1>");	
		} else if (operator.equals("sub")) {
			out.println("<h1>"+String.format("%d - %d = %d", nX, nY, nX - nY)+"</h1>");	
		} else if (operator.equals("mul")) {
			out.println("<h1>"+String.format("%d * %d = %d", nX, nY, nX * nY)+"</h1>");				
		} else if (operator.equals("div")) {
			out.println("<h1>"+String.format("%d / %d = %.2f", nX, nY, nX / (double)nY)+"</h1>");			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
