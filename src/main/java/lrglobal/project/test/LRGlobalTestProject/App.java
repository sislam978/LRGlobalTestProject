package lrglobal.project.test.LRGlobalTestProject;

import java.sql.SQLException;
import java.util.Scanner;

import lrglobal.project.test.Model.HedgeFundManager;
import lrglobal.project.test.Model.SectorSumamryManager;
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
         * This is the code snippet of operation sets
         * It will take one input at a time till now and complete the operation
         * After defining the whole work process there would be huge change of the file
         * Till now this is only for test purposes 
         */
        if(command.equals("hfi")){
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.create();
            hedgeManager.exit();
        }
        /*
         * update hedge fund table by adding net buy sell column
         */
        else if(command.equalsIgnoreCase("nbsc")){
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.addNetSell();
            hedgeManager.exit();
        }
        /*
         * inserting data in symbol summary table =sell summary HF
         */
        else if(command.equalsIgnoreCase("sshf")){
        	SellSummaryHFManager sellSummaryHFManager=new SellSummaryHFManager();
        	sellSummaryHFManager.setup();
        	sellSummaryHFManager.Insert();
        	sellSummaryHFManager.exit();
        }        
        /*
         * Inserting data in sector summary table
         */
        else if(command.equalsIgnoreCase("ssi")){
        	SectorSumamryManager sectorSumamryManager=new SectorSumamryManager();
        	sectorSumamryManager.setup();
        	sectorSumamryManager.Insert();
        	sectorSumamryManager.exit();
        }
        /*
         * showing top net buy sell value in symbol summary=sell summary HF
         */
        else if(command.equalsIgnoreCase("tnbsv")){
        	SellSummaryHFManager sellSummaryHFManager=new SellSummaryHFManager();
        	sellSummaryHFManager.setup();
        	sellSummaryHFManager.topBuySellValues();
        	sellSummaryHFManager.exit();
        }
        /*
         * for showing top net buy sell value in sector summary
         */
        else if(command.equalsIgnoreCase("tnbsvss")){
        	SectorSumamryManager sectorSumamryManager=new SectorSumamryManager();
        	sectorSumamryManager.setup();
        	sectorSumamryManager.topBuySellValuesSector();
        	sectorSumamryManager.exit();
        }
        
        else{
        	System.out.println("No operation defined. ");
        }
        
    }
}
