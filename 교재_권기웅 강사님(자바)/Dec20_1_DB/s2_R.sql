-- 통계함수 : sum(), avg(), max(), min(), count()
-- 데이터 조회 - R
select 필드명, 필드명 as 닉네임, 연산자사용가능, 통계함수, ...
from 테이블명
where 조건식;

-- subquery
-- 유통기한 제일 길게 남은거 이름, 유통기한, 가격
select s_name, s_exp, s_price
from dec20_snack
where s_exp = (
	select max(s_exp)
	from dec20_snack
);
-- 평균보다 싼 거 이름, 가격
select s_name, s_price
from dec20_snack
where s_price < (
	select avg(s_price)
	from dec20_snack
);

-- 최고가 이름, 가격
select s_name, s_price
from dec20_snack
where s_price = (
	select max(s_price)
	from dec20_snack
);



-- 유통기한이 오늘아침9시 ~ 오늘저녁9시 범위내인거
-- 이름, 유통기한, 가격
select s_name, s_exp, s_price
from dec20_snack
where s_exp >= 
		to_date(
			concat(
				to_char(sysdate, 'YYYY-MM-DD'),' 09:00:00'
			),
			'YYYY-MM-DD HH24:MI:SS'
		)
	and 
	s_exp <= 
		to_date(
			concat(
				to_char(sysdate, 'YYYY-MM-DD'),' 21:00:00'
			),
			'YYYY-MM-DD HH24:MI:SS'
		);

-- 1000 < 가격 < 3000원 인거
-- 이름, 유통기한, 가격
select s_name, s_exp, s_price
from dec20_snack
where s_price > 1000 and s_price < 3000;

-- and, or
-- '깡'시리즈거나, 가격이 2000원 이상인거
-- 이름, 가격
select s_name, s_price
from dec20_snack
where s_name like '%깡' or s_price >= 2000;

-- to_date('문자열', '패턴') : 문자열 -> 날짜
-- to_char(날짜, '패턴') : 날짜 -> 문자열
-- concat('문자열', '문자열') : 문자열 붙이기

-- sysdate : 2022/12/20 14:03:05[날짜]
-- to_char(, 'YYYYMMDD') : '20221220'[글자]
-- concat( , '235959') : '20221220235959'[글자]
-- to_date(, 'YYYYMMDDHH24MISS') : 2022/12/20 23:59:59[날짜]

-- 내일 먹으면 죽는 과자이름, 유통기한, 가격
select s_name, s_exp, s_price
from dec20_snack
where s_exp <= 
	to_date(
		concat (
			to_char(sysdate, 'YYYYMMDD'),
			'235959'
		),
		'YYYYMMDDHH24MISS'
	);

-- 문자열 포함 검색
--		필드명 like '패턴'
--					'%깡' : 깡으로 끝
--					'깡%' : 깡으로 시작
--					'%깡%' : 깡 포함
-- '깡'시리즈 이름, 가격
select s_name, s_price
from dec20_snack
where s_name like '%깡%';

-- 1000원 미만은 몇 종류
select count(*)
from dec20_snack
where s_price < 1000;

-- 새우깡 가격
select s_price
from dec20_snack
where s_name = '새우깡';

-- 3000원 이하인 과자의 이름, 유통기한, 가격
select s_name, s_exp, s_price
from dec20_snack
where s_price <= 3000;

-- 총 과자 몇 종류, g당가격의 평균
select count(*), avg(s_price / s_weight)
from dec20_snack;

-- 평균가
select avg(s_price)
from dec20_snack;

-- 이름, 가격, g당 가격
select s_name, s_price, s_price / s_weight
from dec20_snack;

-- 이름, 가격, 부가세
select s_name, s_price, s_price * 0.1 as vat
from dec20_snack;

-- 이름, 유통기한만(필드명 바꿔서)
select s_name, s_exp as exp_date
from dec20_snack;

-- 이름, 가격만
select s_name, s_price
from dec20_snack;





