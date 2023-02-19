package com.ayeon.JdbcTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class dataSourceTest {

	static final String URL = "jdbc:mysql://localhost:3306/legacyProject?serverTimezone=Asia/Seoul";
	static final String ID = "root";
	static final String PW = "mysql";
//	static final String driver = "com.mysql.cj.jdbc.Driver";
//	@Setter(onMethod_ = @Autowired )
//	DataSource dataSource;
	
	private void useDataSource(DataSource source) throws SQLException {
		
			Connection conn1 = source.getConnection();
			
			Connection conn2 = source.getConnection();
			log.info("connection ={}, class={}", conn1, conn1.getClass());
			log.info("connection = {}, class= {}", conn2, conn2.getClass());
			
	}
	
	@Test
	public void dataSourceConnectionPool01() throws SQLException, InterruptedException {
		
			HikariDataSource source = new HikariDataSource();
			
			source.setJdbcUrl(URL);
			source.setUsername(ID);
			source.setPassword(PW);
			source.setMaximumPoolSize(10);
			source.setPoolName("myPool");
			useDataSource(source);
			Thread.sleep(1000);
		
		
		
	}
	
	
	
	
//	@Test
//	public void dataSourceConnectionPool() throws SQLException, InterruptedException {
//		
//	
//		
//		try {
//			Connection conn =dataSource.getConnection();
//					log.info("------------------------conn: --------------------- " +conn);
//					
//					Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}		
//	}
	
}
