package lrglobal.project.test.LRGlobalTestProject;

import java.sql.SQLException;
import java.util.Scanner;

import lrglobal.project.test.Model.HedgeFundManager;
import lrglobal.project.test.Model.SellSummaryHFManager;
import lrglobal.project.test.Model.TestTableManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        TestTableManager manager=new TestTableManager();
//        manager.setup();
//        manager.create();
//        manager.exit();
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Operation Name: ");
        String command= input.next();
        /*
         * This i9s the code snipet of operation sets
         * It will take one input at a time till now and complete the operation
         * After defining the whole work process there would be huge chnage of the file
         * Till now this is only for test purposes 
         */
        if(command.equals("hfi")){
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.create();
            hedgeManager.exit();
        }
        else if(command.equalsIgnoreCase("nbsc")){
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.addNetSell();
            hedgeManager.exit();
        }
        else if(command.equalsIgnoreCase("sshf")){
        	SellSummaryHFManager sellSummaryHFManager=new SellSummaryHFManager();
        	sellSummaryHFManager.setup();
        	sellSummaryHFManager.Insert();
        	sellSummaryHFManager.exit();
        }
        
        else{
        	System.out.println("No operation defined. ");
        }
        
    }
}
