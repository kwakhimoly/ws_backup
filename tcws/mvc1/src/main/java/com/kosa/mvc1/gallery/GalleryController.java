package com.kosa.mvc1.gallery;

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
 * Servlet implementation class GalleryController
 */
@WebServlet("/gallery.do")
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GalleryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	MultipartRequest multi = null; // 멤버변수로 선언 -> doSave에서 써야 함

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 문제 처리하기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 서블릿 최근 버전
		ServletContext ctx = request.getServletContext();
		String savePath = ctx.getRealPath("/upload/gallery"); // 파일 경로
		// 상대적 경로 -> 실제 경로를 알려준다.
		// DefaultFileRenamePolicy - 파일명이 중복될 때 어떻게 처리할 지를 선택한다. 파일명을 마음대로 바꾼다.
		int sizeLimit = 1024 * 1024 * 20; // 파일 크기는 최대 20mb까지만
		/*
		 * 사진 저장 위치 :
		 * C:\kwak\tcws\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\
		 * mvc1\\upload\gallery
		 */

		System.out.println("method:" + request.getMethod());
		System.out.println("content type:" + request.getContentType());
		/*
		 * get method : GET content type: null write
		 * 
		 * 글쓰기 저장 method:POST content type:multipart/form-data;
		 * boundary=----WebKitFormBoundaryi3b2rK8dyA98AF0y null
		 */
		String cmd = "";
		String contentType = request.getContentType();
		// 파일인지 일반 텍스트인지 json인지 등등 어떤 타입의 정보인지 서버에게 정보를 보내줌

		if (contentType == null || !contentType.startsWith("multipart")) {
			cmd = request.getParameter("cmd");
			if (cmd == null || cmd.equals("")) {
				cmd = "list";
			}
		} else /* POST 일 때 */ {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			cmd = multi.getParameter("cmd");
		}

		System.out.println("***" + cmd);
		// enctype을 보내면 request가 값을 못 받음 -> multi 통해서 값 받아오기

		if (cmd.equals("list")) {
			doList(request, response);
		} else if (cmd.equals("write")) {
			doWrite(request, response);
		} else if (cmd.equals("save")) {
			doSave(request, response);
		} else if (cmd.equals("save2")) {
			doSave2(request, response);
		} else if (cmd.equals("view")) {
			doView(request, response);
		}
	}

	public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GalleryDto dto = new GalleryDto();
		GalleryDao dao = new GalleryDao();

		String pg = request.getParameter("pg");
		// 파라미터 값 읽어와서
		if (pg == null || pg.equals("")) { // null이거나 공백일 경우 0으로 지정
			pg = "0";
		}

		dto.setPg(Integer.parseInt(pg)); // request.getParameter는 반환값이 String => 정수로 전환하여 dto 객체에 전달.

		request.setAttribute("totalCnt", dao.getTotal(dto));
		request.setAttribute("list", dao.getList(dto));

		RequestDispatcher rd = request.getRequestDispatcher("/gallery/gallery_list.jsp");
		rd.forward(request, response);
	}

	public void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/gallery/gallery_write.jsp");
		rd.forward(request, response);
	}

	public void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 해야 한다.
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");

		String filename = multi.getFilesystemName("image");
		String originalFilename = multi.getOriginalFileName("image");

		System.out.println(filename);
		System.out.println(originalFilename);

		GalleryDto dto = new GalleryDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setImage(filename);

		GalleryDao dao = new GalleryDao();
		dao.insert(dto);

		String url = request.getContextPath() + "/gallery.do?cmd=list";
		response.sendRedirect(url);
	}

	@SuppressWarnings("unchecked")
	public void doSave2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");

		String filename = multi.getFilesystemName("image");
		String originalFilename = multi.getOriginalFileName("image");

		System.out.println(filename);
		System.out.println(originalFilename);

		GalleryDto dto = new GalleryDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setImage(filename);

		GalleryDao dao = new GalleryDao();
		dao.insert(dto);

		JSONObject obj = new JSONObject(); // => JSON으로 전송하기 위한 전용 객체를 생성
		obj.put("result", "success"); // => 키와 값 쌍의 형태로 저장

//		=> 서버에서 클라이언트로 응답을 보낼 때 html, text, json 등ㅇ으로 보낼 수 있다.
//			보통 아무말 없으면 text로 받고, <html> 태그가 있으면 html로 받고, json이나 이미지,동영상 등 지정할 수 있는 타입이 아주 많다. 
//			application/x-json -> json으로 타입을 지정한 것.		
		
		
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}

	public void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GalleryDao dao = new GalleryDao();
		String seq = request.getParameter("seq");
		request.setAttribute("dto", dao.getView(seq));

		String url = "/gallery/gallery_view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
