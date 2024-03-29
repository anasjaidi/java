package love.code.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import love.code.hibernate.entity.Student;


/**
 * alter table hb_student_tracker.student AUTO_INCREMENT=300
 * 
 * */

/**
 * truncate hb_student_tracker.student
 * 
 * TRUNCATE is a SQL command that is used to remove all rows from a table,
 * in a database. When you execute the TRUNCATE command on a table,
 * it deletes all the data in the table and resets any auto-incrementing IDs or sequences.
 * */
public class ReadStudent {

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
			 * create a transaction
			 * */
				
				session.beginTransaction();
				
			/**
			 * query the students
			 * */
				
				List<Student> myStudentsList = session.createQuery("from Student").getResultList();
				
				
			/**
			 * 
			 * Print results
			 * */
				
				for (Student myStudent : myStudentsList) {
					System.out.println(myStudent);
					
				}
			
			/**
			 * commit the transaction
			 * */
				session.getTransaction().commit();
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
