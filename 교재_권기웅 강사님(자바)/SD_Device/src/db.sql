-- 주제정하기 : 고객 + PM
-- 테이블 디자인 : 상급DBA
-- 테이블 만들고... : DBA
create table sd_academy(
	sa_name varchar2(10 char) primary key,
	sa_addr varchar2(10 char) not null,
	sa_startdate date not null
);

create table sd_device(
	sd_no number(3) primary key,
	sd_name varchar2(10 char) not null,
	sd_cate varchar2(10 char) not null,
	sd_price number(7) not null,
	sd_where varchar2(10 char) not null,
	constraint sd_a_d
		foreign key (sd_where) references sd_academy(sa_name)
		on delete cascade
);

create sequence sd_seq;
insert into sd_academy values('솔데스크강남', '강남구', to_date('20100101','YYYYMMDD'));
insert into sd_device values(sd_seq.nextval, '오큘러스', 'VR', 700000, '솔데스크강남');
select * from sd_academy;

select *
from (
	select rownum as rn, sd_no, sd_name, sd_cate, sd_price, sd_where
	from (
		select * 
		from sd_device
		order by sd_name, sd_no
	)
)
where rn >= 3 and rn <= 5;




