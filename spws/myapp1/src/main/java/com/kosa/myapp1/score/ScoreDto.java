package com.kosa.myapp1.score;

public class ScoreDto {
	private String seq = "";
	private String name = "";
	private String kor = "";
	private String eng = "";
	private String mat = "";

	public ScoreDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreDto(String seq, String name, String kor, String eng, String mat) {
		super();
		this.seq = seq;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

}
