package org.internet.utils;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.IAssert;

public class AssertUtil extends SoftAssert {
	private List<String> results = new ArrayList<String>();
    
	@Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		ITestResult result = Reporter.getCurrentTestResult();
        result.setStatus(ITestResult.FAILURE);
        results.add("VALIDATION <FAILED> FOR: " + assertCommand.getMessage() + 
        		", EXPECTED: " + assertCommand.getExpected() + ", ACTUAL: " + assertCommand.getActual());
	}
    
    @Override
	public void onAssertSuccess(IAssert<?> assertCommand) {
    	results.add("VALIDATION <PASSED> FOR: " + assertCommand.getMessage() + 
        		", EXPECTED: " + assertCommand.getExpected() + ", ACTUAL: " + assertCommand.getActual());
	}
    
    @Override
    public void assertAll(String msg) {
    	System.out.println();
    	System.out.println("**************************************************************");
    	System.out.println();
    	
    	System.out.println("VALIDATIONS FOR " + msg);
    	results.forEach(System.out::println);
    	
    	System.out.println();
    	System.out.println("**************************************************************");
    	System.out.println();
    }
}
