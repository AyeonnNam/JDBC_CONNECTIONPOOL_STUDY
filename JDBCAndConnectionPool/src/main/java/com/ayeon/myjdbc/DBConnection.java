package com.ayeon.myjdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DBConnection {

	@Setter(onMethod_ = @Autowired )
	private DataSource dataSource;
	private Connection conn;
	private Statement stmt;
	
	
	public DBConnection() throws SQLException {
		
			
		try {
			conn = dataSource.getConnection();
			
			log.info("================= conn ====== : " +conn);
		} catch (Exception e) {
			log.info("================= 실 ====== : " + e.getMessage());
		}
	}
}
