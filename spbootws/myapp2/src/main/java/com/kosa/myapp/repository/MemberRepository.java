package com.kosa.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kosa.myapp.domain.MemberDto;

//Long -  primary key 데이터 타입 
public interface MemberRepository extends JpaRepository<MemberDto, Long>{
	@Query("select s from MemberDto s where s.user_id = :user_id")
	MemberDto searchByUser_id(@Param("user_id")String user_id);
}
