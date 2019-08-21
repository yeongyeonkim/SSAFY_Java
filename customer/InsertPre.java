package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertPre {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		//insert into customer values(2, 'jane', 'la')
		String query = "insert into customer values(" + args[0] + ", '" + args[1] + "', '" + args[2] + "')";
		//                                                         , ' 와 같은게 애초에 문장에 있었으니 넣어주어야 함.
//		System.out.println(query);
		
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
			Statement stat = con.createStatement();
			
			//4. Query 실행
			int rs = stat.executeUpdate(query);//insert
			System.out.println(rs + "개의 레코드 추가!");
			
			//5. 마무리
			stat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
