package com.kosa.ajaxtest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Person
 */
@WebServlet("/person.do")
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked") //자바 버전이 올라가면서 이전 버전에 경고가 나옴 -> 주석 써주면서 경고를 무시하라는 것
	//↑↑ 이거 없으면 리눅스에서 경고 때문에 서버가 안 올라 갈 수 있음. 해주는 게 좋음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//org.json.simple.JSONObject => HashMap이랑 사용법이 똑같음
		//여러명일 때는 JSONArray 객체를 사용
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("username", "홍길동");
		obj.put("email", "hong@kaka.com");
		obj.put("phone", "010-0000-0000");
		array.add(obj);
		
			obj = new JSONObject();
		obj.put("username", "김길동");
		obj.put("email", "kim@kaka.com");
		obj.put("phone", "010-0000-1111");
		array.add(obj);

			obj = new JSONObject();
		obj.put("username", "이길동");
		obj.put("email", "lee@kaka.com");
		obj.put("phone", "010-0000-2222");
		array.add(obj);
		
			obj = new JSONObject();
		obj.put("username", "박길동");
		obj.put("email", "park@kaka.com");
		obj.put("phone", "010-0000-3333");
		array.add(obj);
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(array.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
