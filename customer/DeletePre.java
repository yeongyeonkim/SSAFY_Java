package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePre {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		String query = "delete from customer where num = ?";
		
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
//			Statement stat = con.createStatement();
			PreparedStatement pstat = con.prepareStatement(query);
			
			//3-1. ?로?
			pstat.setString(1, args[0]);
			
			//4. Query 실행
			int rs = pstat.executeUpdate();//insert
			System.out.println(rs + "개의 레코드 삭제!");
			
			//5. 마무리
			pstat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
