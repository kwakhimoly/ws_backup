--Read (C'R'UD) 
--				=> 제일 배워야할 게 많음!


-- 전체 조회
select * from dec20_snack;

-- 이름, 가격만
-- 		일단 다 가져와서, Java/Python 에서 조건문+반복문 => 말이 안됨: 전체 데이터가 얼마나 큰데!
-- 		필요한 것만 가져와서, Java/Python 에서 약간 처리만
select 필드명, 필드명, ... from 테이블명;
select s_name, s_price from dec20_snack;

-- 필드명 바꾸기
select s_name as name, s_exp as exp_date from dec20_snack;

-- 이름, 가격, 부가세
select s_name as name, s_price as price, s_price * 0.1 as vat from dec20_snack;

-- 이름, 가격, 그램당 가격
select s_name as name, s_price as price, s_price/s_weight as price_per_gram from dec20_snack;

-- 과자들 평균 가격
select avg(S_price) from dec20_snack;

-- 총 과자 몇 종류, g당 가격의 평균
select count(*),avg(s_price/s_weight) from dec20_snack;

-- 3000원 이하의 이름, 유통기한, 가격
select s_name, s_exp, s_price from dec20_snack where s_price<=3000;
-- 3000원짜리 이름 , 유통기한, 가격
select s_name, s_exp, s_price from dec20_snack where s_price=3000;

-- 2000원 미만은 몇 종류
select count(*) from DEC20_SNACK where s_price<=2000;

-- 포카칩 오리지널 가격
select s_price from DEC20_SNACK where s_name='포카칩 오리지널';

-- 오븐 시리즈 이름, 가격
select s_name, s_price from DEC20_SNACK where s_name like '%오븐%';

-- 내일 먹으면 죽는 과자
select s_name, s_exp, s_price from DEC20_SNACK where s_exp<=sysdate;

insert into DEC20_SNACK values (
DEC20_SNACK_sequence.nextval, '빅파이', to_date('20221220 20:00', 'yyyymmdd hh24:mi'), 700.12, 4500
);
insert into DEC20_SNACK values (
DEC20_SNACK_sequence.nextval, '엄마손파이', to_date('20221220 23:00', 'yyyymmdd hh24:mi'), 760.12, 4500
);
insert into DEC20_SNACK values (
DEC20_SNACK_sequence.nextval, '초코찰떡파이', to_date('20221220 21:00', 'yyyymmdd hh24:mi'), 450.68, 3500
);
 -- sysdate : 현재 시간+날짜  
 --				-> 빅파이는 시간이 현재 시간보다 늦으므로 내일 먹으면 죽는 과자에(오늘 23:59:59까지) 포함이 안됨
to_date('문자열', '패턴') : 문자열 -> 날짜
to_char(날짜, '패턴') : 날짜 -> 문자열
	ex) to_char(sysdate, 'YYYYMMDD')
concat('문자열', '문자열') : 문자열 붙이기

select s_name, s_exp, s_price from DEC20_SNACK 
where s_exp<=to_date(concat(to_char(sysdate, 'YYYYMMDD'), '235959'), 'YYYYMMDDHH24MISS');


-- 오븐 시리즈거나, 가격이 2000원 이상인 거
-- 이름, 가격
select s_name, s_price
from DEC20_SNACK
where s_name='%오븐%' or s_price>=2000;


-- 1000<가격<3000 인 거
-- 이름, 유통기한, 가격
select s_name, s_exp, s_price from DEC20_SNACK where 1000<s_price and s_price<3000;

-- 유통기한이 오늘 아침 9시~ 오늘 저녁 9시 범위 내인거
-- 이름, 유통기한, 가격
select s_name, s_exp, s_price from DEC20_SNACK 
where s_exp>=to_date(concat(to_char(sysdate, 'YYYY-MM-DD'), ' 09:00:00'), 'YYYY-MM-DD HH24:MI:SS') 
and s_exp<=to_date(concat(to_char(sysdate, 'YYYY-MM-DD'), ' 21:00:00'), 'YYYY-MM-DD HH24:MI:SS');
 
-- 최고가
-- 이름, 가격

select max(s_price) from DEC20_SNACK;

select s_name, s_price from DEC20_SNACK where s_price=(select max(s_price) from DEC20_SNACK);
														-> subquery
														
-- 유통기한 제일 길게 남은거 이름, 유통기한, 가격
select s_name, s_exp, s_price from dec20_snack where s_exp = (select max(s_exp) from dec20_snack);

-- 평균보다 싼거 이름, 가격
select s_name, s_price from dec20_snack where s_price <= (select avg(s_price) from dec20_snack);

