package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDdbcMySQL2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		//jdbc url
		//jdbc:protocol 이름 / mysql:db / localhost:db server 주소 / 3306:port / scott:schema 이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		//부서번호 50이상인 레코드 중에서 사번, 이름, 부서코드 출력
		String query = "select empid, fname, deptid from emp where empid >= 50 order by empid";
		
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
			Statement stat = con.createStatement();
			
			//4. Query 실행
			ResultSet rs = stat.executeQuery(query);//select
			
			//5. 결과처리
			while(rs.next()) { // re.next() == boolean 가리킨 레코드에 데이터가 있는지.
				String empid = rs.getString(1);
				String fname = rs.getString(2);
				String deptid = rs.getString(3);
				
				System.out.println(empid + "--" + fname + "--" + deptid);
			}
			
			//6. 마무리
			rs.close();
			stat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
