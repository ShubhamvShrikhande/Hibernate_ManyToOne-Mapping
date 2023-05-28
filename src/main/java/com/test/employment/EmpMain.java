package com.test.employment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpMain {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setFirstName("ram");
		employee.setLastName("patil");
		employee.setEmail("ram@gmail.com");
		
		Employee employee1 = new Employee();
		employee1.setFirstName("virat");
		employee1.setLastName("mane");
		employee1.setEmail("virat@gmail.com");
		
		Address address = new Address();
		address.setCity("pune");
		address.setCountry("india");
		address.setState("maharastra");
		address.setPinCode("4567");
		
		employee.setAddress(address);
		employee1.setAddress(address);
		
		session.save(employee);
		session.save(employee1);
		transaction.commit();
		session.close();
		sessionfactory.close();
	}

}
