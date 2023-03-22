-- SQL(Structured Query Language)
--		RDBMS를 제어하는 언어
--		OracleDB든 MySQL이든 99%는 같음
--		대소문자 구별x -> 대문자로 인식
------------------------------------------
-- 열(column) : 필드(field)
-- 행(row) : 데이터(data), 레코드(record) 
------------------------------------------
-- 용량
--		5 : 5bytes(영어/숫자1글자=1byte, 한글1글자=3bytes)
--		5 char : 5글자(사실은 15bytes겠지만...)
------------------------------------------
-- 자료형
-- 		글자
--			char(용량) : 무조건 그 용량대로 저장
--						빠름
--						자리수 변동이 없는 데이터
--			varchar2(용량) : 덜쓰면 덜쓴대로 저장
--							용량절약
--							느림
--							주력
-- 		숫자
--			number(용량) : 정수형
--			number(용량, 용량) : 실수형
--				number(5, 3) : 99.999
-- 		날짜
--			date
------------------------------------------
-- 옵션
-- 		not null : 데이터를 반드시 넣어야
--		primary key : not null + 중복된거 못넣게
--			그 데이터를 대표하는 값
--			데이터 찾을때 정확한 검색 기준이 될 것
--			한 테이블에 PK는 있도록
--		autoincrement : 숫자 자동으로 증가
--			OracleDB에는 없음
------------------------------------------
-- 테이블 만들기
create table 테이블명(
	필드명 자료형 옵션,
	필드명 자료형 옵션,
	...
);
------------------------------------------
-- 테이블 삭제
drop table 테이블명 cascade constraint purge;
drop table dec20_coffee cascade constraint purge;
------------------------------------------
create table dec20_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);
------------------------------------------
-- 데이터 넣기 : C
insert into 테이블명(필드명, 필드명, ...) values(값, 값, ...);
insert into 테이블명 values(값, 값, ...);

insert into dec20_coffee values('아아', 3000);
insert into dec20_coffee values('아아', 4000);
insert into dec20_coffee values('라떼', 4000);
insert into dec20_coffee values('우유', 2000);
insert into dec20_coffee values('물', 2000);

insert into DEC20_COFFEE(c_name, c_price) values('뜨아', 4000);
-- 필드 순서 바꿀수도 - ?
insert into DEC20_COFFEE(c_price, c_name) values(5000, '녹차라떼');
-- 필드를 비워 놓을수도 - ?
insert into DEC20_COFFEE(c_name) values('고구마라떼');
------------------------------------------
-- 데이터 조회 : R
select * from DEC20_COFFEE;
------------------------------------------------------------
-- 학생번호 : 정식 데이터는 아니고 PK는 줘야하니 억지로 만든거라서
-- 사람이 신경쓰기가...
-- -> 번호가 좀 자동으로 처리됐으면

-- sequence : 테이블과는 무관한 존재
--			  근데 용도상 테이블이랑 같이쓰기는 하고...
--			  insert에 실패해도 올라감
--			  여러 테이블이 같이 쓰기도 하고
--			  => 행번호가 아님

-- 시퀀스 생성
create sequence 시퀀스명;
create sequence dec20_student_seq;

-- 시퀀스 사용
시퀀스명.nextval

drop table dec20_student cascade constraint purge;

create table dec20_student(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into dec20_student 
values(dec20_student_seq.nextval, '홍길동', 100, 19, 28);

insert into dec20_student 
values(dec20_student_seq.nextval, '홍길동', 100, 90, 80);

insert into dec20_student 
values(dec20_student_seq.nextval, '김길동', 10, 9, 8);

insert into dec20_student 
values(dec20_student_seq.nextval, 
'김길동ㄴㅇㅎㄴㅇㄹ훎ㄶ엉코날ㄴㅁㅇ', 10, 9, 8);

insert into dec20_student 
values(dec20_student_seq.nextval, 
'최길동', 100, 98, 68);

select * from dec20_student;
-----------------------------------------
create table dec20_snack(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_exp date not null,
	s_weight number(5, 2) not null,
	s_price number(5) not null
);
create sequence dec20_snack_seq;

-- 날짜처리
--		sysdate : DB서버의 현재시간날짜
--		to_date('', '패턴') : 문자열 -> 날짜
--			YYYY, MM, DD, HH, HH24, MI, SS
--		프로그래밍언어들의 날짜객체
insert into dec20_snack
values(
	dec20_snack_seq.nextval,
	'노래방새우깡', 
	to_date('20210101 15:00', 'YYYYMMDD HH24:MI'),
	999.12,
	5500
);
insert into dec20_snack
values(
	dec20_snack_seq.nextval,
	'새우깡', 
	sysdate,
	200.12,
	3000
);
insert into dec20_snack
values (
	dec20_snack_seq.nextval, '빅파이', 
	to_date('20221220 20:00', 'YYYYMMDD HH24:MI'),
	700.12,	3500
);
select * from dec20_snack;






