package au.limepoint.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import au.limepoint.service.impl.LoginManagerImpl;

@Component
public class SpringFrameworkTest {
	@Autowired
	LoginManagerImpl login;
	
	private void validate(){
		if (!login.validateUser("marwin", "password"))
			System.out.println("Not logged in");
		else
			System.out.println("Logged in");
		
	}
	

	public static void main (String [] args){
		 ApplicationContext context = 
	            new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext-manager.xml"});

		SpringFrameworkTest p = context.getBean(SpringFrameworkTest.class);
		p.validate();
	}
}
