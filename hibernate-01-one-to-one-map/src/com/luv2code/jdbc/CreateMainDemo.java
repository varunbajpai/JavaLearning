package com.luv2code.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateMainDemo {
	public static void create(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		try {			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Guitar");		
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			session.save(tempInstructor);					
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Created Cascaded Entry");
		}
	}
	
	
	public static void delete(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		try {	
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class,3);			//Get instructor with primary key set = 3 in this case
			session.delete(tempInstructor);											//Will delete in both the tables as cascade is set to ALL
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Created Cascaded Entry");
		}
	}
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		create(factory);
//		delete(factory);
		factory.close();
	}
}