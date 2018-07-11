package enumeration.rockPaperScissors;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test runner for the Rock-Paper-Scissors game. 
 * 
 * @author ruifengm
 * @since 2018-Jul-11
 */

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuite.class); 
		for (Failure f: result.getFailures()) System.out.println(f.toString());
		System.out.println("Total " + result.getRunCount() + " tests run and the result is " + result.wasSuccessful() + ".");
	}
}
