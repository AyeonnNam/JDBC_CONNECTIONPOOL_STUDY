package com.ayeon.JdbcTests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ayeon.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class timeMapperTest {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	
	@Test
	public void timeMapperTest() {
		
		
		log.info("timeMapper : "+timeMapper.getTime());
		log.info("------------------" +timeMapper.getClass());
	}
	
	@Test
	public void timeMapperWithXmlTest() {
		
		try {

			log.info("getTime2");
			//log.info("timeMapper02 : "+timeMapper.getTime02());
			log.info("timeMapper02 : " + timeMapper.getTime2());
				
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
