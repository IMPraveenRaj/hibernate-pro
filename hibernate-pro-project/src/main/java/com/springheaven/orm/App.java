package com.springheaven.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.springheaven.orm.entity.Song;

/**
 * Hello world!
 *
 */
public class App 
{
	
	//initialize the session object to store the Java Object (Entity) to build the session 
	//we use the session factory
	Session session = null;
	
	
	
	
	
	public  void saveSong(Song song) {
		//create the session factory 		
		//to create the session factory we need to setup a  data source just keep things in the mind		
		//we load this data source from the configuration which contains
		//all the properties to build the data source
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Song.class);
		SessionFactory sessionFactory= configuration.buildSessionFactory(); //session factory is long lived
		System.out.println("Song saved");
		
		//after setting up the session factory we need to initialize the session and it short lived 
		session= sessionFactory.openSession();		
		Transaction transaction = session.beginTransaction();
		session.save(song);
		transaction.commit();
	         
		//System.out.println(song.hashCode());
	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Song song = new Song();
        //song.setId(1);	
        song.setSongName("Om Namshivaya");
        song.setArtist("Om");
        //System.out.println(song.hashCode());
        new App().saveSong(song);
        
    }
}
