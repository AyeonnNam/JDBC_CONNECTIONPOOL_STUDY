package com.ayeon.JdbcTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionTest {
		
	
	static final String URL = "jdbc:mysql://localhost:3306/legacyProject?serverTimezone=Asia/Seoul";
	static final String ID = "root";
	static final String PW = "mysql";
	
	
	@Test
		public void driverManager() throws SQLException {
		
		Connection con1 = DriverManager.getConnection(URL,ID, PW);
		log.info("connection ={}, class={}", con1, con1.getClass());
		
		
	}
}
