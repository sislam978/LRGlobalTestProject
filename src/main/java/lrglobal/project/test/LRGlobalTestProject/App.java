package lrglobal.project.test.LRGlobalTestProject;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import lrglobal.project.test.Model.HedgeFundManager;
import lrglobal.project.test.Model.MacroDataManager;
import lrglobal.project.test.Model.SectorSumamryManager;
import lrglobal.project.test.Model.SellSummaryHFManager;
import lrglobal.project.test.Model.TestTableManager;

/**
 * Hello world!
 *
 */
public class App 
{
	/*
	 * date formation method whatever the date is it will
	 * shopan vaia branchs convert to MySQL default date format
	 * git pull for shopan vaia 
	 */
	public String dateFormation(String toformat){
		
		SimpleDateFormat input_format= new SimpleDateFormat("mm/dd/yyyy");
		//Date date= new SimpleDateFormat(dateToformat);
		String formatedDate=null;
		Date date;
		try {
			date = input_format.parse(toformat);
			SimpleDateFormat output_format= new SimpleDateFormat("yyyy-MM-dd");
			formatedDate=output_format.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return formatedDate;
	}
    public static void main( String[] args ) throws ParseException 
    {
        TestTableManager manager=new TestTableManager();
//        manager.setup();
//        manager.create();
//        manager.exit();
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Operation Name: ");
        String command= input.nextLine();
        /*
         * This is the code snippet of operation sets
         * It will take one input at a time till now and complete the operation
         * After defining the whole work process there would be huge change of the file
         * Till now this is only for test purposes 
         */
        if(command.equals("hfi")){
        	//Scanner directory_input = new Scanner(System.in);
        	
        	System.out.println("Enter the directory of the hedge fund csv file: ");
        	String filePath= input.nextLine();
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.create(filePath);
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
        /*
         * Inserting Data to Macro data table
         */
        else if(command.equalsIgnoreCase("mdi")){
        	System.out.println("Enter the file directory of the macro CSV file: ");
        	String filePath=input.nextLine();
        	MacroDataManager macroDataManager=new MacroDataManager();
        	macroDataManager.setup();
        	macroDataManager.Insert(filePath);
        	macroDataManager.exit();
        }
        else if(command.equalsIgnoreCase("cimd")){
        	MacroDataManager macroDataManager=new MacroDataManager();
        	macroDataManager.setup();
        	macroDataManager.change_calculation();
        	macroDataManager.exit();
        }
        else{
        	System.out.println("No operation defined. ");
        }
        
    }
}
