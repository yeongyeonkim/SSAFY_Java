package com.tier3;

import java.util.ArrayList;

//client program(dao를 이용하는 객체)
public class CustomerTest {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		ArrayList<Customer> list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c);
		}

		// select one
		// Customer selectOne(String num)
		System.out.println("------------1-----------");
		System.out.println("한개의 요소만 출력 :" + dao.selectOne("411"));

		// insert
		System.out.println("-----------2------------");
		Customer c1 = new Customer("125", "yeongyeon", "seoul");
		dao.insert(c1);
		list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c);
		}
		
		//delete
		System.out.println("------------3-----------");
		dao.delete("123");
		list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c);
		}
		
		//update
		System.out.println("-------------4----------");
		dao.update("125", "Daejeon");
		list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c);
		}
		
		//public ArrayList<Customer> findByAddress(String address) {
		System.out.println("-------------5----------");
		ArrayList<Customer> arr1 = dao.findByAddress("seoul");
		for (Customer c : arr1) {
			System.out.println(c);
		}
		
	}

}
