-- RDBMS(Relational DB Management System)
--		테이블간의 관계를 중심으로...

-- 요식업 프랜차이즈

-- 데이터 하나에는 하나의 정보만 

-- 사장님
-- 식당
-- 메뉴

-- 사장님 : 식당 = m : n
-- 식당 : 메뉴 = 1 : n



-- 홍길동, 1999-01-01, 수원, 
--		김밥천국, 강남, 10테이블
--			야채김밥, 식사류, 4000원
--			제육덮밥, 식사류, 6000원
-- 김길동, 2000-12-12, 안양
--		우동천국, 구로, 8테이블
--			기본우동, 식사류, 5000원
--			소주, 주류, 5000원
--------------------------------------------
create sequence dec20_seq;

create table dec20_ceo(
	c_no number(2) primary key,
	c_name varchar2(10 char) not null,
	c_birthday date not null,
	c_home varchar2(5 char) not null
);
insert into dec20_ceo values(dec20_seq.nextval, '최길동', to_date('20030101', 'YYYYMMDD'), '수원');

create table dec20_restaurant(
	r_no number(2) primary key,
	r_name varchar2(10 char) not null,
	r_where varchar2(5 char) not null,
	r_table number(2) not null
);
insert into dec20_restaurant values(dec20_seq.nextval, '커피천국', '인천', 3);

create table dec20_menu(
	m_no number(2) primary key,
	m_name varchar2(10 char) not null,
	m_category varchar2(5 char) not null,
	m_price number(5) not null,
	m_r_no number(2) not null
);
insert into dec20_menu values(dec20_seq.nextval, '라떼', '음료', 4500, 6);

create table dec20_run(
	r_no number(2) primary key,
	r_c_no number(2) not null,
	r_r_no number(2) not null
);
insert into dec20_run values(dec20_seq.nextval, 5, 6);

select * from dec20_ceo;
select * from dec20_restaurant;
select * from dec20_menu;
select * from dec20_run;
-----------------------------------------------------
-- 전체 메뉴명, 가격
select m_name, m_price
from dec20_menu;

-- 메뉴 평균가 
select avg(m_price)
from dec20_menu;

-- 가장 비싼 메뉴명
select m_name
from dec20_menu
where m_price = (
	select max(m_price)
	from dec20_menu
);

-- 강남에 있는 매장명, 테이블 수
select r_name, r_table
from dec20_restaurant
where r_where = '강남';

-- 최연장자 사장님 이름, 집
select c_name, c_home
from dec20_ceo
where c_birthday = (
	select min(c_birthday)
	from dec20_ceo
);

-- 가게는 총 몇 개
select count(*)
from dec20_restaurant;

-- 밥시리즈 평균가
select avg(m_price)
from dec20_menu
where m_name like '%밥%';

-- subquery의 결과는 하나만 나와야 함
--		a=1 or a=2 or a=3형식을 원하면 in사용

-- 강남에 가면 먹을수있는 메뉴명
select m_name
from dec20_menu
where m_r_no in (
	select r_no
	from dec20_restaurant
	where r_where = '강남'
);
-- 제일 비싼메뉴 어디가면 먹을수있나
select r_where
from dec20_restaurant
where r_no in (
	select m_r_no
	from dec20_menu
	where m_price = (
		select max(m_price)
		from dec20_menu
	)
);
-- 홍길동씨네 가게 메뉴명, 가격
select m_name, m_price
from dec20_menu
where m_r_no in (
	select r_r_no
	from dec20_run
	where r_c_no in (
		select c_no
		from dec20_ceo
		where c_name = '홍길동'
	)
);
-- 최연장자 사장님네 메뉴 평균가
select avg(m_price)
from dec20_menu
where m_r_no in (
	select r_r_no
	from dec20_run
	where r_c_no in (
		select c_no
		from dec20_ceo
		where c_birthday = (
			select min(c_birthday)
			from dec20_ceo
		)
	)
);






















