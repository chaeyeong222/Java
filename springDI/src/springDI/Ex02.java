package springDI;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.RecordImpl;
import di.RecordViewImpl;

public class Ex02 {

	public static void main(String[] args) {
		//ex01은 스프링x
		//ex02 + 스프링 주요 모듈을 사용해서 REcordViewImpl 객체 생성해서
		//성적입력 출력하는 코딩을 하겟다
		//RecordViewImpl 와 RecordImpl은 의존관계가 있다.


		/*
		 1. 스프링 주요 모듈(jar) 추가
		   1) 메이븐(빌드도구)사용하면 pom.xml <dependency></dependency>
		   2) 라이브러리에 jar 파일 추가
		     Reference Libraries 폴더 생성 + 스프링의 주요 모듈 jar 파일 모두 추가   
		 */
		//한 학생의 성적정보(,국영수)를 입력받고, 출력하는 코딩
		/*
		 * RecordImpl record = new RecordImpl(); 
		 * RecordViewImpl rvi = new RecordViewImpl(); 
		 * rvi.setRecord(record);
		 * 
		 * rvi.input();//학생정보 입력 
		 * rvi.output();//학생정보 출력
		 */
		/*C:\spring-framework-3.0.2.RELEASE-with-docs\
		 * spring-framework-3.0.2.RELEASE
		 * \docs
		 * \spring-framework-reference
		 * \htmlsingle
		 * \spring-framework-reference.html*/
		//스프링 컨테이너 == IOC 컨테이너  : [스프링 객체 == 스프링 빈] 생성, 관리
		
		//C:\spring-framework-3.0.2.RELEASE-dependencies\org.apache.commons\com.springsource.org.apache.commons.logging\1.1.1
		String resourceLocation ="applicationContext.xml";
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(resourceLocation);
		
		
        RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi");
        rvi.input();
        rvi.output();
        
		System.out.println("END");
		 
   /*문제 -> 스프링 주요 모듈을 추가해서 각 코딩이 무엇을 의미하는지?
    * chapter01,02,06 읽고오기*/

	}
}
