--마리오 아울렛
--1관, 123번지, 10층짜리, 나이키, 5층, 10평, 에어맥스123, 신발, 100000
--2관, 234번지, 8층짜리, 다이소, 7층, 10평, 종이컵, 잡화, 1000
--3관, 567번지, 5층짜리, 아디다스, 3층, 5평, 츄리닝세트 213, 옷, 70000


create table dec21_building(
b_name varchar2(3 char) primary key,
b_location varchar2(5 char) not null,
b_floors number(2) not null
);

insert into dec21_building values ('1관', '123번지', 10);
insert into dec21_building values ('2관', '234번지', 8);
insert into dec21_building values ('3관', '345번지', 5);

select * from dec21_building;

drop table dec21_building cascade constraint purge;

----------------------------------------------------------

create table dec21_store(
s_name varchar2(10 char) primary key,
s_place varchar2(3 char) not null,
s_square number(2) not null,
s_floor number(2) not null
);

insert into dec21_store values ('나이키', '1관', 10, 5);
insert into dec21_store values ('다이소', '2관', 10, 7);
insert into dec21_store values ('아디다스', '3관', 5, 3);
insert into dec21_store values ('엔젤리너스', '1관', 11, 3);

drop table dec21_store cascade constraint purge;

-----------------------------------------------------------

create sequence dec21_merchandise_seq;

create table dec21_md(
m_no number(2) primary key,
m_name varchar2(15 char) not null,
m_line varchar2(10 char) not null,
m_price number(7) not null,
m_store varchar2(10 char) not null
);

insert into dec21_md values (dec21_merchandise_seq.nextval, '에어맥스', '신발', 100000, '나이키');
insert into dec21_md values (dec21_merchandise_seq.nextval, '롱패딩', '옷', 300000, '나이키');
insert into dec21_md values (dec21_merchandise_seq.nextval, '백팩', '가방', 60000, '나이키');
insert into dec21_md values (dec21_merchandise_seq.nextval, '버킷햇', '모자', 30000, '나이키');
insert into dec21_md values (dec21_merchandise_seq.nextval, '종이컵', '잡화', 1000, '다이소');
insert into dec21_md values (dec21_merchandise_seq.nextval, '동전지갑', '잡화', 3000, '다이소');
insert into dec21_md values (dec21_merchandise_seq.nextval, '다이어리 스티커', '잡화', 1000, '다이소');
insert into dec21_md values (dec21_merchandise_seq.nextval, '곰인형', '잡화', 5000, '다이소');
insert into dec21_md values (dec21_merchandise_seq.nextval, '트랙탑세트', '옷', 70000, '아디다스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '롱패딩', '옷', 280000, '아디다스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '숏패딩', '옷', 200000, '아디다스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '버킷햇', '모자', 28000, '아디다스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '아메리카노', '음료', 4000, '엔젤리너스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '바닐라라떼', '음료', 4800, '엔젤리너스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '밀크티', '음료', 4600, '엔젤리너스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '얼그레이 케이크', '디저트', 5500, '엔젤리너스');
insert into dec21_md values (dec21_merchandise_seq.nextval, '초코쉬폰 케이크', '디저트', 5000, '엔젤리너스');

select * from dec21_md;

drop sequence dec21_m_seq;

------------------------------------------------------------
select m_name, m_price from dec21_md where m_store in (select s_name from DEC21_STORE where s_place = (select b_name from DEC21_BUILDING where b_location = '123번지'));

select b_location from DEC21_BUILDING where b_name
in (select s_place from DEC21_STORE where s_name in (select m_store from DEC21_MD where m_price >= (select avg(m_price) from DEC21_MD)));

select m_name, m_price from DEC21_MD where m_price >= 100000 and m_store = '나이키';
select m_price, m_line, m_name from dec21_md where m_price = (select max(m_price) from DEC21_MD);
select avg(m_price) from dec21_md where m_line = '디저트';
select s_name, s_floor from DEC21_STORE where s_place in (select b_name from DEC21_BUILDING where(select max(b_floors) from DEC21_BUILDING));


-- 다 
-- 매장명, 층, 품명, 가격

select s_name, s_floor, m_name, m_price from dec21_store,DEC21_MD;