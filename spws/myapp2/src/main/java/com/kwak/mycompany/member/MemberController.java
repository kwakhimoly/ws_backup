package com.kwak.mycompany.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	@Autowired
//	타입만 보고 적당한 개체를 주임
	MemberService service;
	
	@RequestMapping(value = "/member/list")
	public String getList(Model model, MemberDto dto) {
		model.addAttribute("totalCnt", service.totalCnt(dto));
		return "member/list";
	}
	
//	모던 스크립트 파일 211페이지 참고
	@ResponseBody
	@RequestMapping(value = "/member/list_data")
	public Map<String, Object> list_data(MemberDto dto) {
		List<MemberDto> list = service.getList(dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalCnt", service.totalCnt(dto));
		map.put("data", list);
		
		return map;
	}
	
	@RequestMapping(value = "/member/write")
	public String write() {
		return "/member/member_write";
	}

	@RequestMapping(value = "/member/save")
	public String save(MemberDto dto) {
		service.isDuplicate(dto);
		service.insert(dto);
		return "redirect:/"; // home으로 이동(hello world!)
	}

	@RequestMapping(value = "/member/idcheck")
	@ResponseBody // jsp 이동이 아니라 json 형태의 데이터를 출력한다.
	public Map<String, String> idcheck(MemberDto dto) {
//		return "페이지명" - viewResolver가 가져가서 jsp를 호출한다.

		Map<String, String> map = new HashMap<String, String>();

		if (service.isDuplicate(dto)) {
			map.put("result", "fail");
		} else {
			map.put("result", "success");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/member/login_proc")
	public Map<String, String> login_proc(MemberDto dto, HttpServletRequest request) {
//		session 얻으려고 -> Http Servlet request 추가
		Map<String, String> map = new HashMap<String, String>();
		MemberDto resultDto = service.login(dto);
		
//		if-else 구문으로 써도 되고, return으로 if마다 끊어서 코드 간결하게 해도 되고
		if (resultDto == null) {
			map.put("result", "1");
			map.put("message", "해당 아이디가 존재하지 않습니다");
			return map;
		}
		
		if (!resultDto.getPassword().equals(dto.getPassword())) {
			map.put("result", "1");
			map.put("message", "패스워드가 일치하지 않습니다.");
			return map;
		}
		
		HttpSession session = request.getSession(); //섹션 개체 가져오기
//		세션은 웹에 접근하는 사용자마다 하나씩 객체가 자동으로 만들어진다.
		session.setAttribute("user_id", resultDto.getUser_id());
		session.setAttribute("user_name", resultDto.getUser_name());
		session.setAttribute("password", resultDto.getEmail());
		
		map.put("result", "0");
		map.put("message", "로그인 되셨습니다.");
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/logout")
	public Map<String, String> logout(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		session.invalidate();
		map.put("result", "success");
		map.put("message", "로그아웃 되셨습니다.");
		
		return map;
	}
	
	@RequestMapping(value = "/member/login")
	public String login(){
//		로그인 페이지로 이동하기
		return "member/login";
	}
	@RequestMapping(value = "/member/findid")
	public String findid(){
		return "member/findid";
	}

	@ResponseBody
	@RequestMapping(value = "/member/findid_proc")
	public Map<String, String> findid_proc(MemberDto dto){
		Map<String, String> map = new HashMap<String, String>();
		MemberDto resultDto = service.findid(dto);
		
		if(resultDto==null) {
			map.put("result", "1");
			map.put("message", "해당되는 회원 정보가 없습니다.");
			return map;
		}
		
		
		map.put("result", "0");
		map.put("message", "아이디 찾기 성공");
		map.put("user_id", resultDto.getUser_id());
		
		return map;
	}
	
	@RequestMapping(value = "/member/findpw")
	public String findpw() {
		return "member/findpw";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/findpw_proc")
	public Map<String, String> findpw_proc(MemberDto dto){
		Map<String, String> map = new HashMap<String, String>();
		MemberDto resultDto = service.findpw(dto);
		
		if(resultDto==null) {
			map.put("result", "1");
			map.put("message", "해당되는 회원 정보가 없습니다.");
			return map;
		}
		
		map.put("result", "0");
		map.put("message", "비밀번호 찾기 성공");
		map.put("password", resultDto.getPassword());
		
		return map;
	}
	
}
