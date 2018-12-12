package com.scorp.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.scorp.entities.Contact;
import com.scorp.entities.Person;
import com.scorp.entities.PhoneBook;
import com.scorp.entities.Project;
import com.scorp.utils.HibernateUtil;

public class TestRelations {
	
	@BeforeClass
	public static void cleanTables() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Delete Maria from PhoneBook @OneToOne
		
		Query q = session.createQuery("from Person where name = :name ");
		q.setParameter("name", "Maria");
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		try {
		Person person = (Person) q.getSingleResult();
		
		
		CriteriaDelete<PhoneBook> cdp = cb.createCriteriaDelete(PhoneBook.class);
		
		Root<PhoneBook> r = cdp.from(PhoneBook.class);
		
		cdp.where(cb.equal(r.get("id"), person.getId()));
		
		session.createQuery(cdp).executeUpdate();
		
		//Delete Maria from Person @OneToOne
		
		cb = session.getCriteriaBuilder();
		
		CriteriaDelete<Person> cd = cb.createCriteriaDelete(Person.class);
		
		Root<Person> e = cd.from(Person.class);
		
		cd.where(cb.equal(e.get("name"), "Maria"));
		
		session.createQuery(cd).executeUpdate();
		
		}catch(NoResultException e){}
				
		//Delete all Projects from Project Table
		
		session.createNativeQuery("delete from Project").executeUpdate();
		
		//Delete all remaining
		
		session.createNamedQuery("deleteAllContacts").executeUpdate();
		
		session.createNamedQuery("deleteAllPhoneBook").executeUpdate();

		session.createNamedQuery("deleteAllPeople").executeUpdate();

		session.createNamedQuery("deleteAllProjects").executeUpdate();

				
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass
	public static void closeConnection() {
		HibernateUtil.shutdown();
	}
	
	
	@Test
	public void testOneToMany() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		PhoneBook p = new PhoneBook();
		
		Person po = new Person();
		p.setPerson(po);
		
		po.setName("José");
		po.setGender("M");
		po.setPhonebook(p);
				
		Contact c = new Contact();
		c.setAge(25);
		c.setCreationDate(new Date());
		c.setUpdatingDate(new Date());
		c.setName("Toni");
		c.setPhoneNumber(999999999);
		c.setPhonebook(p);
		
		
		
		PhoneBook p2 = new PhoneBook();
		
		po = new Person();
		
		po.setName("Marta");
		po.setGender("F");
		po.setPhonebook(p);
		
		p2.setPerson(po);
		
		session.persist(p);		
		session.persist(c);
		Query query = session.createQuery("from Contact a where name = 'Toni' ");
		
		Contact c2 = (Contact) query.getSingleResult();
		
		c2.setPhonebook(p2);
		
		session.persist(po);
		session.persist(p2);
		
		session.saveOrUpdate(c2);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testOneToOne() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();

		PhoneBook p = new PhoneBook();
		
		Person po = new Person();
		
		po.setName("João");
		po.setGender("M");
		po.setPhonebook(p);
		
		p.setPerson(po);
		
		
		session.persist(p);

		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testManyToMany() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Person po = new Person();
		
		po.setName("Maria");
		po.setGender("F");
		
		Set<Project> projects = new HashSet<Project>();
		Project p  = new Project();
		p.setTitle("Project Zero");
		
		Project p2  = new Project();
		p2.setTitle("Project One");
		
		projects.add(p);
		projects.add(p2);
		
		
		po.setProjects(projects);

		
		session.persist(po);
		

		session.getTransaction().commit();		
		session.close();
	}
}
