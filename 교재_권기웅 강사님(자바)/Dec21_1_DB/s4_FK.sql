-- foreign Key
-- 		없는 id로 글쓰기가 불가능해야
-- 		hong이 탈퇴 그 사람이 쓴 글도 지우자 : 자동


create table dec21_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(10 char) not null,
	m_name varchar2(10 char) not null
);
insert into dec21_member values('hong', '123', '홍길동');

-- constraint 제약조건명
--		foreign key (필드명) references 테이블명(필드명)
--		on delete cascade
create table dec21_bbs(
	b_no number(2) primary key,
	b_title varchar2(10 char) not null,
	b_date date not null,
	b_m_id varchar2(10 char) not null,
	constraint bbs_writer
		foreign key (b_m_id) references dec21_member(m_id)
		on delete cascade
);
drop table dec21_bbs cascade constraint purge;
insert into dec21_bbs values(1, 'ㅋㅋㅋ', sysdate, 'lee');
insert into dec21_bbs values(1, 'ㅋㅋㅋ', sysdate, 'hong');
delete from dec21_member where m_id = 'hong';
select * from dec21_bbs;