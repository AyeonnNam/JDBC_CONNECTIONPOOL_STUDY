package com.ayeon.JdbcTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ayeon.myjdbc.MemberDao;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class connectionTest {

	static final String URL = "jdbc:mysql://localhost:3306/legacyProject?serverTimezone=Asia/Seoul";
	static final String ID = "root";
	static final String PW = "mysql";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	
	@Setter(onMethod_ = @Autowired)
	DataSource dataSource;

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

	// DriverManager를 이용한 Connection 얻기
	@Test
	public void driverManager() throws SQLException {

		Connection con1 = DriverManager.getConnection(URL, ID, PW);
		log.info("connection ={}, class={}", con1, con1.getClass());
		Connection con2 = DriverManager.getConnection(URL, ID, PW);
		log.info("connection = {}, class= {}", con2, con2.getClass());

	}

	/*
	 * 스프링이 제공하는 DataSource를 확장한 DriverManagerDataSource는 spring-jdbc 라이브러리추가하면 사용가능
	 */
	// 역시 항상 새로운 커넥션을 획득한다.
	// DriverManager()와는 달리 굳이 매번 getConnection()할떄마다 파라미터로 url, username, password를 넘겨주지 않아도 된다.
	@Test
	public void dataSourceDriverManager() throws Exception {

		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, ID, PW);
		
		useDataSource(dataSource);

	}

	void useDataSource(DataSource dataSource) throws SQLException {
		Connection con1 = dataSource.getConnection();
		Connection con2 = dataSource.getConnection();
		log.info("connection ={}, class={}", con1, con1.getClass());
		log.info("connection = {}, class= {}", con2, con2.getClass());

	}
	
//	@Test
//	public void memberdaoTest()throws SQLException {
//		
//		MemberDao memberDao = new MemberDao();
//		memberDao.createTable();
//		
//		
//	}
//	

}
