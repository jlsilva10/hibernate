package com.scorp;

import java.util.Date;

import javax.persistence.Query;

import org.hibernate.Session;

import com.scorp.entities.Contact;
import com.scorp.entities.PhoneBook;
import com.scorp.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		PhoneBook p = new PhoneBook();
				
		Contact c = new Contact();
		c.setAge(25);
		c.setCreationDate(new Date());
		c.setUpdatingDate(new Date());
		c.setName("Toni");
		c.setPhoneNumber(999999999);
		c.setPhonebook(p);
		
		session.persist(p);		
		session.persist(c);
		
		PhoneBook p2 = (PhoneBook) session.get(PhoneBook.class, 1);
		
		Query query = session.createQuery("from Contact a where name = 'Toni' ");
		
		Contact c2 = (Contact) query.getSingleResult();
		
		c2.setPhonebook(p2);
		
		session.saveOrUpdate(c2);
		
		
		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutdown();
		
	}

}
