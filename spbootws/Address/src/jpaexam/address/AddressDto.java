package jpaexam.address;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name = "ADDRESS_SEQ_GENERATOR", sequenceName = "SEQ_ADDRESS", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "tb_address")
public class AddressDto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
	private int seq;
	
	private String name;
	private String phone;
	private String email;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime wdate;

	
	
	@Override
	public String toString() {
		return String.format("등록 번호: %d, 이름: %s, 전화번호: %s, 이메일: %s, 등록일: %s", seq, name, phone, email, wdate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	
}
