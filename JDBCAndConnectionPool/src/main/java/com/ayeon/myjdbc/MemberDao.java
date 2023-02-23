package com.ayeon.myjdbc;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberDao {

@Setter(onMethod_ = @Autowired)	
 DataSource dataSource;	

	public void createTable() throws SQLException {
		
		try {
			Connection conn = dataSource.getConnection();
			
			log.info("conn" + conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
