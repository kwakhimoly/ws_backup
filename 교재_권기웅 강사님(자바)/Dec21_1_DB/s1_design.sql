-- 마리오아울렛

-- 1관, 123번지, 10층짜리, 나이키, 5층, 10평, 에어맥스123, 신발, 100000
-- 2관, 234번지, 8층짜리, 다이소, 7층, 10평, 종이컵, 잡화, 1000
-- 3관, 567번지, 5층짜리, 아디다스, 3층, 5평, 츄리닝세트213, 옷, 70000

-- x 나이키 매장은 1관 5층에 있는데, 1관 8층에서 이벤트한다고, 나이키 팝업스토어 열었다가...
-- v 이벤트 같은거 없고, 나이키 매장은 1관 5층에만

-- 건물
--		이름(PK), 위치, 층수
-- 매장
--		이름(PK), 층, 크기, 건물이름
-- 상품
--		번호(PK), 이름, 종류, 가격, 매장이름

-- 건물 : 매장 = 1 : n
-- 매장 : 상품 = 1 : n
------------------------------------------------
create table dec21_building(
	b_name varchar2(3 char) primary key,
	b_addr varchar2(10 char) not null,
	b_floor number(2) not null
);
insert into dec21_building values('3관', '강의실근처', 5);

create table dec21_shop(
	s_name varchar2(10 char) primary key,
	s_floor number(2) not null,
	s_size number(2) not null,
	s_b_name varchar2(3 char) not null
);
insert into dec21_shop values('다이소', 3, 15, '3관');

create table dec21_product(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_cate varchar2(5 char) not null,
	p_price number(7) not null,
	p_s_name varchar2(10 char) not null
);
create sequence dec21_product_seq;
insert into dec21_product values(dec21_product_seq.nextval, '청바지', '옷', 35000, '나이키');

select * from dec21_building;
select * from dec21_shop;
select * from dec21_product;
-------------------------
-- 12번지에 가면 살수있는거 품명, 가격
select p_name, p_price
from dec21_product
where p_s_name in (
	select s_name
	from dec21_shop
	where s_b_name = (
		select b_name
		from dec21_building
		where b_addr = '사거리쪽'
	)
);
-- 평균가보다 비싼거는 어디가면 살수있나
select b_addr
from dec21_building
where b_name in (
	select s_b_name
	from dec21_shop
	where s_name in (
		select p_s_name
		from dec21_product
		where p_price > (
			select avg(p_price)
			from dec21_product
		)
	)
);
















