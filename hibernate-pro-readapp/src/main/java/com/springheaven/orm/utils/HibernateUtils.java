package com.springheaven.orm.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springheaven.orm.entity.Song;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getsessionFactory() {
	
		try {
		if(sessionFactory==null) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Song.class);
		 sessionFactory= configuration.buildSessionFactory();
		}}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sessionFactory;
	}
	
}
