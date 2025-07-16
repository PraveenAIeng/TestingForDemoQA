package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsAndFrames {
	
//	WebDriver driver;
//	WebElement mainBody;
	
	void openAlerts( WebDriver driver) {
		
		try {
			driver.get("https://demoqa.com");
			WebElement alertEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']")); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertEle); 
			
			
		}catch(Exception e) {
			System.out.println( e );
		}
		
	}
}
