create table dec22_store (
s_name varchar2(14 char) primary key,
s_addr varchar2(14 char) not null,
s_size number(4) not null
);

insert into dec22_store values ('강남점', '서초구 123', 100);
insert into dec22_store values ('구로점', '구로구 456', 90);

delete from DEC22_STORE where s_name = '교보문고 구로점';
--update DEC22_sell set sl_s_name ='강남점' where sl_s_name ='교보문고 강남점' ;
	--> 어차피 보통 primary key 준건 수정을 안 하고!

select*from dec22_store;
drop table dec22_store cascade constraint purge;

create table dec22_bookinfo(
b_no number(3) primary key,
b_title varchar2(15 char) not null,
b_genre varchar2(10 char) not null,
b_price number(6) not null,
b_date date not null
);

drop sequence dec22_b_seq;
create sequence dec22_b_seq;

insert into dec22_bookinfo values (dec22_b_seq.nextval, '이것이 자바다', 'IT', 30000, to_date('20210101', 'yyyy/mm/dd'));
insert into dec22_bookinfo values (dec22_b_seq.nextval, '해리포터와 마법사의 돌', '판타지', 14000, to_date('20201030', 'yyyy/mm/dd'));
insert into dec22_bookinfo values (dec22_b_seq.nextval, '해리포터와 비밀의 방', '판타지', 15001, to_date('20211030', 'yyyy/mm/dd'));
select*from dec22_bookinfo;
drop table dec22_bookinfo cascade constraint purge;


create table dec22_sell(
sl_no number(3) primary key,
sl_b_no number(3) not null,
sl_s_name varchar2(14 char) not null,
sl_stock number(3) not null,
constraint store_stock foreign key(sl_s_name) references dec22_store(s_name) on delete cascade,
constraint bookinfo_stock foreign key(sl_b_no) references dec22_bookinfo(b_no) on delete cascade
);
-- constraint bookinfo_stock => 책 정보를 아예 삭제
		--> foreign key 잘 안됨: 서버 사양 때문에..(lite라)
drop table dec22_sell cascade constraint purge;

drop sequence dec22_s_seq;
create sequence dec22_s_seq;
insert into dec22_sell values (dec22_s_seq.nextval, 1, '강남점', 5);
insert into dec22_sell values (dec22_s_seq.nextval, 1, '구로점', 3);
insert into dec22_sell values (dec22_s_seq.nextval, 2, '강남점', 1);
insert into dec22_sell values (dec22_s_seq.nextval, 3, '강남점', 1);

update DEC22_SELL set sl_b_no=2 where sl_b_no = 22;

select*from dec22_sell;

-- sql 파일: 연습장 느낌
-- 프로젝트 완료 -> sql 파일 지우고 -> 프로젝트 출시



-----------------------------------------------------------------------------


		--크기가 5평 이상인 지점
		--지점별, 카테별 평균가 --> 평균가가 20000원 미만인건 빼고
--		select s_name, b_genre, avg(b_price) from DEC22_bookinfo, dec22_store, dec22_sell 
--		where s_name = sl_s_name and b_no = sl_b_no and s_size>=5 
--		group by s_name, b_genre having avg(b_price)>=1000 order by s_name, b_genre;

		--> dec22_store는 결과 값에 필요 없으니까 join 말고 subquery 사용!
		
		select sl_s_name, b_genre, avg(b_price) from dec22_sell, dec22_bookinfo
		where sl_b_no = b_no and sl_s_name in (select s_name from DEC22_STORE where s_size>=5)
		group by sl_s_name, b_genre having avg(b_price)>=20000
		order by sl_s_name, avg(b_price);
		
		select b_title, b_price from dec22_bookinfo
		where b_no = (select sl_b_no from dec22_sell where sl_s_name like '%구로%')
		order by b_title, b_price desc;
		
		
		
		
select b_title, b_genre, b_price, b_date from dec22_bookinfo where b_no in (select sl_b_no from dec22_sell where sl_s_name ='구로점');

select b_genre, avg(b_price) from DEC22_BOOKINFO where b_no in 
(select sl_b_no from DEC22_SELL where sl_s_name like '%강%') group by b_genre order by b_genre;
