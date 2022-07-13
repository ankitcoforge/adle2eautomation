package utils;

import java.io.File;

import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;		

public class listnerlogs extends baseClass implements ITestListener 				
{		

    @Override		
    public void onFinish(ITestContext Result) 	
    {		
    	 		
    }		

    @Override		
    public void onStart(ITestContext Result)					
    {		
            		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());
    File theDir = new File(System.getProperty("user.dir") + "\\FailScreenshot");
    if (!theDir.exists()){
        theDir.mkdirs();
    }
    takeScreenshot(Result.getName(),theDir);
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());	
    
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");		
    
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());
    File theDir = new File(System.getProperty("user.dir") + "\\PassScreenshot");
    if (!theDir.exists()){
        theDir.mkdirs();
    }
    takeScreenshot(Result.getName(),theDir);
    }		

}			