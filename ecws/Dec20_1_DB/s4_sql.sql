-- 전체 메뉴명, 가격
select m_name, m_price from dec20_menu;

-- 메뉴 평균가
select avg(m_price) from dec20_menu;

-- 가장 비싼 메뉴명
select m_name from dec20_menu where m_price = (select max(m_price) from dec20_menu);

-- 강남에 있는 매장명, 테이블 수
select r_name, r_tableno from dec20_restaurant where r_place = '강남';

-- 최연장자 사장님 이름, 집
select o_name, o_home from dec20_owner where o_birth = (select min(o_birth) from dec20_owner);

-- select max(o_birth) from dec20_owner; -> 가장 어림

-- 가게는 총 몇개
select count(*) from dec20_restaurant;

-- 식사류 시리즈 평균가
select avg(m_price) from dec20_menu where m_category like '%식사%';

-- 강남에 가면 뭘 먹을 수 있나
select m_name from dec20_menu where m_r_no = (select r_no from dec20_restaurant where r_place = '강남');
									--> 어차피 같은 menu에서 꺼내는 건데 조건문에 from menu를 또 쓸 필요가 없지

-- 제일 비싼 메뉴 어디 가면 먹을 수 있나
select r_place from dec20_restaurant where r_no in (select m_r_no from dec20_menu where m_price in (select max(m_price) from dec20_menu)); 

		--> subquery 값이 여러개가 나오면 에러 뜸
			-- single-row subquery returns more than one row
		--> 그럴 땐 = 대신 in 쓰면 여러 값 포함 가능

--최저가
select r_place from dec20_restaurant where r_no = (select m_r_no from dec20_menu where m_price = (select min(m_price) from dec20_menu)); 



-- 홍길동씨네 가게 메뉴명, 가격
메뉴명, 가격을 메뉴테이블에서 꺼내는데 / 조건은: 메뉴테이블의 식당넘버 = 운영 테이블의 식당넘버(인데 운영테이블의 사장넘버=홍길동 번호)
select m_name, m_price from dec20_menu where m_r_no in (select o_restaurantno from dec20_operate where o_ownerno = 1);

select m_name, m_price from dec20_menu where m_r_no in 
(select o_restaurantno from dec20_operate where o_ownerno in (select o_no from dec20_owner where o_name = '홍길동'));


-- 최연장자 사장님네 메뉴 평균가
select avg(m_price) from dec20_menu 
where m_r_no in (select o_restaurantno from dec20_operate 
where o_ownerno in (select o_no from dec20_owner where o_birth = (select min(o_birth) from dec20_owner)));
















