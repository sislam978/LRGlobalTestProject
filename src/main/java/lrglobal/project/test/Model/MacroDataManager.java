package lrglobal.project.test.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import lrglobal.project.test.LRGlobalTestProject.App;
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
    public void change_calculation(){
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	System.out.println("ENter the MacroName");
    	Scanner inScanner=new Scanner(System.in);
    	String mn=inScanner.nextLine();
    	System.out.println("Enter the date value");
    	String daString=inScanner.nextLine();
    	try{
    		Query query=session.getNamedQuery("change_in_macro_data")
    				.setParameter("q_MacroName", mn)
    				.setParameter("q_date", daString);
        	List<MacroData> rslt=query.getResultList();
        	//Collections.sort(list,);
        	int last_index=rslt.size()-1;
        	Double changeInvalue= ((rslt.get(0).getMacro_value()/rslt.get(last_index).getMacro_value())-1);
        	
        	String writeValue= "In Ticker "+ rslt.get(0).getMacro_name()+", the change in macro value from " +rslt.get(last_index).getDate().toString()+ 
        			" to "+rslt.get(0).getDate().toString() + " is "+ changeInvalue.toString()+".";
        	String date_value="In date "+ rslt.get(last_index).getDate().toString()+" the macro value was "+ 
        			rslt.get(last_index).getMacro_value().toString() + " and in date "+ rslt.get(0).getDate().toString()+
        			" macro value was " +rslt.get(last_index).getMacro_value().toString()+".";
        	
        	File fileName= new File("generate_files\\change_in_macro.txt");
        	
        	FileWriter fw=new FileWriter(fileName);
    		BufferedWriter output=new BufferedWriter(fw);
    		output.write(writeValue);
    		output.newLine();
    		output.newLine();
    		output.write(date_value);
    		output.close();
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		
    		System.out.println("Exception: "+e);
		}
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void OneYearHighestMacro(){
    	Session session = sessionfactory.openSession();
    	session.beginTransaction();
    	System.out.println("ENter the MacroName");
    	Scanner inScanner=new Scanner(System.in);
    	String mn=inScanner.nextLine();
    	System.out.println("Enter the date value");
    	String daString=inScanner.nextLine();
    	try{
    		Query query=session.getNamedQuery("one_year_highest_macro")
    				.setParameter("q_MacroName", mn)
    				.setParameter("q_date", daString);
        	List<MacroData> rslt=query.getResultList();
        	//Collections.sort(list,);
        	
        	Double highest_Value= rslt.get(0).getMacro_value();
        	String date=rslt.get(0).getDate();
        	
        	String writeValue= "Highest macro value from " +daString+ 
        			" to last one year is "+highest_Value+ " and the date in which the macro value was highest is "+date;        	
        	
        	File fileName= new File("generate_files\\OneYear_HighestMacro.txt");
        	
        	FileWriter fw=new FileWriter(fileName);
    		BufferedWriter output=new BufferedWriter(fw);
    		output.write(writeValue);
    		output.newLine();
    		output.close();
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		
    		System.out.println("Exception: "+e);
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
