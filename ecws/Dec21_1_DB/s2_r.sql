select 필드명, 필드명 as 닉네임, 연산자
from 테이블명, 테이블명,..
where 조건식;

outerjoin


select s_name as 매장명, s_floor as 층, m_name as 품명, m_price as 가격 from DEC21_STORE, DEC21_MD where s_name = m_store;

select b_name, b_location, s_name, s_floor from dec21_building, DEC21_STORE where b_name = s_place;

select b_name as 빌딩명, b_location as 위치, s_name as 매장명, s_floor as 층, m_name as 품명, m_price as 가격
from dec21_building, DEC21_STORE, dec21_md where dec21_building.b_name = dec21_store.s_place and s_name = m_store;

-- 12번지에 가면 살 수 있는 거 품명, 가격
select m_name, m_price from DEC21_MD, dec21_building, dec21_store where b_name = s_place and s_name = m_store and b_location = '234번지';

-- 무슨 관, 몇층에, 상품, 카테고리, 가격
--										를 가격 순으로
select m_name, m_line, m_price, s_floor, s_place from DEC21_MD, DEC21_STORE where m_store = s_name order by s_place, m_price desc;


-- 평균가 이상, 이름 순 정렬 - 가격 내림차순 정렬
select b_name, b_location, s_name, s_floor, m_name, m_line, m_price from DEC21_BUILDING, DEC21_STORE, DEC21_MD 
where b_name = s_place and s_name = m_store and m_price>=(select avg(m_price) from DEC21_MD) order by m_name, m_price desc;

-- 상품정보 다, 매장명 기준 -> 상품명 기준
-- m_no, m_name, m_line, m_price, m_store
-- 한 페이지 당 5개씩 , 데이터 번호를 1번부터 센다치고
-- 2페이지 (6~10번) 데이터 => 행 번호 필요
--				: sequence 번호(m_no) 사용하면 실패한 것도 카운팅 돼서 데이터가 원하는대로 안 나옴+테이블과는 무관
--				 +중간에 데이터를 삭제하더라도 번호가 자동으로 수정이 안됨 != 행 번호

--rownum(행번호 -> order by보다 먼저 발동)
	-- select할 때 부여되는 가상 필드
	-- * 랑 같이 못 씀
	-- oreder by 보다 먼저 발동
	-- 1번부터 조회해야 함

select * from(select rownum as rn, m_no, m_name, m_line, m_price, m_store 
from (select * from DEC21_MD order by m_store, m_name)) where rn>=11 and rn<=15;
-- () 안에서 rownum(1) 생성 -> 이미 정렬된 거에서 다시 select -> rownum(2) 생김
-- rownum(2)을 이름 바꿔서 rn 으로 만들기 -> rn을 조건식에 쓰기


--제일 높은 건물에서 살 수 있는 거 [b_floors in (select max(b_floors) from DEC21_BUILDING)]
-- 건물명, 위치, 매장명, 층, 상품명, 가격 [from DEC21_BUILDING, DEC21_STORE, DEC21_MD where b_name = s_place and s_name = m_store]
-- 건물명 -> 가격 내림차순 -> 상품명 [order by b_name, m_price desc, m_name]
-- 3~5 [from (select rownum as rn...) + where rn>=3 and rn<=5]

select rn, b_name, b_location, s_name, s_floor, m_name, m_price 
from (select rownum as rn, b_name, b_location, s_name, s_floor, m_name, m_price 
		from (select b_name, b_location, s_name, s_floor, m_name, m_price 
				from DEC21_BUILDING, DEC21_STORE, DEC21_MD 
					where b_name = s_place 
					and s_name = m_store 
					and b_floors in 
								(select max(b_floors) from DEC21_BUILDING) 
				order by b_name, m_price desc, m_name)) 
where rn>=3 and rn<=5;

----------------------------------------------------------------------------------------

-- 카테고리별 평균가
select m_line, avg(m_price) from DEC21_MD group by m_line;

-- 매장별, 카테고리별로 상품 수
select m_store, m_line, count(*) from DEC21_MD group by m_store, m_line order by m_store;

-- 건물별, 카테고리별, 최저가
select s_place, m_line, min(m_price) from DEC21_MD, DEC21_STORE 
where s_name=m_store 
group by s_place, m_line 
order by s_place, m_line;

-- 주소별, 카테고리별, 평균가
	-- 가격이 10000원 이상인 것만 ; 10000원 미만인 상품은 빼자
select b_location, m_line, avg(m_price) from DEC21_MD, DEC21_BUILDING, DEC21_STORE 
where b_name = s_place and s_name = m_store and m_price>=10000 
group by b_location, m_line order by b_location, m_line;

-- 주소별, 카테고리별, 평균가
	--계산 다 한 다음에
		-->평균가가 10000원 이상인 것만 보기
select b_location, m_line, avg(m_price) from DEC21_BUILDING,DEC21_STORE,DEC21_MD
where b_name = s_place and s_name = m_store 
group by b_location, m_line
having avg(m_price)>= 10000
order by b_location, m_line;

select b_location, m_line, avg(m_price) from DEC21_BUILDING,DEC21_STORE,DEC21_MD
where b_name = s_place and s_name = m_store and (select avg(m_price) from DEC21_MD)>= 10000
group by b_location, m_line
order by b_location, m_line;


----------------------------------------------------------------------------------------

-- 1관, 2관에서 살 수 있는거
-- 매장별, 카테별, 최고가
-- 50000원 넘는 건 안 볼래

select s_name, m_line, max(m_price) from DEC21_MD, DEC21_STORE 
where s_name = m_store and (s_place = '1관' or s_place = '2관')
group by s_name, m_line
having max(m_price)<50000
order by s_name, m_line;

-- 조건1 and 조건2 or 조건3
	false and false or true
		false or true
			true;
	true and false or false
		false or false
			false






























