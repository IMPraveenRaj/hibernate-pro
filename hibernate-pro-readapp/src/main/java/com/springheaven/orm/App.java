package com.springheaven.orm;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.springheaven.orm.entity.Song;
import com.springheaven.orm.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
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
		//create the session factory 		
		//to create the session factory we need to setup a  data source just keep things in the mind		
		//we load this data source from the configuration which contains
		//all the properties to build the data source
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Song.class);
		SessionFactory sessionFactory= configuration.buildSessionFactory(); //session factory is long lived
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
		/*
		 * Configuration configuration = new Configuration(); configuration.configure();
		 * configuration.addAnnotatedClass(Song.class); SessionFactory sessionFactory=
		 * configuration.buildSessionFactory();
		 */ //session factory is long lived
		SessionFactory sessionFactory= HibernateUtils.getsessionFactory();
		System.out.println("Querying the song");
		
		//after setting up the session factory we need to initialize the session and it short lived
		if(session==null) {
		session= sessionFactory.openSession();		
		Transaction transaction = session.beginTransaction();
		Song song=session.load(Song.class, id);
		transaction.commit();
		return song;
		}
		
		return new Song();
	     
		//System.out.println(song.hashCode());
	}
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the song you want to retrieve");
        int id = scan.nextInt();
        //System.out.println(song.hashCode());
        Song song=new App().retreiveSong_get(id);
        Song song1=new App().retreiveSong_usingLoad(id);
        System.out.println(song);
        System.out.println(song1);
        
    }
}
