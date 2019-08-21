package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAll {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		String query = "select num, name, address from customer order by num";
		
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
			Statement stat = con.createStatement();
			System.out.println(stat);
			
			//4. Query 실행
			ResultSet rs = stat.executeQuery(query);//select
			
			rs.last();
			System.out.println(rs.getString(1) + "--" + rs.getString(2));
			System.out.println("-------------------");
			
//			rs.first(); //  last나 first는 rs의 위치를 정해주는 것. 하지만
			rs.beforeFirst(); // first는 1번이고 아래 while을 가면 2부터출력하니까 문제가 생김. (rs 위치 원상 복구)
			// afterlast()도 있음.
			
			//5. 결과처리
			while(rs.next()) { // re.next() == boolean 가리킨 레코드에 데이터가 있는지.
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				
				System.out.println(num + "--" + name + "--" + address);
			}
			System.out.println("-------------------");
			
			rs.previous(); //한 행 위로
			System.out.println(rs.getString(1) + "--" + rs.getString(2));
			System.out.println("-------------------");
			
			rs.first(); //
			System.out.println(rs.getString(1) + "--" + rs.getString(2));
			System.out.println("-------------------");
			
			rs.absolute(3); // 3
			System.out.println(rs.getString(1) + "--" + rs.getString(2));
			System.out.println("-------------------");
			
			
			//6. 마무리
			rs.close();
			stat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
