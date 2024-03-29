package love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import love.code.hibernate.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {
		

		/**
		 * start session factory
		 * */
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		/**
		 * create session
		 * */
		
		Session session = factory.getCurrentSession();
		
		
		try {
			/**
			 * Create a student object 
			 * */
			
				Student student = new Student("anas", "jaidi", "anas.jaidi@icloud.com");
			
			/**
			 * create a transaction
			 * */
				
				session.beginTransaction();
			
			/**
			 * save the student object
			 * */
				
				session.save(student);
			
			/**
			 * commit the transaction
			 * */
				session.getTransaction().commit();
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
