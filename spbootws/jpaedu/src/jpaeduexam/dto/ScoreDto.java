package jpaeduexam.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//	이 annotation을 보고 오라클에서 시퀀스 seq_score을 만든다.
//	오라클에서만 sequence를 사용하기 때문에 해당 어노테이션도 오라클 사용할 때만 이용
@SequenceGenerator
(name = "SCORE_SEQ_GENERATOR", sequenceName = "SEQ_SCORE", initialValue = 1, allocationSize = 10)

//	RDBMS 테이블과 DTO 개체를 연결한다. 
@Entity

//	오라클에 TB_SCORE라는 이름의 테이블을 생성한다. DTO
@Table(name = "TB_SCORE")
public class ScoreDto {
//	primary key로 사용한다.
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORE") //자동생성,dbms마다 다르게 표시해야 한다.
	private int seq;
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime wdate;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public LocalDateTime getWdate() {
		return wdate;
	}
	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	
}
