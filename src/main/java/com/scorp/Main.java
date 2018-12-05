package com.scorp;

import org.hibernate.Session;

import com.scorp.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutdown();
		
	}

}
