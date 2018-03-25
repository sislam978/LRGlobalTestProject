package lrglobal.project.test.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
//import org.hibernate.Query;

import lrglobal.project.test.LRGlobalTestProject.ReadDataFromCSV;

public class HedgeFundManager {
	
	public SessionFactory sessionfactory;
	
	// connection initialization. dont bother much. this connection process will need in every database transaction
	// no need to change it either
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
    	//call the csv file read method and rr store the list of data 
    	rr=readCSV.getAllData(fileName);
    	// need to sort the collection to avoid unnecessary look ups
    	Collections.sort(rr, HedgeFund.HedgeFundComparator);
    	int listSize=rr.size();
    	for(int i=0;i<rr.size();i++){
    		HedgeFund hh=rr.get(i);
    		// this query is written to avoid duplicate entry into the database 
    		String SQL_QUERY="select u from HedgeFund u where u.symbol='" + rr.get(i).getSymbol() + 
    				"' and u.source_date='"+rr.get(i).getSource_date()+"' and u.nameOfFund='"+rr.get(i).getNameOfFund()+"'";

    		Query query=session.createQuery(SQL_QUERY);
    		List<HedgeFund> list =(List<HedgeFund>) query.getResultList();
    		/*
    		 * conditional check if the query return any data in the list that means there is already exist the intended entry data 
    		 * thats why inside the condition we just skip the insertion and also the amount of data which are duplicate by extracting the
    		 * size of the data */
    		if(list.size()>0){
    			i=i+list.size()-1;
    			continue;
    		}
    		//finally save the unique data 
    		session.save(hh);
    	}
    	
    	/*
    	 * after completing the transaction we must commit so that the opration in database would complete
    	 * and session must be close
    	 */
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
    
    public void addNetSell(){
    	Session session =sessionfactory.openSession();
    	session.beginTransaction();
    	
    	//String SQL_QUERY="select u from HedgeFund u where 1";

    	/*
    	 * take into consideration all the rows in the hedge table to update the hedge fund table with new net buy and sell column
    	 * here in for loop we calculate the provided equation of 
    	 * net buy and sell buy checking whether the value was calculated or not
    	 * In future it might be possible to change the query by introducing a new concept like consider the date so that
    	 * we can reduce the table look up
    	 */
		Query query=session.createQuery("from HedgeFund");
		List<HedgeFund> list =(List<HedgeFund>) query.getResultList();
		int list_size = list.size();
		
		for(int i=0;i<list_size;i++){
			double share_Held=list.get(i).getShareHeld();
			double Market_value=list.get(i).getMarketValue();
			double changeinShare=list.get(i).getChangInshare();
			double net_buy_Sell= -1;
			if(share_Held!=0 && list.get(i).getNet_buy_sell()==null){
				net_buy_Sell=(Market_value*changeinShare)/share_Held;
				list.get(i).setNet_buy_sell(net_buy_Sell);
			}
			else{
				net_buy_Sell=0;
				list.get(i).setNet_buy_sell(net_buy_Sell);
			}
			/*
			 * Each row update by introducing new column net_buy-sell
			 */
			session.update(list.get(i));
			
		}
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
