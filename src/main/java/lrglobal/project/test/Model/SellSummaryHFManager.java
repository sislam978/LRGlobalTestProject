package lrglobal.project.test.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

//import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import lrglobal.project.test.Model.HedgeFund;
import com.mysql.jdbc.Connection;

import lrglobal.project.test.LRGlobalTestProject.ReadDataFromCSV;

public class SellSummaryHFManager {
	
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
    		//Query  query= session.getNamedQuery("insert_hedge_sell_record");
    		//query.getResultList();
    		 * 
    		 * Above process could not work because native query dont accept multiple table operation thats 
    		 * why we have to choose the defined approach below. If single table look up or operation needed then we can use the method.
    		 * another thing is that native query does not support the executeUpdate and in this caling of getResultList() execute with
    		 * giving null pointer exception. 
    		 */
    		
    		Query query=session.createStoredProcedureCall("insert_hedge_sell_record");
    		query.executeUpdate();
    				
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void topBuySellValues(){
    	Session session= sessionfactory.openSession();
    	session.beginTransaction();
    	/*
    	 * query for extracting top 10 sell values from the Symbol summary table
    	 */
    	Query query=session.getNamedQuery("top_netbuy_sell_symbolSummary");
    	// returned list value from the table 
    	List<SellSummaryHF> rsult= query.getResultList();
    	
    	//write the resulted list into a text file
    	File fileName= new File("generate_files\\top_Symbol_NetValues.txt");
    	try{
    		FileWriter fw=new FileWriter(fileName);
    		BufferedWriter output=new BufferedWriter(fw);
    		
    		for(int i=0;i<rsult.size();i++){
    			//line by line write
    			output.write(rsult.get(i).toString());
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
