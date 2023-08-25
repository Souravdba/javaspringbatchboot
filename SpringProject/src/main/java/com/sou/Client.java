package com.sou;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
	    ApplicationContext appcontext=new ClassPathXmlApplicationContext(new String[] {"bean.xml"});
		Employee emp1=appcontext.getBean("Employee1",Employee.class);
		System.out.println(emp1);
		ClassPathXmlApplicationContext con=(ClassPathXmlApplicationContext)appcontext;
		con.close();
		
	}

}
