package com.kosa.myapp3.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//	HandlerInterceptorAdapter 를 꼭 상속 받아야 함.
//		board/write -> LoginInterceptor의 pre-Handler를 들렀다 감(스프링 기본 원칙)
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		System.out.println("****** 모두 여길 거쳐간다 ******");

		List<String> excludeCheckList = new ArrayList<String>();
		excludeCheckList.add("/member/login");
		excludeCheckList.add("/member/login_proc");
		excludeCheckList.add("/member/write");
		excludeCheckList.add("/member/idcheck");
		excludeCheckList.add("/member/save");
		excludeCheckList.add("/board/list");
		excludeCheckList.add("/comment/list");
		excludeCheckList.add("/board/view");
		excludeCheckList.add("/");

		String email = (String) session.getAttribute("email");
		String currentUrl = request.getRequestURI();
		System.out.println(currentUrl);

//		로그인 안 한 경우:
		if (email == null || email.equals("")) {

//			/myapp3/member/login
			currentUrl = currentUrl.substring(request.getContextPath().length());
			System.out.println(currentUrl);

			if (excludeCheckList.indexOf(currentUrl) == -1) {
				String url = request.getContextPath() + "/member/login";
				response.sendRedirect(url);
//			로그인이 안 되어 있는 경우 로그인 페이지로 이동한다.
				return false;
//			return을 안 해주면 쭉 실행되니 꼭 해줘야 함.
			}
		}

		return super.preHandle(request, response, handler);
	}

}
