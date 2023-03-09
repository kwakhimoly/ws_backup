package com.kosa.ajaxtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class GuestbookController
 */
@WebServlet("/guest.do")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setCharacterEncoding("utf-8");
//		String result = "{\"username\":\"홍길동\", \"email\":\"hong@dada.com\"}";
//		//JSON으로 한글 보내고 싶으면
//		response.setContentType("application/x-json, charset=utf-8");
//		PrintWriter writer = response.getWriter();
//		writer.print(result);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookDto> list = dao.getList();
		JSONArray array = new JSONArray();
		for (GuestbookDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("seq", dto.getSeq());
			object.put("title", dto.getTitle());
			object.put("writer", dto.getWriter());
			object.put("content", dto.getContent());
			object.put("wdate", dto.getWdate());
			object.put("hit", dto.getHit());
			
			array.add(object);
		}
		PrintWriter writer = response.getWriter();
		writer.print(array.toJSONString());
		
		//No suitable driver found for jdbc:oracle:thin:@127.0.0.1:1521:xe -> ojdbc.jar 없을 때 발생하는 에러
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
