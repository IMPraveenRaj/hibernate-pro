package com.springheaven.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springheaven.orm.entity.Address;
import com.springheaven.orm.entity.NewStudent;
import com.springheaven.orm.entity.Phone;
import com.springheaven.orm.entity.Song;
import com.springheaven.orm.entity.Student;
import com.springheaven.orm.utils.HibernateUtils;

public class NewStudentApp {

	// initialize the session object to store the Java Object (Entity) to build the
	// session
	// we use the session factory
	Session session = null;

	static {
		System.out.println("i am invoked");
	}

	{
		System.out.println("i am invoked in instance");
	}

	public Song retreiveSong_get(int id) {
		SessionFactory sessionFactory = HibernateUtils.getsessionFactory();
		System.out.println("Querying the song");

		// after setting up the session factory we need to initialize the session and it
		// short lived
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Song song = session.get(Song.class, id);
		transaction.commit();
		return song;
		// System.out.println(song.hashCode());
		
	}



	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getsessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		NewStudent newStudent = new NewStudent();
		newStudent.setFirstName("PraveenRaj");
		newStudent.setLastName("MohanRaj");
		newStudent.setEmail("impraveen13@gmail.com");		
		newStudent.setAge(32);
		newStudent.setCountry("belgium");
		session.save(newStudent);
		
		System.out.println("fetching the newly saved Student--------->");
		NewStudent newStudent1 = session.get(NewStudent.class, 1);
		System.out.println("fetching the newly saved Student"+newStudent1);
		session.getTransaction().commit();
		session.close();

	}
}
