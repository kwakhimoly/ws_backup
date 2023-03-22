-- DBA
-- 환경설정 - x
-- 계정관리 - x
-- 설계 - 연차가 쌓이면...
-- create table - 시킬걸요
-- drop table - 시킬걸요
-- create sequence - 시킬걸요
-----------------------
-- C : insert
-- R : select
-- U : update
update 테이블명
set 필드명 = 값, 필드명 = 값, ...
where 조건식;

-- 나이키가 1층으로 이전
update dec21_shop
set s_floor = 1
where s_name = '나이키';

-- 다이소 있는 건물이 345번지로 이전
update dec21_building
set b_addr = '345번지'
where b_name = (
	select s_b_name
	from dec21_shop
	where s_name = '다이소'
);

-- 나이키 상품 10%할인
update dec21_product
set p_price = p_price * 0.9
where p_s_name = '나이키';

-- 345번지의 상품 반값
update dec21_product
set p_price = p_price / 2
where p_s_name in (
	select s_name
	from dec21_shop
	where s_b_name = (
		select b_name
		from dec21_building
		where b_addr = '345번지'
	)
);

-- D : delete
delete from 테이블명
where 조건식;

-- 커피빈 상품 삭제
delete from dec21_product
where p_s_name = '커피빈';

-- 제일 싼 상품 삭제
delete from dec21_product
where p_price = (
	select min(p_price)
	from dec21_product
);

-- 아디다스 철수
delete from dec21_shop
where s_name = '아디다스';

select * from dec21_building;
select * from dec21_shop;
select * from dec21_product;

-- 김밥천국 강남 폐업
delete from 식당
where 이름 = '김밥천국' and 위치 = '강남';

delete from 메뉴
where 판매식당번호 = (
	select 번호
	from 식당
	where 이름 = '김밥천국' and 위치 = '강남'
);


















