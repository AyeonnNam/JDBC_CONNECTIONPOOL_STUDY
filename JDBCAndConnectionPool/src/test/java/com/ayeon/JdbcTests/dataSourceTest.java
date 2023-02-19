package com.ayeon.JdbcTests;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class dataSourceTest {

	@Setter(onMethod_ = @Autowired )
	DataSource dataSource;
	
	
	
	
	@Test
	public void dataSourceConnectionPool() throws SQLException, InterruptedException {
		
	
		
		try {
			Connection conn =dataSource.getConnection();
					log.info("------------------------conn: --------------------- " +conn);
					
					//Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
}
