package com.kosa.mvc1.guestbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestbookController
 */
@WebServlet("/guestbook.do")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String cmd = request.getParameter("cmd");

//		System.out.println(cmd);

		if (cmd == null || cmd.equals("")) {
			cmd = "list"; // 아무 값도 없을 때 기본 값 부여
		}

		if (cmd.equals("list")) {
			doList(request, response);
		} else if (cmd.equals("view")) {
			doView(request, response);
		} else if (cmd.equals("write")) {
			doWrite(request, response);
		} else if (cmd.equals("save")) {
			doSave(request, response);
		} else if (cmd.equals("modify")) {
			doModify(request, response);
		} else if (cmd.equals("update")) {
			doUpdate(request, response);
		} else if (cmd.equals("delete")) {
			doDelete(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		// 없으면 post가 get을 못 받아옴...? 하여튼 건들면 망함... 난 안 건들였는데...
	}

	public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cmd에 여러 값이 들어올 거기 때문에 List 함수 따로 만들기
		GuestbookDto dto = new GuestbookDto();
		GuestbookDao dao = new GuestbookDao();
		
		String pg = request.getParameter("pg");
		String searchOpt = request.getParameter("searchOpt");
		String searchKey = request.getParameter("searchKey");
		if(pg==null||pg.equals("")) {
			//pg 값을 전달받지 못한 경우에 0으로 한다.
			pg="0";
		}
		if(searchOpt==null) {
			searchOpt="";
		}
		if(searchKey==null) {
			searchKey="";
		}
		
		
		dto.setPg(Integer.parseInt(pg)); //String -> int로 바꿔서 저장
		dto.setSearchOpt(searchOpt);
		dto.setSearchKeyword(searchKey);
		
		request.setAttribute("totalCnt", dao.getTotal(dto));
		request.setAttribute("list", dao.getList(dto));

		String url = "/guestbook/guestbook_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GuestbookDao dao = new GuestbookDao();
		String seq = request.getParameter("seq");
		request.setAttribute("dto", dao.getView(seq));

		// jsp로 이동하기
		String url = "/guestbook/guestbook_view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/guestbook/guestbook_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		// 데이터를 가져와서
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println("title : " + title);

		GuestbookDto dto = new GuestbookDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);

		dao.insert(dto); // insert 함수 만들러 가야 함

		String url = request.getContextPath() + "/guestbook.do?cmd=list";
//		forwarding을 사용하지 못한다. 디비에서 데이터 읽어와서 jsp로 넘기는 이중작업을 해야 한다. 그리고 request 객체에 전달받은 데이터(캐시)를 날려버려야 한다. -> 그래야 한 번만 저장함

		response.sendRedirect(url); // 절대 forward로 넘기면 안됨. sendRedirect를 써야 한다.
	}

	public void doModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		String seq = request.getParameter("seq");
		request.setAttribute("dto", dao.getView(seq));

		String url = "/guestbook/guestbook_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		GuestbookDto dto = new GuestbookDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setSeq(seq);

		dao.update(dto);

		String url = request.getContextPath() + "/guestbook.do?cmd=list";

		response.sendRedirect(url);
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GuestbookDao dao = new GuestbookDao();
		String seq = request.getParameter("seq");
		System.out.println(seq);
		dao.delete(seq);

		String url = request.getContextPath() + "/guestbook.do?cmd=list";
		response.sendRedirect(url);
	}
}
