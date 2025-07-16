package TestingProjects.DemoQA;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksImage extends Elements {
	
	WebDriver driver;
	WebElement mainBodyEle;
	
	BrokenLinksImage( WebDriver driver) {
		this.driver = driver;
	}
	
	void openImage( ) {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app"));
		WebElement brokenIcon = driver.findElement(By.id("item-6"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", brokenIcon);  
	}
	
	void getValidLink() {
		WebElement linkELe = mainBodyEle.findElement(By.xpath("//a[text()='Click Here for Valid Link']"));
		linkELe.click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(tabs);
		
		TextBox myText = new TextBox(driver);
		myText.textBoxTest("all");
	}
	
	void getBrokenLink() {
		try {
			WebElement linkELe = mainBodyEle.findElement(By.xpath("//a[text()='Click Here for Broken Link']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", linkELe); 
			
			Thread.sleep(5000);
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement resultEle = driver.findElement(By.id("content"));
			
			System.out.println(resultEle.getText());
		}catch (Exception e) {
			System.out.println( e );
		}
		
		
	}
}
