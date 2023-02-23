package com.ayeon.JdbcTests;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ayeon.myjdbc.DBConnection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class dataSourceTest {

	@Setter(onMethod_ = @Autowired )
	private DataSource dataSource;
	
	
	@Setter(onMethod_ = @Autowired )
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void dataSourceConnectionPool() throws SQLException, InterruptedException {
		
	
		
		try {
			Connection conn = dataSource.getConnection();
					log.info("-- conn: " +conn);
					
					//Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	@Test
	public void testMyBatis () {
		
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		log.info("======Session ======= :" + session);
		log.info("======conn ========= :" + conn);
		
		
	}
	
	
	
	
	
}
