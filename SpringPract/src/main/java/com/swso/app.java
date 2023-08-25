package com.swso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {

	public static void main(String[] args) {
		ApplicationContext apcon=new ClassPathXmlApplicationContext("st.xml");
		student st=apcon.getBean("student1",student.class);
		System.out.println(st);
		
	}

}
