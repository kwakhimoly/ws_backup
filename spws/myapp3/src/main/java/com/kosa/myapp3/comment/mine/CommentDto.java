package com.kosa.myapp3.comment.mine;

public class CommentDto {
	private int seq = 0;
	private int board_seq = 0;
	private String userid = "";
	private String content_comment = "";
	private String regdate = "";
	private String hit = "0";
	private String delyn = "";

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent_comment() {
		return content_comment;
	}

	public void setContent_comment(String content_comment) {
		this.content_comment = content_comment;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getDelyn() {
		return delyn;
	}

	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}

}
