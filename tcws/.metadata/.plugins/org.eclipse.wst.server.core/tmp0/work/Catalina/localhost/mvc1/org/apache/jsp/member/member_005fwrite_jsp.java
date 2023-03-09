/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-19 06:49:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class member_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/include/navbar.jsp", Long.valueOf(1674107449466L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Memeber Write</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"myform\">\r\n");
      out.write("<input type=\"hidden\" name=\"idcheck\" id=\"idcheck\" value=\"N\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 메뉴 -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- 한글 깨짐 방지 -->\r\n");

// 공통변수 CONTEXT 만들어 놓고 갖다 쓰기
String CONTEXT = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n");
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
      out.write("\r\n");
      out.write("<div class=\"container mt-3\">\r\n");
      out.write("  <h3>sign up</h3>\r\n");
      out.write("  <p>회원가입</p>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("   <table class=\"table\">\r\n");
      out.write("   	<colgroup>\r\n");
      out.write("   		<col width=\"30%\">\r\n");
      out.write("   		<col width=\"*\">\r\n");
      out.write("   	</colgroup>\r\n");
      out.write("    <tbody>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>아이디</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"text\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"아이디를 입력하세요\"\r\n");
      out.write("			    name=\"user_id\" id=\"user_id\">\r\n");
      out.write("			    <a href=\"#none\" onclick=\"goIDCheck()\"><span class=\"input-group-text\" >아이디중복체크</span></a>\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>패스워드</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"password\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"패스워드를 입력하세요\"\r\n");
      out.write("			    name=\"password\" id=\"password\">\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>패스워드확인</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"password\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"패스워드를 입력하세요\"\r\n");
      out.write("			    name=\"password2\" id=\"password2\">\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>이름</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"text\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"이름을 입력하세요\"\r\n");
      out.write("			    name=\"user_name\" id=\"user_name\">\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>이메일</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"email\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"이메일을 입력하세요\"\r\n");
      out.write("			    name=\"email\" id=\"email\">\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>전화번호</th>\r\n");
      out.write("        <td>\r\n");
      out.write("        	 <div class=\"input-group\">\r\n");
      out.write("			    <input type=\"tel\" class=\"form-control\" \r\n");
      out.write("			    placeholder=\"전화번호를 입력하세요\"\r\n");
      out.write("			    name=\"phone\" id=\"phone\">\r\n");
      out.write("			 </div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("  </table>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div class=\"container\" style=\"text-align:right\">\r\n");
      out.write("	<button type=\"button\" class=\"btn btn-primary\" onclick=\"goSave()\">등록</button>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("  </form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("function goIDCheck() {\r\n");
      out.write("	let user_id = document.getElementById(\"user_id\").value;\r\n");
      out.write("//	체이닝 기술: 객체().함수호출().함수호출().... => $.ajax().done().fail();\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url:\"");
      out.print(CONTEXT);
      out.write("/member.do\",\r\n");
      out.write("		data:{cmd:\"idcheck\",user_id:user_id},\r\n");
      out.write("		dataType:\"JSON\",\r\n");
      out.write("		method:\"POST\"\r\n");
      out.write("	})\r\n");
      out.write("	.done((response)=>{\r\n");
      out.write("		//응답을 받아서 처리해야 한다.\r\n");
      out.write("		//응답이 dataType: \"JSON\"으로 보내면 JSON 객체를 전달 받는다. 자동 parsing을 한다.\r\n");
      out.write("		console.log(response);\r\n");
      out.write("	if(response.result==\"success\"){\r\n");
      out.write("		alert(\"사용가능한 아이디입니다.\");\r\n");
      out.write("		$(\"#idcheck\").val(\"Y\");\r\n");
      out.write("		$(\"#user_id\").prop(\"disabled\", true);\r\n");
      out.write("	} else{\r\n");
      out.write("		alert(\"이미 사용 중인 아이디입니다.\");\r\n");
      out.write("	}\r\n");
      out.write("	}) //괄호 안에 통신이 성공적으로 이루어졌을 때의 처리할 함수를 전달한다.\r\n");
      out.write("	.fail((request, status, error)=>{\r\n");
      out.write("		console.log(request);\r\n");
      out.write("		console.log(status);\r\n");
      out.write("		console.log(error);\r\n");
      out.write("	}); //괄호 안에 통신이 문제가 생겼을 경우에 처리할 함수를 전달한다.\r\n");
      out.write("	//ajax는 기본이 비동기 처리라서 반환값을 사용할 수 없다. \r\n");
      out.write("	//일을 수행하고 난 뒤에 성공시 done에 전달된 함수를 호출하고 실패시 fail에 전달된 함수를 실행한다.\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function goSave() {\r\n");
      out.write("	\r\n");
      out.write("	if($(\"#idcheck\").val()!=\"Y\"){\r\n");
      out.write("		alert(\"아이디 중복체크를 하세요\");\r\n");
      out.write("		$(\"#user_id\").focus();\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	let user_id = $(\"#user_id\").val();\r\n");
      out.write("	let password = $(\"#password\").val();\r\n");
      out.write("	let email = $(\"#email\").val();\r\n");
      out.write("	let user_name = $(\"#user_name\").val();\r\n");
      out.write("	let phone = $(\"#phone\").val();\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("			url:\"");
      out.print(CONTEXT );
      out.write("/member.do\",\r\n");
      out.write("			data:{cmd:\"member_save\", user_id:user_id, email:email, password:password, user_name:user_name, phone:phone},\r\n");
      out.write("			dataType:\"JSON\",\r\n");
      out.write("			method:\"POST\"\r\n");
      out.write("		})\r\n");
      out.write("	.done(\r\n");
      out.write("			(response)=>{\r\n");
      out.write("				if(response.result==\"success\"){\r\n");
      out.write("					alert(\"회원가입이 완료되었습니다.\");\r\n");
      out.write("					location.href=\"");
      out.print(CONTEXT);
      out.write("/index.jsp\";\r\n");
      out.write("				} else{\r\n");
      out.write("					alert(\"회원가입에 실패하셨습니다.\");\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("			)\r\n");
      out.write("	.fail(\r\n");
      out.write("			(response, status, error)=>{\r\n");
      out.write("				console.log(response);\r\n");
      out.write("				console.log(status);\r\n");
      out.write("				console.log(error);\r\n");
      out.write("			}\r\n");
      out.write("			);\r\n");
      out.write("	\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
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