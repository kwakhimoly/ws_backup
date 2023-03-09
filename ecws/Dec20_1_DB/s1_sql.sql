select * from dec19_student;

--테이블 만들기
create table dec20_coffee(
m_name varchar(10 char) primary key,
m_price number(5) not null
);

--creat('C'RUD)
insert into 테이블명(필드명, 필드명, ...) values (값, 값, ...);
insert into dec20_menu(m_name, m_price) values ('바닐라라떼', 4800);
insert into dec20_menu(m_price, m_name) values (4800, '밀크티');
						---> 필드 순서 바꿔서 작성해도 잘 작동함 : 별 의미 X	
insert into dec20_menu(m_name) values ('물');
						---> 필드 비워놓을 수도 있음 : 입력 안 하면 null인데 계산도 못 하고 쓸모 없음
						
insert into dec20_menu values ('아이스아메리카노', 4000);
insert into dec20_menu values ('카페라떼', 4500);
					---> 필드명 부분 생략시키고 차례대로 작성하는게 일반적 : 굳이 써서 얻는게 없음


-- eclipse에서 첫 select가 안 나오는 버그 있음 -> 껐다 키기
--Read(데이터 조회, C'R'UD)
select * from dec20_menu;


--테이블 삭제
drop table dec20_menu cascade constraint purge;



--옵션
--			not null: 데이터를 반드시 넣어야 함
--			primary key : not null + 중복 데이터 못 넣게
--						그 데이터를 대표하는 값
--						데이터 찾을 때 정확한 검색 기준이 됨
--						한 테이블에 PK 하나는 꼭 있도록

insert into dec20_coffee values ('아이스아메리카노', 3000);
--insert into dec20_coffee values ('아이스아메리카노'); -> not null로 실패
insert into dec20_coffee values ('카페라떼', 3500);
--insert into dec20_coffee values ('카페라떼', 3800); -> 중복 방지(primary key)로 실패
insert into dec20_coffee values ('바닐라라떼', 3800);
insert into dec20_coffee values ('밀크티', 4000);
insert into dec20_coffee values ('레몬에이드', 3800);

--아아 얼마에요? (primary key) => 3000원이요 -> 검색에 유용!
--3800원짜리 뭐뭐 있다구요? => 바닐라라떼랑 레몬에이드랑...




--		이름에 primary key 넣으면 동명이인 처리가 조금 힘듦(홍길동(A), 홍길동(B)로 하면 되긴 하는데..)
--		primary key 주기 좋은 필드 만들기(ex: 번호)
--				=> BUT 새로 추가하는 학생에게 몇 번 부여하는지 관리자가 일일이 신경 쓰기도 좀.. -> 자동으로 못 하나?

--		학생 번호: 정식 데이터가 아니고 PK 부여하려 임의로 만든 데이터. 자동으로 처리되면 좋은..
--			=> 시퀀스 생성

--시퀀스 생성
create sequence 시퀀스명;
--		 ↳ 테이블과는 무관한 존재 But 용도상 테이블이랑 같이 쓰긴 함 -> 이름 지을 때 사용할 테이블명_seq 이런 식으로
--		insert에 실패해도 올라감
--		행번호가 아님

create sequence dec20_student_seq;

create table dec20_student(
	s_no number(4) primary key,
	s_name varchar2(4 char) not null, 
	s_kor number(3) not null, 
	s_eng number(3) not null, 
	s_mat number(3) not null
);
insert into dec20_student values (dec20_student_seq.nextval, '훈이', 80, 92, 91);

insert into dec20_student values (dec20_student_seq.nextval, '철수', 90, 88, 92);
insert into dec20_student values (dec20_student_seq.nextval, '미애', 100, 90, 97);
insert into dec20_student values (dec20_student_seq.nextval, '철수', 80, 92, 91);

select * from dec20_student;

drop table dec20_student cascade constraint purge;

--테이블 수정은 어떻게? -> 잘 안 씀...

-------------------------------------------------------------------------------------

create sequence dec20_snack_sequence;

--이름에 pk 넣으면 같은 상품이어도 지점별로 가격이 다르면??
create table dec20_snack(
s_no number(3) primary key,
s_name varchar2(10 char) not null,
s_exp date not null,
s_weight number(5,2) not null,
s_price number(5) not null
);

insert into dec20_snack values (dec20_snack_sequence.nextval, '포카칩 양파맛', sysdate, 136.70, 2500);
insert into dec20_snack values (dec20_snack_sequence.nextval, '포카칩 오리지널', to_date('20230120', 'yyyymmdd'), 136.70, 2500);

select * from dec20_snack;

drop table dec20_snack cascade constraint purge;



insert into dec20_snack values(dec20_snack_sequence.nextval, '씨리얼', to_date('20221224', 'yyyymmdd'), 25.60, 1200);
insert into dec20_snack values(dec20_snack_sequence.nextval, '버터맛 팝콘', to_date('20230110', 'yyyymmdd'), 63.94, 1500);
insert into dec20_snack values(dec20_snack_sequence.nextval, '오븐에 구운 도넛', to_date('20230110 오후 02:00', 'yyyymmdd am hh:mi'), 150.94, 3000);
insert into dec20_snack values(dec20_snack_sequence.nextval, '오븐에 구운 호떡', to_date('20230110 14:00', 'yyyymmdd hh24:mi'), 100.24, 3000);







































