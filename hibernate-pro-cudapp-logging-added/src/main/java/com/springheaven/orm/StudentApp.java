package com.springheaven.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springheaven.orm.entity.Address;
import com.springheaven.orm.entity.Song;
import com.springheaven.orm.entity.Student;
import com.springheaven.orm.utils.HibernateUtils;


public class StudentApp 
{

	//initialize the session object to store the Java Object (Entity) to build the session 
	//we use the session factory
	Session session = null;

	static {
		System.out.println("i am invoked");
	}

	{
		System.out.println("i am invoked in instance");
	}


	public  Song retreiveSong_get(int id) {
		SessionFactory sessionFactory = HibernateUtils.getsessionFactory();
		System.out.println("Querying the song");

		//after setting up the session factory we need to initialize the session and it short lived 
		session= sessionFactory.openSession();		
		Transaction transaction = session.beginTransaction();
		Song song=session.get(Song.class, id);
		transaction.commit();
		return song;
		//System.out.println(song.hashCode());
	}


	public  Song retreiveSong_usingLoad(int id) {
		//create the session factory 		
		//to create the session factory we need to setup a  data source just keep things in the mind		
		//we load this data source from the configuration which contains
		//all the properties to build the data source
		SessionFactory sessionFactory = HibernateUtils.getsessionFactory(); //session factory is long lived
		System.out.println("Querying the song");

		//after setting up the session factory we need to initialize the session and it short lived 
		session= sessionFactory.openSession();		
		Transaction transaction = session.beginTransaction();
		Song song=session.load(Song.class, id);
		transaction.commit();
		return song;
		//System.out.println(song.hashCode());
	}





	public static void main( String[] args )
	{
		SessionFactory sessionFactory=HibernateUtils.getsessionFactory();
		Session session = sessionFactory.openSession();  
		session.beginTransaction();

		Address address= new Address();
		address.setAddressLine1("33 BlaasBalgStraat");
		address.setAddressLine2("Mechelen ");
		address.setCity("brussels");
		address.setCountry("belgium");                    
		Student student= new Student();
		student.setFirstName("PraveenRaj");
		student.setLastName("MohanRaj");
		student.setEmail("impraveen13@gmail.com");          
		student.setHomeaddress(address);
		student.setHostelAddress(address);
		session.save(student);
		session.getTransaction().commit();
		session.close();

	}
}
