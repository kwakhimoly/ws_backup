/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-02-14 06:54:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import com.kosa.myapp3.comment.mine.*;
import com.kosa.myapp3.common.*;
import com.kosa.myapp3.board.*;

public final class board_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/board/../include/navbar.jsp", Long.valueOf(1675829143388L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("com.kosa.myapp3.comment.mine");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kosa.myapp3.common");
    _jspx_imports_packages.add("com.kosa.myapp3.board");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.ArrayList");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>   \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"myform\" name=\"myform\">\r\n");
      out.write("<!-- ?????? -->\r\n");
      out.write("\r\n");
      out.write("<!-- ?????? -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- ?????? ?????? ?????? -->\r\n");

// ???????????? CONTEXT ????????? ?????? ?????? ??????
String CONTEXT = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm navbar-light\" style=\"background-color: lavender\">\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<a class=\"navbar-brand\" href=\"");
      out.print(CONTEXT);
      out.write("\"> <img\r\n");
      out.write("			src=\"https://imjustcreative.com/wp-content/uploads/2015/11/Screenshot-2019-11-23-17.32.44.jpg\" alt=\"Avatar Logo\"\r\n");
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
      out.write("/board/list?pg=0\">List</a></li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("					href=\"");
      out.print(CONTEXT);
      out.write("/board/write\">Write</a></li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("					href=\"");
      out.print(CONTEXT);
      out.write("/member/write\">Sign up</a></li>\r\n");
      out.write("				<li class=\"nav-item dropdown\"><a\r\n");
      out.write("					class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\"\r\n");
      out.write("					data-bs-toggle=\"dropdown\">Gallery</a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"");
      out.print(CONTEXT);
      out.write("/gallery/list\">Gallery list</a></li>\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"");
      out.print(CONTEXT);
      out.write("/gallery/write\">Gallery write</a></li>\r\n");
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
      out.write("/member/login\">?????????</a>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li class=\"nav-item\">\r\n");
      out.write("				<a class=\"nav-link\" href=\"");
      out.print(CONTEXT);
      out.write("/member/write\">????????????</a>\r\n");
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
      out.write("				<a class=\"nav-link\" href=\"#none\" onclick=\"goLogout()\">????????????</a>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function goLogout() {\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url:\"");
      out.print(request.getContextPath());
      out.write("/member/logout\",\r\n");
      out.write("		method:\"POST\",\r\n");
      out.write("		dataType:\"JSON\"\r\n");
      out.write("	})\r\n");
      out.write("	.done(function (response){\r\n");
      out.write("		alert(response.message);\r\n");
      out.write("		if(response.result==\"success\"){\r\n");
      out.write("			location.href=\"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("		}\r\n");
      out.write("	})\r\n");
      out.write("	.fail((response, status, error)=>{\r\n");
      out.write("		console.log(error);\r\n");
      out.write("	});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");

	String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	String seq = StringUtil.nullToValue(request.getParameter("seq"), "");
	BoardDto dto = (BoardDto)request.getAttribute("dto");
	List<CommentDto> list = (List<CommentDto>)request.getAttribute("commentList");
	for(int i =0; i<list.size(); i++){
		CommentDto a = list.get(i);
		System.out.println(a.getSeq());
		System.out.println(a.getBoard_seq());
	}

      out.write("\r\n");
      out.write("	<input type=\"hidden\" id=\"pg\" name=\"pg\" value=\"");
      out.print(pg);
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"seq\" name=\"seq\" value=\"");
      out.print(seq);
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"userid\" name=\"userid\" value=\"user02\">\r\n");
      out.write("	<input type=\"hidden\" id=\"board_seq\" name=\"board_seq\" value=\"");
      out.print(seq);
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"group_id\" name=\"group_id\" value=\"");
      out.print(dto.getGroup_id());
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"depth\" name=\"depth\" value=\"");
      out.print(dto.getDepth());
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"g_level\" name=\"g_level\" value=\"");
      out.print(dto.getG_level());
      out.write("\">\r\n");
      out.write("	\r\n");
      out.write("	<!-- view?????? mode??? ???????????? ?????? ???????????? ???(????????? value ??? ???????????? ???. ?????? ????????? ??????. ????????? ????????????..) -->\r\n");
      out.write("	<input type=\"hidden\" id=\"mode\" name=\"mode\">\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container mt-3\">\r\n");
      out.write("	  <h3>");
      out.print(dto.getTitle() );
      out.write("</h3>\r\n");
      out.write("	  <p>");
      out.print(dto.getContents().split("\n")[0] );
      out.write("</p>\r\n");
      out.write("	  <!-- contents??? ????????? ??????(\\n?????? split, split ????????? 0??????(=????????? ???)) ???????????? -->\r\n");
      out.write("	  \r\n");
      out.write("	\r\n");
      out.write("	   <table class=\"table\">\r\n");
      out.write("	   	<colgroup>\r\n");
      out.write("	   		<col width=\"8%\">\r\n");
      out.write("			<col width=\"*\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("			<col width=\"12%\">\r\n");
      out.write("	   	</colgroup>\r\n");
      out.write("	   	\r\n");
      out.write("	    <tbody>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	        <th>??????</th>\r\n");
      out.write("	        <td colspan=\"9\">");
      out.print(dto.getTitle() );
      out.write("</td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	        <th>?????????</th>\r\n");
      out.write("	        <td>");
      out.print(dto.getUserid() );
      out.write("</td>\r\n");
      out.write("	        <th>?????????</th>\r\n");
      out.write("	        <td>");
      out.print(dto.getRegdate() );
      out.write("</td>\r\n");
      out.write("	        <th>?????????</th>\r\n");
      out.write("	        <td>");
      out.print(dto.getModdate() );
      out.write("</td>\r\n");
      out.write("	        <th>?????????</th>\r\n");
      out.write("	        <td>");
      out.print(dto.getHit() );
      out.write("</td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	        <th>??????</th>\r\n");
      out.write("	        <td colspan=\"9\" style=\"text-align: center;\">");
      out.print(dto.getContents().replaceAll("\n", "<br>") );
      out.write("</td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	      	<th>????????????1</th>\r\n");
      out.write("	      	<td colspan=\"9\">\r\n");
      out.write("		      	");
