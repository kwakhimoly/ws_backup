-- update
-- 		update 테이블명
--		set 필드명=값, 필드명=값 ... (바꿀 내용 넣기) => 여기까지만 쓰면 테이블 전체가 다 바뀜
--		where 조건식;


	--나이키가 1층으로 이전
update DEC21_STORE set s_floor = 1 where s_name = '나이키';
update DEC21_STORE set s_name = '다이소' where s_name = '다이소마리오아울렛점';

	--다이소 있는 건물이 345번지로 이전
update DEC21_BUILDING set b_location = '345번지' where b_name = (select s_place from DEC21_STORE where s_name = '다이소');

select * from DEC21_md;
select * from DEC21_store;
select * from DEC21_BUILDING;

	--나이키 상품 10% 할인
update DEC21_MD set m_price = m_price*(1-0.1) where m_store = '나이키';
-- *= 같은 연산자는 안 써짐

	--345번지 상품 반값
update DEC21_MD set m_price = m_price*2 
where m_store in (select s_name from DEC21_STORE 
where s_place in (select b_name from DEC21_BUILDING where b_location = '345번지'));
--> 실패 가 아니라 오류..

update DEC21_MD set m_price = m_price/2 
where m_store in (
	select s_name
	from DEC21_STORE
	where s_place in (
		select b_name
		from DEC21_BUILDING
		where b_location like '345%'
	)
);

-- delete
--		delete from 테이블명
--		where 조건식;

	--엔젤리너스 상품 삭제
delete from DEC21_md where m_store ='엔젤리너스';

	--최저가 상품 삭제
delete from DEC21_MD where m_price = (select min(m_price) from DEC21_MD);

	--엔젤리너스 철수
delete from DEC21_STORE where s_name = '엔젤리너스';


	--김밥천국 강남 폐업
delete from DEC20_MENU where m_r_no = (select r_no from DEC20_RESTAURANT where r_name ='김밥천국' and r_place ='강남');
delete from DEC20_OPERATE where o_restaurantno = (select r_no from DEC20_RESTAURANT where r_name = '김밥천국' and r_place = '강남');
delete from DEC20_RESTAURANT where r_name = '김밥천국' and r_place ='강남';




