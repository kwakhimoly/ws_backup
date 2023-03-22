-- 통계함수 : sum(), avg(), max(), min(), count()
-- 데이터 조회 - R
select 필드명, 필드명 as 닉네임, 연산자사용가능, 통계함수, ...
from 테이블명, 테이블명, ...
where 조건식
group by 필드명, 필드명, ...
having 조건식
order by 필드명 (desc), 필드명 (desc), ...;

-- join
--		모든 경우의 수 별로 다 붙이고
--		그 중에 맞는것만 가져오기
--		필드명 같다면 테이블명.필드명
--		데이터 갯수를 폭발적으로 늘려서 RAM에 저장...
--		어쩔수 없을때만		

-- 매장명, 층, 품명, 가격
select s_name, s_floor, p_name, p_price
from dec21_shop, dec21_product
where s_name = p_s_name;

-- 빌딩명, 위치, 매장명, 층
select b_name, b_addr, s_name, s_floor
from dec21_building, dec21_shop
where dec21_building.b_name = dec21_shop.s_b_name;

-- 빌딩명, 위치, 매장명, 층, 품명, 가격
select b_name, b_addr, s_name, s_floor, p_name, p_price
from dec21_building, dec21_shop, dec21_product
where b_name = s_b_name and s_name = p_s_name;

-- subquery : where에 통계함수 못쓰니까
--			  테이블 여러개...

-- 12번지에 가면 살수있는거 품명, 가격 - 이러지맙시다
select p_name, p_price 
from dec21_building, dec21_shop, dec21_product
where b_name = s_b_name 
	and s_name = p_s_name 
	and b_addr = '사거리쪽';

-- 무슨관, 몇층에, 상품, 카테고리, 가격
-- 을 건물명 -> 가격 내림차순
select s_b_name, s_floor, p_name, p_cate, p_price
from dec21_shop, dec21_product
where s_name = p_s_name
order by s_b_name, p_price desc;

-- 평균가 이상인거
-- 무슨관, 위치, 매장명, 몇층에, 상품명, 카테고리, 가격
-- 상품명 -> 가격 내림차순
select b_name, b_addr, s_name, s_floor, p_name, p_cate, p_price
from dec21_building, dec21_shop, dec21_product
where b_name = s_b_name 
	and s_name = p_s_name
	and p_price >= (
		select avg(p_price)
		from dec21_product
	)
order by p_name, p_price desc;
-- sequence
--		실패해도 올라가
--		테이블과는 무관
--		3번학생인데, 2번학생 전학가면 땡겨지나
--		1,2,3,4 아님, 행번호 아님

-- 상품테이블 정보 다???
-- 매장명 -> 상품명
-- 11 ~ 15 : seq로 처리되는 p_no말고, 진짜 행번호

-- rownum
-- 		select할때 자동부여되는 가상필드
--		*랑 같이 못씀
--		1번부터 셈
--		order by보다 먼저 발동
--		1번부터 조회해야
select *
from (
	select rownum as rn, p_no, p_name, p_cate, p_price, p_s_name
	from (
		select *
		from dec21_product
		order by p_s_name, p_name
	)
)
where rn >= 11 and rn <= 15;

-- 제일 높은 건물에서 살수있는거
-- 건물명, 위치, 매장명, 층, 상품명, 가격
-- 건물명 -> 가격 내림차순 -> 상품명
-- 3 ~ 5
select *
from (
	select rownum as rn, b_name, b_addr, s_name, s_floor, p_name, p_price
	from (
		select b_name, b_addr, s_name, s_floor, p_name, p_price
		from dec21_building, dec21_shop, dec21_product
		where b_name = s_b_name 
			and s_name = p_s_name
			and b_floor = (
				select max(b_floor)
				from dec21_building
			)
		order by b_name, p_price desc, p_name
	)
)
where rn >= 3 and rn <= 5;
-----------------------------------------------
-- 카테고리별 평균가
select p_cate, avg(p_price)
from dec21_product
group by p_cate;

-- 매장별, 카테별 상품 갯수
select p_s_name, p_cate, count(*)
from dec21_product
group by p_s_name, p_cate
order by p_s_name, p_cate;

-- 건물별, 카테별, 최저가
select s_b_name, p_cate, min(p_price)
from dec21_shop, dec21_product
where s_name = p_s_name
group by s_b_name, p_cate
order by s_b_name, p_cate;
-- 데이터 필터링
-- 가격이 1000원 이상인것만 대상으로 
-- 주소별, 카테별, 평균가
select b_addr, p_cate, avg(p_price)
from dec21_building, dec21_shop, dec21_product
where b_name = s_b_name
	and s_name = p_s_name
	and p_price >= 1000
group by b_addr, p_cate
order by b_addr, p_cate; 

-- 결과 필터링
-- 주소별, 카테별, 평균가
-- 평균가가 1000원 이상인것만 봅시다
select b_addr, p_cate, avg(p_price)
from dec21_building, dec21_shop, dec21_product
where b_name = s_b_name
	and s_name = p_s_name
group by b_addr, p_cate
having avg(p_price) >= 1000
order by b_addr, p_cate; 

-- 1관, 2관것만
-- 매장별, 카테별, 최고가
-- 50000원 넘는거 안볼래요 
select s_name, p_cate, max(p_price)
from dec21_shop, dec21_product
where s_name = p_s_name
	and (s_b_name = '1관' 
		or s_b_name = '2관')
group by s_name, p_cate
having max(p_price) <= 50000
order by s_name, p_cate;























