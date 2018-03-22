package lrglobal.project.test.LRGlobalTestProject;

import java.util.Scanner;

import lrglobal.project.test.Model.HedgeFundManager;
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
        if(command.equals("hfi")){
        	HedgeFundManager hedgeManager=new HedgeFundManager();
            hedgeManager.setup();
            hedgeManager.create();
            hedgeManager.exit();
        }
        
        else{
        	System.out.println("No operation defined. ");
        }
        
    }
}
