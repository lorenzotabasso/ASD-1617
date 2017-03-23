package orderedarray;
 
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.failure;

/**
 * 
 * @author Tabasso
 */

public class OrderedArrayJava_TestRunner {
	
	/**
	 * @param args the command line arguments
	 */
	
	public static void main (String[] args) {
		Result result = JUnitCore.runClasses(OrderedArrayTests.class);
		
		for (Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}

