-- 테이블 만들기
create table 테이블명(
	필드명 자료형,
	필드명 자료형 옵션,
	...
);


-- SQL은 대문자로만 인식하기 때문에 낙타체 사용 금지(StationInfo 같은거!)
-- 뱀체 사용 (STATION_INFO)
-- 변수, 클래스 대소문자 구분 x!
-- 필드명 지을 때 → 테이블명 앞글자_이름 (ex. s_name)
-- 용량
    -- 숫자 기본 단위: byte
        -- 5, 50, 10, …
    -- 영어&숫자 1 글자 = 1byte / 한글 1 글자 = 3bytes
    -- 5 char → 5 글자 (단위: char → 글자 단위 / 사실은 15 bytes 겠지만..)
    
    
-- 자료형
    -- 글자
    -- 작은 따옴표 사용 ''
        -- Char(용량)
            -- EX) char(5 char)
            -- 무조건 그 용량대로 저장
            -- 빈 용량에 띄어쓰기 넣어서 저장
            -- s_name char(5 char)에 홍길동 입력할 경우
                -- ‘홍길동  ‘ 으로 저장
            -- 빠름
            -- 입력될 데이터가 고정된 경우(ex. 성별 - 여자, 남자, 기타 / 주민번호 등…) 사용 ⇒ 자릿수가 변동이 없는 데이터
        -- varchar2(용량) : variable char
            -- 덜 쓰면 덜 쓴 대로 저장
            -- s_name varchar2(5 char)에 홍길동 입력할 경우
                -- ‘홍길동’ 으로 저장
            -- 용량 절약 가능
            -- 느림(용량 다 썼는지 확인 → 다 안 썼으면 줄이기 : 이 과정을 거쳐야 하기 때문에)
            -- 입력될 데이터가 가변적인 경우(ex. 이름 - 홍길동, 박수한무, 심청..) 사용 ⇒ 자릿수가 변동될 수 있는 데이터
            
            -- ⇒ 좀 느려지겠지만 데이터를 저장하는 게 주 임무 : 용량관리가 더 중요
            
    -- 숫자
   	-- 0001, 1001 처럼 쓰는데 → 맨 앞자릿수로 음수/양수 판단하기 때문에 줄이기도 좀 그럼
        -- number(용량): 정수형
            -- EX) number(3) : 999
        -- number(용량,용량): 실수형
            -- 전체 용량 - 뒤의 용량
            -- EX) number(5,3) : 전체 자릿수 - 뒤에 자릿수 (5 - 3) : 99.999
        -- int(4bytes → 고정)
    -- 날짜
        -- date
        
        
create table dec19_student(
	s_name varchar2(10 char),
	s_age number(3),
	s_kor number(3),
	s_eng number(3),
	s_mat number(3)
);

insert into dec19_student values('홍길동', 30, 100, 80, 84);

insert into dec19_student values('김길동', 21, 100, 90, 98);

select * from dec19_student;

select avg(s_kor + s_eng + s_mat)/3 from dec19_student;

-------------------------------------------------------

-- 테이블 삭제
drop table dec19_product2 cascade constraint purge;
