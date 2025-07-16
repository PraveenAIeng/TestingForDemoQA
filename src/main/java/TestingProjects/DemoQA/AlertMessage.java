package TestingProjects.DemoQA;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertMessage extends AlertsAndFrames {
	
	
	WebDriver driver;
	private WebElement javascriptAlertsWrapperEle;
	private static Scanner sc = new Scanner(System.in);
	
	AlertMessage( WebDriver driver) {
		this.driver = driver;
		this.openAlerts(driver); 
		
		WebElement alertsEle = driver.findElement(By.xpath("//li[@id='item-1']/span[text()='Alerts']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertsEle);  
		
		javascriptAlertsWrapperEle = driver.findElement(By.id("javascriptAlertsWrapper"));
		
	}
	
	void openSeeAlert() {
		WebElement seeClickBtn = javascriptAlertsWrapperEle.findElement(By.id("alertButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", seeClickBtn);
		
		Alert alert = driver.switchTo().alert();

        // Get the text from alert
        String alertText = alert.getText();
        System.out.println("Alert says: " + alertText);
	}
	
	void openSeeLaterAlert() {
		try {
			WebElement seeClickLateBtn = javascriptAlertsWrapperEle.findElement(By.id("timerAlertButton"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", seeClickLateBtn);
			
			Thread.sleep(6000);
			
			Alert alert = driver.switchTo().alert();

	        // Get the text from alert 
	        String alertText = alert.getText();
	        System.out.println("Alert says: " + alertText);
	        alert.accept();
		}catch(Exception e) {
			System.out.println("No show");
		}
		
	}
	
	void openSeeWithCheckAlert() {
		try {
			WebElement seeClictCheackEle = javascriptAlertsWrapperEle.findElement(By.id("confirmButton"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", seeClictCheackEle); 
			
			Alert alert = driver.switchTo().alert();
			
			System.out.println( alert.getText() );
			System.out.println( "Enter action OK/Cencle");
			String message = sc.next().toLowerCase();
			
			if ( message.equals( "ok") ) {
				alert.accept();
			}else {
				alert.dismiss();
			}
			
			System.out.println( javascriptAlertsWrapperEle.findElement(By.id("confirmResult")).getText()); 
		}catch( Exception e) {
			System.out.println( e ); 
		}
	}
	
	
	void openSeePromtAlert() {
		try {
			WebElement seeClictPromtEle = javascriptAlertsWrapperEle.findElement(By.id("promtButton"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", seeClictPromtEle); 
			
			Alert alert = driver.switchTo().alert();
			
			System.out.println( alert.getText() );
			
			System.out.println( "Enter your name..");
			String name = sc.next();
			
			alert.sendKeys(name);
			
			System.out.println( "Enter action OK/Cencle");
			String message = sc.next().toLowerCase();
			
			if ( message.equals( "ok") ) {
				alert.accept();
				System.out.println( javascriptAlertsWrapperEle.findElement(By.id("promptResult")).getText()); 
			}else {
				alert.dismiss();
				System.out.println( "cancled.."); 
			}
			
			
		}catch( Exception e) {
			System.out.println( e ); 
		}
	}
	
	
}
