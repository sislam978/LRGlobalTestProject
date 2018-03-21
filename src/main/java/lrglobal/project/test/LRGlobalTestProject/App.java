package lrglobal.project.test.LRGlobalTestProject;

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
        HedgeFundManager hedgeManager=new HedgeFundManager();
        hedgeManager.setup();
        hedgeManager.create();
        hedgeManager.exit();
    }
}
