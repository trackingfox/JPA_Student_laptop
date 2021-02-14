package com.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.model.Laptop2;
import com.model.Student2;

public class App2 {

	@Test
	public void Student_laptop_App() {

		Laptop2 laptop = new Laptop2();
		laptop.setLid(101);
		laptop.setLname("Dell 2");

		Student2 s = new Student2();
		s.setName("Sharif 2");
		s.setRollno(1);
		s.setMarks(50);
		s.getLaptop().add(laptop);

//			SessionFactory sessionFactory = null;
//			// configures settings from hibernate.cfg.xml
//			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//			try {
//				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//			} catch (Exception ex) {
//				System.out.println(ex.toString()); // If error display in console
//				StandardServiceRegistryBuilder.destroy(registry);
//			}
//			Session session = sessionFactory.openSession();
//			session.beginTransaction();
//			List<Student> studentlist = this.csvToclass();
//			studentlist.forEach(x -> session.save(x));
//			session.getTransaction().commit();
//			session.close();

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Student_laptop");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

//			List<Customer> custlist1 = this.CustomerDetals();
//			custlist1.forEach(x -> em.persist(x));
//			custlist1.forEach(x -> em.merge(x));

		em.merge(laptop);
		em.merge(s);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
