package com.ayeon.JdbcTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionTest {
		
	
	static final String URL = "jdbc:mysql://localhost:3306/legacyProject?serverTimezone=Asia/Seoul";
	static final String ID = "root";
	static final String PW = "mysql";
//	static final String driver = "com.mysql.cj.jdbc.Driver";
	
//	static {
//		
//		
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			log.info("로드 실패 : " + e.getMessage());
//		}
//		
//	}
//	
	//DriverManager를 이용한 Connection 얻기
	@Test
		public void driverManager() throws SQLException {
		
		Connection con1 = DriverManager.getConnection(URL,ID, PW);
		log.info("connection ={}, class={}", con1, con1.getClass());
		Connection con2 = DriverManager.getConnection(URL,ID, PW);
		log.info("connection = {}, class= {}", con2, con2.getClass());
		
	}
	
	
	
	/* 스프링이 제공하는 DataSource를 확장한 DriverManagerDataSource는 6.0.5 API에서 사용가능*/
	//역시 항상 새로운 커넥션을 획득한다.
	@Test
	public void dataSourceDriverManager() throws Exception {
		
	 
		
		/* DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, ID,PW);
		 * useDataSource(dataSource);
		 * */
		
		
	}
	
	
//	@Test
//	public void useDataSource(DataSource dataSource) throws SQLException {
//		Connection con1 = dataSource.getConnection();
//		Connection con2 = dataSource.getConnection();
//		log.info("connection ={}, class={}", con1, con1.getClass());
//		log.info("connection = {}, class= {}", con2, con2.getClass());
//
//	}
	
	
	
	
}
