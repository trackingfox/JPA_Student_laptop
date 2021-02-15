package com.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.model.Laptop;
import com.model.Student;

public class App {

	@Test
	public void Student_laptop_App() {

		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		Student s = new Student();
		s.setName("Sharif");
		s.setRollno(1);
		s.setMarks(50);
		s.setLaptop(laptop);

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

		em.persist(laptop);
		em.persist(s);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
