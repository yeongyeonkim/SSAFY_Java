package com.tier3;

import java.util.ArrayList;

//dao가 구현해야 하는 메소드 목록
public interface ICustomerDAO {
	ArrayList<Customer> selectAll(); // 테이블 안의 모든 레코드 검색
	Customer selectOne(String num); // num 기준으로 레코드 검색
	int insert(Customer c); // 새 레코드 추가 
	int delete(String num); //num 기준으로 레코드 삭제
	int update(String num, String address);//num 기준으로 이름 수정
	ArrayList<Customer> findByAddress(String address);//주소기준 검색	
}
