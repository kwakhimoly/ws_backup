package com.kosa.mvc1.member;

public class MemberDto {
	// 콘솔창의 드래그 ctrl-alt 드래그
	// 복사 ctrl+enter
	// 변수명 소문자로 바꾸기 -> ctrl+shift+y
	private String member_id = "";
	private String user_id = "";
	private String password = "";
	private String user_name = "";
	private String email = "";
	private String phone = "";

	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String member_id, String user_id, String password, String user_name, String email, String phone) {
		super();
		this.member_id = member_id;
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
