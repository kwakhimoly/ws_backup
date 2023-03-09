package com.myhome.jan04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeekPayServlet
 */
@WebServlet("/weekpay")
public class WeekPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeekPayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("username");
		String shour = request.getParameter("workhour");
		String spay = request.getParameter("payment");
		
		int hour = Integer.parseInt(shour);
		int pay = Integer.parseInt(spay);
		int hourPay = hour*pay;
		double payment = 0;
		
		if(hour>20) {
			payment = (hour-20)*(pay/2);
		} else {
			payment = 0;
		}
		
//		String result = String.format("%s님의 근무시간은 %d였으며, 기본급은 %d이고, 수당은 %d입니다. 합산은 %d입니다.", 
//				name, hour*pay, payment, hour*pay+payment);
		
		PrintWriter out = response.getWriter();
		out.println(String.format(
				"<h1>"+"%s 님의 근무시간은 %d시간였으며, <br> 기본급은 %d원이고, <br> 수당은 %.1f원입니다. <br><hr> 합산은 %.1f원입니다."
		, name, hour, hourPay, payment, hourPay+payment)+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
