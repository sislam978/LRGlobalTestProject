package lrglobal.project.test.Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import lrglobal.project.test.LRGlobalTestProject.ReadDataFromCSV;

public class HedgeFundManager {
	
	public SessionFactory sessionfactory;
	
	public void setup(){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
		        .build();
		try {
			sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
		    StandardServiceRegistryBuilder.destroy(registry);
		    throw new RuntimeException(ex);
		}
	}
	
 
    public void exit() {
        // code to close Hibernate Session factory
    	sessionfactory.close();
    	
    	
    }
 
    public void create() {
        // code to save a Data
    	// Before that I have to Read an excel file and take the inputs from the csvfile.
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	ReadDataFromCSV readCSV=new ReadDataFromCSV();
    	String fileName="HedgeFund.csv";
    	ArrayList<HedgeFund> rr=new ArrayList<HedgeFund>();
    	rr=readCSV.getAllData(fileName);
    	int listSize=rr.size();
    	for(int i=0;i<rr.size();i++){
    		HedgeFund hh=rr.get(i);
    		session.save(hh);
    	}
    	
    	session.getTransaction().commit();
    	session.close();
    }
 
    public void read() {
        // code to get a Data
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	
    	session.getTransaction().commit();
    	session.close();
    }
 
    public void update() {
        // code to modify a Data
    	
    	
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	
    	
    	
    	session.getTransaction().commit();
    	session.close();
    }
 
    public void delete() {
        // code to remove a Data
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	
    	session.getTransaction().commit();
    	session.close();
    }

}
