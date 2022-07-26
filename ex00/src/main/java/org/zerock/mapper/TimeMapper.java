package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//               NoticeDao.java 인터페이스
public interface TimeMapper {
   
   @Select("SELECT sysdate FROM dual")
   public String getTime();
   
   
   public String getTimeXML(); // TimeMapper.xml 연동

}