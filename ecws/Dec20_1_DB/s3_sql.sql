--데이터 하나에는 하나의 정보만
--> RDBMS(Relational DB Management System)
-->	 테이블 간의 관계를 중심으로...

	
	
--요식업 프랜차이즈
--
--홍길동, 1999-01-01, 수원,
--		김밥천국, 강남, 10 테이블
--			야채김밥, 식사류, 4000원
--			제육덮밥, 식사류, 6000원
--김길동, 2000-12-12, 안양,
--		우동천국, 구로, 8 테이블
--			기본우동, 식사류, 5000원
--			소주, 주류, 5000원
--			
--사장이름, 사장생년월일, 사장거주지, 지점 이름, 지점 지역, 테이블 갯수, 메뉴명, 메뉴 종류, 가격
--홍길동, 19990101, 수원, 김밥천국, 강남, 10, 야채김밥, 식사류, 4000원 => 가능
--홍길동, 19990101, 수원, 김밥천국, 강남, 10, 야채김밥, 식사류, 4000원, 제육덮밥, 식사류, 6000원 => 엥?
--
--홍길동, 19990101, 수원, 김밥천국, 강남, 10, 야채김밥, 식사류, 4000원
--홍길동, 19990101, 수원, 김밥천국, 강남, 10, 제육덮밥, 식사류, 6000원
--											=> 이런 식의 테이블 디자인이 나와야 함 -> 근데? 중복되는 데이터는??(용량낭비)
--
--사장님 테이블
--	식당 테이블
--		메뉴 테이블 
--					-> 다 따로 테이블 만들기 => 이 테이블 간의 관계

--	식당 : 메뉴
--		1 : n
--	메뉴 : 식당
--		1 : 1 
--			=> 제육덮밥 5000원, 소금 100g, 고춧가루 50g -> 그 식당만의 제육덮밥
--	사장님 : 식당
--		1 : n
--			=> 사장님 1 명이 식당 여러개 운영 가능
--	식당 : 사장님
--		1 : n
--			=> 식당 1 개를 사장님 여러명이 공동 운영 가능
--> 사장님 : 식당
--		m : n
--	사장님 < != > 메뉴
--		-> 직접 관계 없음

create sequence dec20_owner_sequence;
create table dec20_owner (
o_no number(2) primary key,
o_name varchar2(10 char) not null,
o_birth date not null,
o_home varchar2(10 char) not null
);
insert into dec20_owner values(dec20_owner_sequence.nextval, '홍길동', to_date('19990101', 'YYYY/MM/DD'), '수원'); --1
insert into dec20_owner values(dec20_owner_sequence.nextval, '김길동', to_date('20001212', 'YYYY/MM/DD'), '안양'); --2
insert into dec20_owner values(dec20_owner_sequence.nextval, '박길동', to_date('19980415', 'YYYY/MM/DD'), '신촌'); --6
select * from dec20_owner;

--create sequence dec20_restaurant_sequence; 같이 써도 되니까는
create table dec20_restaurant (
r_no number(2) primary key,
r_name varchar2(10 char) not null,
r_place varchar2(10 char) not null,
r_tableno number(2) not null
);
insert into dec20_restaurant values(dec20_owner_sequence.nextval, '김밥천국', '강남', 10); --3
insert into dec20_restaurant values(dec20_owner_sequence.nextval, '우동천국', '구로', 8); --4
insert into dec20_restaurant values(dec20_owner_sequence.nextval, '디저트천국', '홍대', 6); --5
select * from dec20_restaurant;


create sequence dec20_mo_seq;
------------------------------------------------------------------------
create table dec20_menu (
m_no number(2) primary key,
m_name varchar2(10 char) not null,
m_category varchar2(5 char) not null,
m_price number(6) not null,
m_r_no number(2) not null
);
insert into dec20_menu values(dec20_mo_seq.nextval, '야채김밥', '식사류', 4000, 3); --1
insert into dec20_menu values(dec20_mo_seq.nextval, '제육덮밥', '식사류', 6000, 3); --2
insert into dec20_menu values(dec20_mo_seq.nextval, '우동', '식사류', 5000, 4); --3
insert into dec20_menu values(dec20_mo_seq.nextval, '소주', '주류', 5000, 4); --4
insert into dec20_menu values(dec20_mo_seq.nextval, '얼그레이 케이크', '디저트류', 6000, 5); --5
insert into dec20_menu values(dec20_mo_seq.nextval, '초코베어 케이크', '디저트류', 5500, 5); --6
select * from dec20_menu;


create sequence dec20_om_seq;
create table dec20_operate(
o_no number(2) primary key,
o_ownerno number(2) not null,
o_restaurantno number(2) not null
);
insert into dec20_operate values(dec20_om_seq.nextval, 1, 3); --4
insert into dec20_operate values(dec20_om_seq.nextval, 1, 4); --5
insert into dec20_operate values(dec20_om_seq.nextval, 2, 3); --6
insert into dec20_operate values(dec20_om_seq.nextval, 6, 5); --7
select * from dec20_operate;
drop table dec20_operate cascade constraint purge;
