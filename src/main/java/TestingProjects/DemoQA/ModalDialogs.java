package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalDialogs extends AlertsAndFrames {
	
	WebDriver driver;

	
	ModalDialogs( WebDriver driver) {
		this.driver = driver;
		this.openAlerts(driver);
		
		WebElement modalEle = driver.findElement(By.xpath("//li[@id='item-4']/span[text()='Modal Dialogs']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", modalEle); 
	}
	
	void openSmallModal() {
		WebElement showSmallModalEle = driver.findElement(By.id("showSmallModal"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", showSmallModalEle); 
		
		WebElement modalContentEle = driver.findElement(By.className("modal-content"));
		
		System.out.println( modalContentEle.getText() ); 
		
		
		driver.findElement(By.id("closeSmallModal")).click();
		
	}

	void openBigModal() {
		WebElement showLargeModalEle = driver.findElement(By.id("showLargeModal"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", showLargeModalEle); 
		
		WebElement modalContentEle = driver.findElement(By.className("modal-content"));
		
		System.out.println( modalContentEle.getText() ); 
		
		
		driver.findElement(By.id("closeLargeModal")).click();
		
	}
}
