package com.kosa.mvc1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class MemeberController
 */
@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
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
		System.out.println(cmd);
		if (cmd == null || cmd.equals("")) {
			cmd = "member_write";
		}
		if (cmd.equals("idcheck")) {
			doIdCheck(request, response);
		} else if (cmd.equals("member_write")) {
			doWrite(request, response);
		} else if (cmd.equals("member_save")) {
			doSave(request, response);
		} else if (cmd.equals("logon")) {
			// jsp로 이동만
			doLogon(request, response);
		} else if (cmd.equals("logon_proc")) {
			// 실제로 로그온 담당해서 세션에 저장하는 역할
			doLogonProc(request, response);
		} else if (cmd.equals("logout")) {
			doLogout(request, response);
		} else if (cmd.equals("findID")) {
			doFindID(request, response);
		} else if (cmd.equals("findIDPROC")) {
			doFindIDPROC(request, response);
		} else if (cmd.equals("findPW")) {
			doFindPW(request, response);
		} else if (cmd.equals("findPWPROC")) {
			doFindPWPROC(request, response);
		}
	}

	// http://localhost:9000/mvc1/member.do?cmd=idcheck&user_id=test
	public void doIdCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_id = request.getParameter("user_id");
		MemberDao dao = new MemberDao();

		response.setContentType("application/x-json, charset=utf-8");

		if (dao.isDuplicate(user_id)) {
			// =true: 이미 사용하는 사람이 있다.
			response.getWriter().print("{\"result\":\"fail\"}");
		} else {
			response.getWriter().print("{\"result\":\"success\"}");
		}
		;

	}

	public void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/member_write.jsp");
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

	public void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		dto.setUser_id(user_id);
		dto.setUser_name(user_name);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setPhone(phone);

		boolean result = dao.insert(dto);

		response.setContentType("application/x-json, charset=utf-8");

		if (result) {
			// =true: 이미 사용하는 사람이 있다.
			response.getWriter().print("{\"result\":\"success\"}");
		} else {
			response.getWriter().print("{\"result\":\"fail\"}");
		}
		;

	}

	public void doLogon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 이동만 -> member/logon.jsp
		String url = "/member/logon.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doLogonProc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.logon(user_id, password);
		JSONObject obj = new JSONObject();

		if (dto.getUser_id().equals("")) {
			// 로그온 실패
			obj.put("result", "fail");
		} else {
			// 로그온 성공 => 세션에 로그온 정보를 저장해야 한다.
			// 서블릿에서 세션객체는 request 객체를 통해 얻어야 한다.
			HttpSession session = request.getSession();
			session.setAttribute("user_id", dto.getUser_id());
			session.setAttribute("user_name", dto.getUser_name());
			session.setAttribute("email", dto.getEmail());
			obj.put("result", "success");
		}
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}

	@SuppressWarnings("unchecked")
	public void doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject obj = new JSONObject();
		HttpSession session = request.getSession();
		session.invalidate();
		obj.put("result", "success");
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}

	public void doFindID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/findID.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doFindIDPROC(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("email");

		MemberDao dao = new MemberDao();
		MemberDto dto = dao.findID(user_name, email);

		JSONObject obj = new JSONObject();

		if (dto.getUser_id().equals("")) {
			obj.put("result", "fail");
		} else {
			obj.put("result", "success");
			obj.put("user_id", dto.getUser_id());
		}

		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}

	public void doFindPW(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/findPW.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doFindPWPROC(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_id = request.getParameter("user_id");
		String email = request.getParameter("email");

		MemberDao dao = new MemberDao();
		String pw = dao.findPW(user_id, email);

		JSONObject obj = new JSONObject();

		if (pw.equals("")) {
			obj.put("result", "fail");
		} else {
			obj.put("result", "success");
			obj.put("password", pw);
		}
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj.toJSONString());
	}
}
