package com.javahib.DemoHib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Alien a = null;
    	
    	/*Alien a = new Alien();
    	a.setAid(101);
    	a.setAname("Ambi");
    	a.setColor("RED");
    	
    	AlienName an = new AlienName();
    	an.setFname("Amruth");
    	an.setMname("ambi");
    	an.setLname("uppi");
    	
        Alien telusko = new Alien();
        telusko.setAid(333);
        telusko.setAname(an);
        telusko.setColor("white");*/
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        
        Session session1 =  sf.openSession();
        
        session1.beginTransaction();
        
        Query q1 = session1.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        a=(Alien)q1.uniqueResult();
        //a = (Alien) session1.get(Alien.class, 101);
        //session1.save(a);
        
        session1.getTransaction().commit();
        
       // tx.commit();
        System.out.println(a);
        session1.close();
        
        Session session2 =  sf.openSession();
        int x=100;
        session2.beginTransaction();
        Query q2 = session2.createQuery("select sum(aid) from Alien where aid > :x");
        q2.setParameter("x", x);
        q2.setCacheable(true);
        //List<Alien> list = q2.list();
        Long mar =(Long)q2.uniqueResult();
        //a = (Alien) session2.get(Alien.class, 101);
        //session1.save(a);
        
        session2.getTransaction().commit();
       // tx.commit();
        System.out.println(mar);
        session2.close();
    }
}
