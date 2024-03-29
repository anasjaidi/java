package love.code;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
 
	public static void main(String[] args) {
		
		try (/**
				 * load the spring configuration
				 * */
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			/**
			 * retrieve bean from spring
			 * */
			Coach theCoach = ctx.getBean("MyCoach", Coach.class);
			
			
			/**
			 * call methods on the bean
			 * */
			System.out.println(theCoach.gdf());
			System.out.println(theCoach.cdf());
			System.out.println(theCoach.cdf());
			System.out.println(theCoach.cdf());
			
			/**
			 * clean the context
			 * */
			ctx.close();
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
