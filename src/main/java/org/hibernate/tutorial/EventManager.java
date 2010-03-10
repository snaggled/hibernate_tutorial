package org.hibernate.tutorial; 

import org.hibernate.*; 
import java.util.*; 
import org.hibernate.tutorial.domain.*; 
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager 
{ 
	public static void main(String[] args) 
	{ 
        EventManager mgr = new EventManager(); 
        if (args[0].equals("store")) 
		{   
			for (int i = 0; i < 10000; i++)
            	mgr.createAndStoreEvent("My Event" + i, new Date()); 
        }  
	 	else if (args[0].equals("list")) 
		{ 
	        List events = mgr.listEvents(); 
	        for (int i = 0; i < events.size(); i++) 
			{ 
	        	Event theEvent = (Event) events.get(i); 
	            System.out.println("Event: " + theEvent.getTitle() + " Time: " 
					+ theEvent.getDate()); 
	        }   
		
			List people = mgr.listPeople();
			for (Iterator<Person> it = people.iterator(); it.hasNext();)
			{   
				Person p = it.next();
	            System.out.println("Person: " + p.getFirstName() + " " 
					+ p.getLastName() + ", age: " + p.getAge()); 			
			}
        }
        HibernateUtil.getSessionFactory().close(); 
    }                     

	private List listEvents()
	{
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
        session.beginTransaction(); 
        List result = session.createQuery("from Event").list(); 
        session.getTransaction().commit(); 
        return result; 
	}     
	
	private List listPeople()
	{
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
        session.beginTransaction(); 
        List result = session.createQuery("from Person").list(); 
        session.getTransaction().commit(); 
        return result;	
	}
	
	private void createAndStoreEvent(String title, Date theDate) 
	{                                                   
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	    session.beginTransaction(); 

	    Event theEvent = new Event(); 
	    theEvent.setTitle(title); 
	    theEvent.setDate(theDate); 
	    session.save(theEvent); 
	
	    Person p = new Person(); 
	    p.setAge(35);
	 	p.setFirstName("Philip");
	    p.setLastName("Mcmahon"); 
	    session.save(p);
	
	    session.getTransaction().commit(); 
	} 
} 

