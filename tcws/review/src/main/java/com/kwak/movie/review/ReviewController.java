package com.kwak.movie.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/movie.do")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MultipartRequest multi = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext ctx = request.getServletContext();
		String savePath = ctx.getRealPath("/upload/poster");
		int sizeLimit = 3000 * 3000 * 20;
		
		String cmd = "";
		String contentType = request.getContentType();
		
		if (contentType == null || !contentType.startsWith("multipart")) {
			cmd = request.getParameter("cmd");
			if (cmd == null || cmd.equals("")) {
				cmd = "list";
			}
		} else {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			cmd = multi.getParameter("cmd");
		}
		System.out.println(cmd);
		
		if(cmd.equals("write")) {
			doWrite(request, response);
		} else if(cmd.equals("save")) {
			doSave(request, response);
		} else if(cmd.equals("list")) {
			doList(request, response);
		} else if(cmd.equals("view")) {
			doView(request, response);
		} else if(cmd.equals("delete")) {
			deleteReview(request, response);
		}
	}
	
	public void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/mreview/review_write.jsp");
		rd.forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String m_password = multi.getParameter("m_password");
		String m_title = multi.getParameter("m_title");
		String m_writer = multi.getParameter("m_writer");
		String m_director = multi.getParameter("m_director");
		String m_actor = multi.getParameter("m_actor");
		String m_rate = multi.getParameter("m_rate");
		String m_review = multi.getParameter("m_review");
		String m_date = multi.getParameter("m_date");
		String filename = multi.getFilesystemName("m_poster");
		
		ReviewDto dto = new ReviewDto();
		dto.setM_password(m_password);
		dto.setM_title(m_title);
		dto.setM_writer(m_writer);
		dto.setM_director(m_director);
		dto.setM_actor(m_actor);
		dto.setM_rate(m_rate);
		dto.setM_review(m_review);
		dto.setM_date(m_date);
		dto.setM_poster(filename);
		
		ReviewDao dao = new ReviewDao();
		dao.insert(dto);
		
		JSONObject obj = new JSONObject(); // => JSON으로 전송하기 위한 전용 객체를 생성
		obj.put("result", "success");

		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}
	
	public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDao dao = new ReviewDao();
		ReviewDto dto = new ReviewDto();
		
		
		String pg = request.getParameter("pg");
		String searchOpt = request.getParameter("searchOpt");
		String searchKey = request.getParameter("searchKey");
		if (pg == null || pg.equals("")) { 
			pg = "0";
		}if(searchOpt==null) {
			searchOpt="0";
		}
		if(searchKey==null) {
			searchKey="";
		}
		
		dto.setPg(Integer.parseInt(pg));
		dto.setSearchOpt(searchOpt);
		dto.setSearchKeyword(searchKey);
		dao.getList(dto);
		request.setAttribute("totalCnt", dao.getTotal(dto));
		request.setAttribute("list", dao.getList(dto));

		RequestDispatcher rd = request.getRequestDispatcher("/mreview/review_list.jsp");
		rd.forward(request, response);
	}
	
	public void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDao dao = new ReviewDao();
		String seq = request.getParameter("seq");
		
		request.setAttribute("dto", dao.getView(seq));
		
		RequestDispatcher rd = request.getRequestDispatcher("/mreview/review_view.jsp");
		rd.forward(request, response);
	}
	
	public void deleteReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ReviewDao dao = new ReviewDao();
		String url = request.getContextPath() + "/movie.do?cmd=list";
		
		String seq = request.getParameter("seq");
		ReviewDto dto = dao.getView(seq);
		String pwd = request.getParameter("m_password");
		System.out.println(seq);
		if(pwd.equals(dto.getM_password())) {
		dao.delete(seq);
		response.sendRedirect(url);
		} else {
			response.sendRedirect(url);
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
