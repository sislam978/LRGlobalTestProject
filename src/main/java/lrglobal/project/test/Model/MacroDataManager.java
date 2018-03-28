package lrglobal.project.test.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import lrglobal.project.test.LRGlobalTestProject.ReadSelectedMacro;

public class MacroDataManager {
	
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
 
    public void Insert(String fileName) throws ParseException {
        // code to save a Data
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	
    	//String fileName="SelectedMacroData.csv";
    	ReadSelectedMacro readSelectedMacro=new ReadSelectedMacro();
    	
    	ArrayList<MacroData> rslt=readSelectedMacro.getAllData(fileName);
    	Collections.sort(rslt, MacroData.MacroComparator);
    	for(int i=0;i<rslt.size();i++){
    		MacroData md=rslt.get(i);
    		/*
    		 * checking the unique constraints of the macro data table. If there will any duplicate data then the query will return atleast 1 value.
    		 * from which we can determine the data is duplicate or not
    		 */
    		String SQL_QUERY="select u from MacroData u where u.macro_name='" + rslt.get(i).getMacro_name() + 
    				"' and u.date='"+rslt.get(i).getDate()+"'";

    		Query query=session.createQuery(SQL_QUERY);
    		List<MacroData> list =(List<MacroData>) query.getResultList();
    		if(list.size()>0){
    			i=i+list.size()-1;
    			continue;
    					
    		}
    		
    		session.save(md);
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
