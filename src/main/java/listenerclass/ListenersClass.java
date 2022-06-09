package listenerclass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@Listeners(ListenersClass.class)

public class ListenersClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		    // not implemented
		System.out.println(result.getName() + " Test Started");
		
		  }

		 
		 public void onTestSuccess(ITestResult result) {
		    // not implemented
			 System.out.println(result.getName() + " Test Passed");
		  }

		
		  public void onTestFailure(ITestResult result) {
		    // not implemented
			  System.out.println(result.getName() + " Test Failed");
		  }

		 
		 
		 public void onTestSkipped(ITestResult result) {
		    // not implemented
			 System.out.println(result.getName() + " Test Skipped");
		  }

		 
		  
}
