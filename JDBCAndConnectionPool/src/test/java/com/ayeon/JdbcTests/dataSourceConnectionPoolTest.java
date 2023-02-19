package com.ayeon.JdbcTests;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class dataSourceConnectionPoolTest {

	static final String URL = "jdbc:mysql://localhost:3306/legacyProject?serverTimezone=Asia/Seoul";
	static final String ID = "root";
	static final String PW = "mysql";
	static final String driver = "com.mysql.cj.jdbc.Driver";

	
	//dataSouce-connectionPool 사용하기 
	private void useDataSource(DataSource dataSource) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		log.info("======= connection = {}, class= {}", conn, conn.getClass());
		
	}
	
	@Test
	public void dataSourceConnectionPool() throws SQLException, InterruptedException {
		
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(URL);
		dataSource.setUsername(ID);
		dataSource.setPassword(PW);
		dataSource.setPoolName("myPool");
		dataSource.setMaximumPoolSize(5);
		

		useDataSource(dataSource);
		
		Thread.sleep(1000);
		
		
	}
	
	
}