if(dto.getFilename1().contains("jpg")||dto.getFilename1().contains("gif")) {
		      	
      out.write("\r\n");
      out.write("		      		<a href=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename1());
      out.write("\">\r\n");
      out.write("		      		<img alt=\"file1\" src=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename1());
      out.write("\" \r\n");
      out.write("		      		width=\"15%\"></a><br>\r\n");
      out.write("		      	");
} 
      out.write("\r\n");
      out.write("	      	<a href=\"");
      out.print(request.getContextPath() );
      out.write("/down?path=board&filename=");
      out.print(dto.getFilename1() );
      out.write("\" \r\n");
      out.write("	      	class=\"btn\">");
      out.print(dto.getFilename1() );
      out.write("</a></td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	      <th>????????????2</th>\r\n");
      out.write("	      	<td colspan=\"9\">\r\n");
      out.write("		      	");
if(dto.getFilename2().contains("jpg")||dto.getFilename2().contains("gif")) {
		      	
      out.write("\r\n");
      out.write("		      		<a href=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename2());
      out.write("\">\r\n");
      out.write("		      		<img alt=\"file2\" src=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename2());
      out.write("\"\r\n");
      out.write("		      		 width=\"15%\"></a><br>\r\n");
      out.write("		      	");
} 
      out.write("\r\n");
      out.write("	      	<a href=\"");
      out.print(request.getContextPath() );
      out.write("/down?path=board&filename=");
      out.print(dto.getFilename2() );
      out.write("\" \r\n");
      out.write("	      	class=\"btn\">");
      out.print(dto.getFilename2() );
      out.write("</a></td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <tr>\r\n");
      out.write("	      <th>????????????3</th>\r\n");
      out.write("	      	<td colspan=\"9\">\r\n");
      out.write("	      		");
if(dto.getFilename3().contains("jpg")||dto.getFilename3().contains("gif")) {
	      		
      out.write("\r\n");
      out.write("	      			<a href=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename3());
      out.write("\">\r\n");
      out.write("	      			<img alt=\"file3\" src=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print(dto.getFilename3());
      out.write("\" \r\n");
      out.write("	      			width=\"15%\"></a><br>\r\n");
      out.write("	      		");
} 
      out.write("\r\n");
      out.write("	      	<a href=\"");
      out.print(request.getContextPath() );
      out.write("/down?path=board&filename=");
      out.print(dto.getFilename3() );
      out.write("\" \r\n");
      out.write("	      	class=\"btn\">");
      out.print(dto.getFilename3() );
      out.write("</a></td>\r\n");
      out.write("	      </tr>\r\n");
      out.write("	      <!-- ????????? url(/upload)??? ???????????? ????????? servlet-context.xml??? \r\n");
      out.write("	      <resources mapping=\"/upload/**\" location=\"/upload/\" /> ???????????? /upload?????? ????????? ??? ????????? ??????????????? ???\r\n");
      out.write("	       -->\r\n");
      out.write("	    </tbody>\r\n");
      out.write("	  </table>\r\n");
      out.write("	 </div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	 <div class=\"container\" style=\"text-align:right\">\r\n");
      out.write("		<button type=\"button\" class=\"btn\" style=\"background-color: lavender\" id=\"btnReply\">??????</button>\r\n");
      out.write("		<button type=\"button\" class=\"btn\" style=\"background-color: lavender\" id=\"btnModify\">??????</button>\r\n");
      out.write("		<button type=\"button\" class=\"btn\" style=\"background-color: lavender\" id=\"btnDelete\" >??????</button>\r\n");
      out.write("		<button type=\"button\" class=\"btn\" style=\"background-color: lavender\" id=\"btnList\">??????</button>\r\n");
      out.write("	 <hr style=\"color: lavender; border : 0px; border-top: 5px dotted #663399;\">\r\n");
      out.write("	 </div>\r\n");
      out.write("	 ");
if(session.getAttribute("user_id")!=null){ 
      out.write("\r\n");
      out.write("<!-- ?????? -->\r\n");
      out.write("	<div class=\"container mt-3\">	\r\n");
      out.write("		<!-- ?????? ????????? -->\r\n");
      out.write("	<table class=\"table\">\r\n");
      out.write("    	<tbody>\r\n");
      out.write("      	<tr>\r\n");
      out.write("        	<td style=\"width:80%\">\r\n");
      out.write("        		 <div class=\"input-group\">\r\n");
      out.write("			   		 <textarea name=\"content_comment\" id=\"content_comment\" class=\"form-control\" rows=\"4\"></textarea>\r\n");
      out.write("			 	</div>\r\n");
      out.write("       		</td>\r\n");
      out.write("       		<td style=\"width:20%\">\r\n");
      out.write("        		<button type=\"button\" id=\"btnComment\" class=\"btn\" style=\"background-color: lavender\">??????</button>\r\n");
      out.write("        	</td>\r\n");
      out.write("  	    </tr>\r\n");
      out.write(" 		</tbody>\r\n");
      out.write("	</table>\r\n");
      out.write("		<!-- ?????? ????????? -->\r\n");
      out.write("	 <table class=\"table\" id=\"commentTable\" style=\"text-align: center;\">\r\n");
      out.write("	 <colgroup>\r\n");
      out.write("	 	<col width=\"25%\">\r\n");
      out.write("	 	<col width=\"50%\">\r\n");
      out.write("	 	<col width=\"25%\">\r\n");
      out.write("	 </colgroup>\r\n");
      out.write("	   <tbody>\r\n");
      out.write("	  ");
      out.write("\r\n");
      out.write("	 	</tbody>\r\n");
      out.write("	 </table>		\r\n");
      out.write("	</div>\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("</form>  \r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(()=>{\r\n");
      out.write("\r\n");
      out.write("	$(\"#btnReply\").click(()=>{\r\n");
      out.write("		$(\"#mode\").val(\"reply\");\r\n");
      out.write("		$(\"#myform\").prop(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/board/reply\");\r\n");
      out.write("		$(\"#myform\").submit();\r\n");
      out.write("	});\r\n");
      out.write("	$(\"#btnModify\").click(()=>{\r\n");
      out.write("		$(\"#mode\").val(\"modify\");\r\n");
      out.write("		$(\"#myform\").prop(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/board/modify\");\r\n");
      out.write("		$(\"#myform\").submit();\r\n");
      out.write("	});\r\n");
      out.write("	$(\"#btnList\").click(()=>{\r\n");
      out.write("		$(\"#myform\").prop(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/board/list\");\r\n");
      out.write("		$(\"#myform\").submit();\r\n");
      out.write("	});\r\n");
      out.write("	$(\"#btnDelete\").click(()=>{\r\n");
      out.write("//		?????????\r\n");
      out.write("		let param = $(\"#myform\").serialize();\r\n");
      out.write("//		????????? : multipart ?????? ???\r\n");
      out.write("//		FormData : multipart ??? ???\r\n");
      out.write("//		seq=4&group_id=3 ...\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: \"");
      out.print(request.getContextPath());
      out.write("/board/board_delete\",\r\n");
      out.write("			data: param,\r\n");
      out.write("			dataType: \"JSON\"\r\n");
      out.write("		})\r\n");
      out.write("		.done((res)=>{\r\n");
      out.write("			if(res.result==\"success\"){\r\n");
      out.write("				alert(res.message);\r\n");
      out.write("				location.href=\"");
      out.print(request.getContextPath());
      out.write("/board/list\";\r\n");
      out.write("			} else{\r\n");
      out.write("				alert(\"??????????????????.\");\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("		.fail((res, status, error)=>{\r\n");
      out.write("			console.log(status);\r\n");
      out.write("			console.log(error);\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"#btnComment\").click(()=>{\r\n");
      out.write("		\r\n");
      out.write("		let param = $(\"#myform\").serialize(); \r\n");
      out.write("		console.log(param);\r\n");
      out.write("		\r\n");
      out.write("		//?????? ??????????????? ???????????????????????? JQuery\r\n");
      out.write("		//Serialize()??? ????????????????????? ????????? Jquery??? ????????????.\r\n");
      out.write("		//board_seq=12&content_comment=??????&userid=test : ???????????? ??????\r\n");
      out.write("		//=> ?????? ????????? ?????? ????????? userid hidden ????????? ???????????? ???.\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url:\"");
      out.print(request.getContextPath());
      out.write("/comment/write\",\r\n");
      out.write("//			data:{board_seq:$(\"#board_seq\").val(), content_comment:$(\"#content_comment\").val(), userid:\"test01\"}, \r\n");
      out.write("			data:param,\r\n");
      out.write("			dataType:\"JSON\"\r\n");
      out.write("		})\r\n");
      out.write("		.done((res)=>{\r\n");
      out.write("			alert(res.message);\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("			/* commentList??? ?????? ?????? ?????? */\r\n");
      out.write("			loadData();\r\n");
      out.write("			\r\n");
      out.write("		})\r\n");
      out.write("		.fail((res,status,error)=>{\r\n");
      out.write("			console.log(status);\r\n");
      out.write("			console.log(error);\r\n");
      out.write("		});\r\n");
      out.write("	})\r\n");
      out.write("	\r\n");
      out.write("			loadData();\r\n");
      out.write("})\r\n");
      out.write("//	comment??? ???????????? table??? ????????????\r\n");
      out.write("	function loadData(){\r\n");
      out.write("	let board_seq = $(\"#board_seq\").val();\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url:\"");
      out.print(request.getContextPath());
      out.write("/comment/list\",\r\n");
      out.write("		data:{board_seq:board_seq},\r\n");
      out.write("		dataType:\"JSON\"\r\n");
      out.write("	})\r\n");
      out.write("	.done((res)=>{\r\n");
      out.write("		console.log(res);\r\n");
      out.write("		data = res.data;\r\n");
      out.write("		console.log( data );\r\n");
      out.write("		\r\n");
      out.write("		//????????? ?????? ????????? ?????? \r\n");
      out.write("		for(i=$(\"#commentTable > tbody > tr\").length; i>-1; i--)\r\n");
      out.write("		{\r\n");
      out.write("			$(\"#commentTable > tbody > tr:last\").remove(); //??? ????????? ???????????? ???????????? \r\n");
      out.write("			//append??? tr??? ???????????? tr??? ????????? ????????? ?????? ????\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		data.forEach((item)=>{\r\n");
      out.write("			$(\"#commentTable > tbody \").append(\"<tr><td>\"+ item.userid + \"</td><td>\"+ item.content_comment + \"</td><td>\"+ item.regdate + \"</td></tr>\");\r\n");
      out.write("		});\r\n");
      out.write("			\r\n");
      out.write("	})\r\n");
      out.write("	.fail((res,status,error)=>{\r\n");
      out.write("		console.log(status);\r\n");
      out.write("		console.log(error);\r\n");
      out.write("	});\r\n");
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
