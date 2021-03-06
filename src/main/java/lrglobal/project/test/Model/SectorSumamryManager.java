package lrglobal.project.test.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SectorSumamryManager {
	
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
 
    public void Insert() {
        // code to save a Data
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	try{
    		/*
    		 * create a query for calling database procedure by its name. after calling the procedure it will need to execute 
    		 * thats why executeUpdate called
    		 */
    		Query query=session.createStoredProcedureCall("insert_sector_summary");
    		query.executeUpdate();
    				
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void topBuySellValuesSector(){
    	Session session= sessionfactory.openSession();
    	session.beginTransaction();
    	
    	/*
    	 * query for extracting top 10 sell values from the sector summary table
    	 */
    	Query query=session.getNamedQuery("top_netbuysell_sectorsummary");
    	// returned list value from the table 
    	List<SectorSummary> rsult= query.getResultList();
    	//write the resulted list into a text file
    	File fileName= new File("generate_files\\top_Sector_NetValues.txt");
    	try{
    		FileWriter fw=new FileWriter(fileName);
    		BufferedWriter output=new BufferedWriter(fw);
    		
    		for(int i=0;i<rsult.size();i++){
    			//line by line write
    			output.write(rsult.get(i).toString());
    			output.newLine();
    			output.newLine();
    		}
    		output.close();
    	}catch(Exception e){
    		System.out.println("The Given Exception is: "+e);
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
