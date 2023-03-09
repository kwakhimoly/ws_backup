-- 웹사이트

-- id: hong, pw: 123, 이름: 홍길등
--	제목: ㅋㅋㅋㅋ, 날짜: 지금


create table dec21_member (
m_id varchar2(15 char) primary key,
m_pw char(15 char) not null,
m_name varchar2(10 char) not null
);

insert into dec21_member values ('hong', '123', '홍길동');

create sequence dec21_bbs_seq;
create table dec21_bbs (
b_no number(3) primary key,
b_title varchar2(15 char) not null,
b_date date not null,
b_m_id varchar2(15 char) not null,
constraint bbs_writer
	foreign key(b_m_id) references dec21_member(m_id)
	on delete cascade
);

drop table dec21_write cascade constraint purge;

-- insert into dec21_bbs values (dec21_bbs_seq.nextval, 'ㅋㅋㅋ', sysdate, 'lee'); => 실패: lee가 없는 아이디라서
 insert into dec21_bbs values (dec21_bbs_seq.nextval, 'ㅋㅋㅋ', sysdate, 'hong');
 
 select * from dec21_member;
 select * from dec21_bbs;
 	-- hong 탈퇴 후엔 hong이 쓴 글 다 날아감(제약 조건 때문에)
 
 
	 --hong이 탈퇴
 delete from dec21_member where m_id = 'hong';
 	 --hong이 탈퇴했을 때 그 사람이 쓴 글 자동삭제 기능
 	 --없는 id로 글 쓰기 불가능 해야 
--		↓
 -- Foreign Key
 
 constraint 제약조건명
 	foreign key(필드명) references 테이블명(필드명)
 	on delete cascade