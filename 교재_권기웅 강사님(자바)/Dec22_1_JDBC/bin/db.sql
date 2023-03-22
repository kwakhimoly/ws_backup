-- 어차피 Java/JSP/Spring프로그램 만들건데
-- Eclipse로 sql파일 만들어서 DB제어가 되니
-- Java프로젝트속에 sql파일 만들어서 겸사겸사...
-- sql파일 : 연습장느낌
-- 프로젝트 완료 -> sql파일 지우고 -> 프로젝트 출시

-- 교보문고
-- 강남점,서초구123,100평,이것이자바다,IT,30000,2021/01/01,재고5
-- 구로점,구로구456,50평,이것이자바다,IT,30000,2021/01/01,재고3

create table dec22_jijum(
	j_name varchar2(5 char) primary key,
	j_where varchar2(10 char) not null,
	j_size number(3) not null
);
insert into dec22_jijum values('구로', '구로구123', 80);
select * from dec22_jijum;

create table dec22_book(
	b_no number(2) primary key,
	b_title varchar2(10 char) not null,
	b_cate varchar2(5 char) not null,
	b_price number(6) not null,
	b_when date not null
);
create sequence dec22_seq;
insert into dec22_book values(dec22_seq.nextval, 
'안녕트랜스포머', 'IT', 35000, to_date('20220101','YYYYMMDD'));
select * from dec22_book;

create table dec22_sell(
	s_no number(2) primary key,
	s_j_name varchar2(5 char) not null,
	s_b_no number(2) not null,
	s_remain number(2) not null,
	constraint jijum_c
		foreign key (s_j_name) references dec22_jijum(j_name)
		on delete cascade,
	constraint book_c
		foreign key (s_b_no) references dec22_book(b_no)
		on delete cascade
);
insert into dec22_sell values(dec22_seq.nextval, '강남', 5, 3);
select * from dec22_sell;

-- 크기가 5평 이상인 지점 
-- 지점별, 카테별 평균가 
-- 평균가가 1000원 미만인건 빼고
select s_j_name, b_cate, avg(b_price)
from dec22_sell, dec22_book
where s_b_no = b_no 
	and s_j_name in (
		select j_name
		from dec22_jijum
		where j_size >= 5
	)
group by s_j_name, b_cate
having avg(b_price) >= 1000
order by s_j_name, b_cate;

-- '강'이 포함된 지점 책 정보
select b_title, b_cate, b_price, b_when
from dec22_book
where b_no in (
	select s_b_no
	from dec22_sell
	where s_j_name like '%강%'
);
-- '강'이 포함된 지점
-- 카테고리별 평균가
select b_cate, avg(b_price)
from dec22_book
where b_no in (
	select s_b_no
	from dec22_sell
	where s_j_name like '%구%'
)
group by b_cate
order by b_cate;





















