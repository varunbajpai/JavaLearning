package com.luv2code.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class jdbc_connection_test {
	
	
	public static void create(SessionFactory factory, String first_Name, String second_Name, String email) {
		Session session = factory.getCurrentSession();
		try {
			Student tempStudent = new Student(first_Name, second_Name, email);
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
		}finally {
			System.out.println("Create into database");
		}
	}
	
	
	public static void read_based_on_primarykey(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student myStudent = session.get(Student.class, id);
			session.getTransaction().commit();
			System.out.println(myStudent);
		}finally {
			System.out.println("Reading based on Primary Key");
		}
	}
	
	
	public static void run_query(SessionFactory factory, String Query) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List <Student> theStudents = session.createQuery(Query).getResultList();
			session.getTransaction().commit();
			System.out.println(theStudents);
		}finally {
			System.out.println("Runninng a read Query on Database");
		}
	}
	
	public static void update_basedOn_query(SessionFactory factory, String Query) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.createQuery(Query).executeUpdate();
			session.getTransaction().commit();
		}finally {
			System.out.println("running an update Query on the database");
		}
	}

	
	public static void delete_basedOn_query(SessionFactory factory, String Query) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.createQuery(Query).executeUpdate();
			session.getTransaction().commit();
		}finally {
			System.out.println("running a delete Query on the database");
		}
	}
	
	
	public static void update_basedOn_primary_key(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student myStudent = session.get(Student.class, id);
			myStudent.setFirst_name("Deandra");
			session.getTransaction().commit();
		}finally {
			System.out.println("Update based on primary key");
		}
	}
	
	
	public static void delete_basedOn_primary_key(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student myStudent = session.get(Student.class, id);
			session.delete(myStudent);
			session.getTransaction().commit();
		}finally {
			System.out.println("Delete by primary key is run");
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();		
		create(factory,"frank","reynolds","frank@gmail.com");
		read_based_on_primarykey(factory, 17);
		run_query(factory,"from Student s where s.last_name = 'Reynolds'");
		update_basedOn_primary_key(factory, 10);
		update_basedOn_query(factory, "update Student set email = 'foo@gmail.com'");
		delete_basedOn_primary_key(factory,10);
		delete_basedOn_query(factory, "delete from Student where id=7");
		factory.close();
	}
}
