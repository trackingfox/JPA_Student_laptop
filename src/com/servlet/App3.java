package com.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.model.Laptop3;
import com.model.Student3;

public class App3 {

	@Test
	public void Student_laptop_App() {

		Laptop3 laptop = new Laptop3();
		laptop.setLid(101);
		laptop.setLname("Dell 3");

		Student3 s = new Student3();
		s.setName("Sharif 3");
		s.setRollno(1);
		s.setMarks(50);
		s.getLaptop().add(laptop);

		laptop.getStudent().add(s);

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
