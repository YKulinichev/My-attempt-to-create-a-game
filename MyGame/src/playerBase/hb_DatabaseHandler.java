package playerBase;

import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class hb_DatabaseHandler {
Connection dbConnetion;

//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
				

		//Create session
		Session session = factory.getCurrentSession();

		public void signUpUser() {
	
			try {
		
	
		User tempUser = new User();
		
	//2.start a transaction
	session.beginTransaction();
	
	//3.save the student
	System.out.println("saving the student...");
	session.save(tempUser);
	
	//4.commit transaction
	session.getTransaction().commit();
	System.out.println("Done!");
			} 
			
		finally {
	factory.close();
	}

	

}}
	
	


