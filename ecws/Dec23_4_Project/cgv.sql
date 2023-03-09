select t_no, m_no, t_name, t_cgv_name, m_title from dec23_theater, dec23_movie order by t_no, m_no where '본즈앤올' in (select m_title from dec23_movie);

select t_no, m_no, t_name, t_cgv_name, m_title from dec23_theater, dec23_movie where m_title in '본즈앤올' order by t_no, m_no;


create table dec23_cgv(
cgv_name varchar2(10 char) primary key,
cgv_location varchar2(10 char) not null,
cgv_room number(2) not null
);

insert into dec23_cgv values('신촌아트레온', '신촌', 3);
insert into dec23_cgv values('연남', '연남', 2);

create table dec23_movie(
m_no number(2) primary key,
m_title varchar2(15 char) not null,
m_director varchar2(15 char) not null,
m_date date not null,
m_time number(3) not null
);

create sequence dec23_m_seq;
drop sequence dec23_m_seq;
insert into dec23_movie values(dec23_m_seq.nextval, '본즈앤올', '루카구아다니노', to_date('20221130', 'yyyy-mm-dd'),130);


drop table dec23_cgv cascade constraint purge;

create table dec23_theater(
t_no number(2) primary key,
t_name char(3 char) not null,
t_cgv_name varchar2(10 char) not null,
t_number number(3) not null,

constraint theater_cgv foreign key(t_cgv_name) references dec23_cgv(cgv_name) on delete cascade
);

drop table dec23_theater cascade constraint purge;
create sequence dec23_t_seq;
drop sequence dec23_t_seq;

insert into dec23_theater values(dec23_t_seq.nextval, '1관', '신촌아트레온', 170);

select*from dec23_cgv;
select count(*) from dec23_cgv;
select*from dec23_movie;
select*from dec23_theater;
select*from dec23_runmovie;

create table dec23_runmovie(
r_no number(3) primary key,
r_t_no number(2) not null,
r_m_no number(2) not null,
r_t_name varchar2(3 char) not null,
r_t_cgv_name varchar2(10 char) not null,
r_m_title varchar2(15 char) not null,
constraint runmovie_theater foreign key(r_t_no) references dec23_theater(t_no) on delete cascade,
constraint runmovie_movie foreign key(r_m_no) references dec23_movie(m_no) on delete cascade
);

drop table dec23_runmovie cascade constraint purge;
create sequence dec23_r_seq;
insert into DEC23_RUNMOVIE values (dec23_r_seq.nextval, 1, 1, '1관', '신촌아트레온', '본즈앤올');
delete from dec23_runmovie where r_m_title = '썬다운' and r_t_cgv_name = '강남' and r_t_name = '1관';