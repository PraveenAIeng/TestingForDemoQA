package TestingProjects.DemoQA;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BroserWindow extends AlertsAndFrames {
	
	WebDriver driver;
	WebElement browserWindowsEle;
	
	BroserWindow( WebDriver driver) {
		this.driver  = driver;
		this.openAlerts(driver);
		
		WebElement alertsFrameEle = driver.findElement(By.xpath("//li[@id='item-0']/span[text()='Browser Windows']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertsFrameEle); 
		
		browserWindowsEle = driver.findElement(By.id("browserWindows"));
		
	}
	
	void openNewTab() {
		try {
			WebElement newTab = browserWindowsEle.findElement(By.id("tabButton"));
			(( JavascriptExecutor ) driver).executeScript("arguments[0].click()", newTab); 
			
			Thread.sleep(5000);
			
			List<String> openTabsId = new ArrayList<>( driver.getWindowHandles() );
			driver.switchTo( ).window(openTabsId.get(1)); 
			
			WebElement outPutEle = driver.findElement(By.id("sampleHeading")); 
			System.out.println( outPutEle.getText() ); 
		}catch(Exception e) {
			System.out.println( e );
		}
		
		
		
	}
	
	void openNewWindow() {
		try {
			WebElement newTab = browserWindowsEle.findElement(By.id("windowButton"));
			(( JavascriptExecutor ) driver).executeScript("arguments[0].click()", newTab); 
			
			Thread.sleep(3000);
			
			List<String> openTabsId = new ArrayList<>( driver.getWindowHandles() );
			driver.switchTo( ).window(openTabsId.get(1)); 
			
			WebElement outPutEle = driver.findElement(By.id("sampleHeading")); 
			System.out.println( outPutEle.getText() ); 
		}catch(Exception e) {
			System.out.println( e );
		}
		
		
		
	}
	
	void openNewWindowMessage() {
		try {
			WebElement newTab = browserWindowsEle.findElement(By.id("messageWindowButton"));
			(( JavascriptExecutor ) driver).executeScript("arguments[0].click()", newTab); 
			
			Thread.sleep(3000);
			
			List<String> openTabsId = new ArrayList<>( driver.getWindowHandles() );
			driver.switchTo( ).window(openTabsId.get(1)); 
			
			WebElement outPutEle = driver.findElement(By.tagName("body")); 
			System.out.println( outPutEle.getText() ); 
		}catch(Exception e) {
			System.out.println( e );
		}
		
		
		
	}
	
}
