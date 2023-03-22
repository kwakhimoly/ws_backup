create table dec19_student(
	s_name varchar2(10 char),
	s_age number(3),
	s_kor number(3),
	s_eng number(3),
	s_mat number(3)
);

insert into dec19_student values('홍길동', 30, 100, 60, 90);
insert into dec19_student values('김길동', 35, 10, 6, 9);

select * from dec19_student;

select avg(s_kor + s_eng + s_eng) / 3
from dec19_student;









