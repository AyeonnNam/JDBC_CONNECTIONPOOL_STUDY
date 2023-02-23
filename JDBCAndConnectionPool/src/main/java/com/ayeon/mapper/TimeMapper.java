package com.ayeon.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	
	
	@Select("SELECT now() from dual")
	public String getTime();
}
