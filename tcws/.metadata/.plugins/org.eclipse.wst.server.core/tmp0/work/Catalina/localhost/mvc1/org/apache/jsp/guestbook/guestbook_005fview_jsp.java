/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-20 03:40:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.guestbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.kosa.mvc1.guestbook.*;

public final class guestbook_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/include/navbar.jsp", Long.valueOf(1674173647276L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kosa.mvc1.guestbook");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Guestbook View</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

String seq = request.getParameter("seq");

      out.write("\r\n");
      out.write("<form name=\"myform\">\r\n");
      out.write("<input type=\"hidden\" name=\"seq\" value=\"");
      out.print(seq);
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"cmd\">\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!-- 메뉴 -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- 한글 깨짐 방지 -->\r\n");

// 공통변수 CONTEXT 만들어 놓고 갖다 쓰기
String CONTEXT = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm navbar-light\" style=\"background-color: lavenderblush\">\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<a class=\"navbar-brand\" href=\"");
      out.print(CONTEXT);
      out.write("\"> <img\r\n");
      out.write("			src=\"");
      out.print(CONTEXT);
      out.write("/images/15.jpg\" alt=\"Avatar Logo\"\r\n");
      out.write("			style=\"width: 40px;\" class=\"rounded-pill\">\r\n");
      out.write("		</a>\r\n");
      out.write("\r\n");
      out.write("		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\r\n");
      out.write("			data-bs-target=\"#collapsibleNavbar\">\r\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("		</button>\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("			<ul class=\"navbar-nav\">\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("					href=\"");
      out.print(CONTEXT);
      out.write("/guestbook.do?cmd=list&pg=0\">List</a></li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("					href=\"");
      out.print(CONTEXT);
      out.write("/guestbook.do?cmd=write\">Write</a></li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("					href=\"");
      out.print(CONTEXT);
      out.write("/member.do?cmd=member_write\">Sign up</a></li>\r\n");
      out.write("				<li class=\"nav-item dropdown\"><a\r\n");
      out.write("					class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\"\r\n");
      out.write("					data-bs-toggle=\"dropdown\">Gallery</a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"");
      out.print(CONTEXT);
      out.write("/gallery.do?cmd=list\">Gallery list</a></li>\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"");
      out.print(CONTEXT);
      out.write("/gallery.do?cmd=write\">Gallery write</a></li>\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"#\">A third link</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		");
if(session.getAttribute("user_id")==null||session.getAttribute("user_id").equals("")) {
      out.write("\r\n");
      out.write("			<ul class=\"navbar-nav justify-content-end\">\r\n");
      out.write("				<li class=\"nav-item\">\r\n");
      out.write("				<a class=\"nav-link\" href=\"");
      out.print(CONTEXT);
      out.write("/member.do?cmd=logon\">로그인</a>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li class=\"nav-item\">\r\n");
      out.write("				<a class=\"nav-link\" href=\"");
      out.print(CONTEXT);
      out.write("/member.do?cmd=member_write\">회원가입</a>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		");
} else {
      out.write("\r\n");
      out.write("			<ul class=\"navbar-nav justify-content-end\">\r\n");
      out.write("				<li class=\"nav-item\">\r\n");
      out.write("				<a class=\"nav-link\" href=\"#none\">");
      out.print(session.getAttribute("user_name") );
      out.write("</a>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li class=\"nav-item\">\r\n");
      out.write("				<a class=\"nav-link\" href=\"#none\" onclick=\"goLogout()\">로그아웃</a>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function goLogout() {\r\n");
      out.write("	let xhttp = new XMLHttpRequest();\r\n");
      out.write("	let url = \"/mvc1/member.do?cmd=logout\";\r\n");
      out.write("	\r\n");
      out.write("	xhttp.onload=function(){\r\n");
      out.write("		console.log(this.responseText);\r\n");
      out.write("		let data = JSON.parse(this.responseText);\r\n");
      out.write("		alert(\"로그아웃 되었습니다.\");\r\n");
      out.write("		location.href=\"/mvc1\";\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	xhttp.open(\"GET\", url, true);\r\n");
      out.write("	xhttp.send();\r\n");
      out.write("}\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container mt-3\">\r\n");
      out.write("		<h3>방명록</h3>\r\n");
      out.write("		<p>This example adds a dropdown menu in the navbar.</p>\r\n");
      out.write("\r\n");
      out.write("		");

		GuestbookDto dto = (GuestbookDto) request.getAttribute("dto");
		
      out.write("\r\n");
      out.write("		<table class=\"table\">\r\n");
      out.write("			<colgroup>\r\n");
      out.write("				<col width=\"15%\">\r\n");
      out.write("				<col width=\"18%\">\r\n");
      out.write("				<col width=\"15%\">\r\n");
      out.write("				<col width=\"18%\">\r\n");
      out.write("				<col width=\"15%\">\r\n");
      out.write("				<col width=\"18%\">\r\n");
      out.write("			</colgroup>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>제목</th>\r\n");
      out.write("					<td colspan=\"5\">");
      out.print(dto.getTitle());
      out.write("</td>\r\n");
      out.write("					\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>작성자</th>\r\n");
      out.write("					<td>");
      out.print(dto.getUser_name());
      out.write("</td>\r\n");
      out.write("					<th>작성일</th>\r\n");
      out.write("					<td>");
      out.print(dto.getWdate());
      out.write("</td>\r\n");
      out.write("					<th>조회수</th>\r\n");
      out.write("					<td>");
      out.print(dto.getHit());
      out.write("</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>내용</th>\r\n");
      out.write("					<td colspan=\"5\" style=\"word-break: break-all;\">");
      out.print(dto.getContent().replaceAll("\r\n", "<br>"));
      out.write("</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container\" style=\"text-align: right\">\r\n");
      out.write("		<button type=\"button\" class=\"btn btn-primary\" id=\"btnList\">목록</button>&nbsp;&nbsp;\r\n");
      out.write("		");
if(dto.getWriter().equals(session.getAttribute("user_id"))){ 
      out.write("\r\n");
      out.write("		<!-- session을 앞에 쓰면, 로그인 안한 상태일 때 session 값이 null이 되기 때문에 equals를 이용해 writer 값과 비교하는 것이 불가능\r\n");
      out.write("			하지만 이미 writer은 항상 존재하고 있기 때문에 null일 가능성이 없으며, 존재하는 값과 null을 비교하는 것은 가능하기 때문에\r\n");
      out.write("			writer을 앞으로 빼야 함. -->\r\n");
      out.write("		<!-- 이렇게 코드를 작성하는 경우, 로그인이 안 되었을 때엔 script에서 modify, delete 버튼이 존재하지 않는 상태에서 event를 만들어놓은 것이\r\n");
      out.write("			되어 에러가 발생함. script에도 비슷한 처리를 해야 함. -->\r\n");
      out.write("		<button type=\"button\" class=\"btn btn-primary\" id=\"btnModify\">수정</button>&nbsp;&nbsp;\r\n");
      out.write("		<button type=\"button\" class=\"btn btn-primary\" id=\"btnDelete\">삭제</button>&nbsp;&nbsp;\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("window.onload=()=>{\r\n");
      out.write("	let frm = document.myform;\r\n");
      out.write("	\r\n");
      out.write("	let btnList = document.getElementById(\"btnList\");\r\n");
      out.write("	btnList.addEventListener(\"click\",()=>{\r\n");
      out.write("		frm.action = \"");
      out.print(CONTEXT);
      out.write("/guestbook.do\";\r\n");
      out.write("		frm.cmd.value=\"list\";\r\n");
      out.write("		frm.submit();\r\n");
      out.write("	})\r\n");
      out.write("	\r\n");
      out.write("	");
if(dto.getWriter().equals(session.getAttribute("user_id"))){ 
      out.write("\r\n");
      out.write("	let btnModify = document.getElementById(\"btnModify\");\r\n");
      out.write("	btnModify.addEventListener(\"click\",()=>{\r\n");
      out.write("	frm.action=\"");
      out.print(CONTEXT);
      out.write("/guestbook.do\";\r\n");
      out.write("	frm.cmd.value=\"modify\";\r\n");
      out.write("	frm.submit();		\r\n");
      out.write("	})\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	let btnDelete = document.getElementById(\"btnDelete\");\r\n");
      out.write("	btnDelete.addEventListener(\"click\",()=>{\r\n");
      out.write("		if(confirm(\"삭제하시겠습니까?\")){			\r\n");
      out.write("		frm.action = \"");
      out.print(CONTEXT);
      out.write("/guestbook.do\";\r\n");
      out.write("		frm.cmd.value=\"delete\";\r\n");
      out.write("		frm.submit();\r\n");
      out.write("		}\r\n");
      out.write("	})\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
