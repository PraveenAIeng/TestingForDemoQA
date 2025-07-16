package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RatioButton extends Elements {
	
	WebDriver driver;
	WebElement mainBodyEle;
	
	RatioButton (WebDriver driver) {
		this.driver = driver;
	}
	
	protected void clickRatio( String str) {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app")); 
		
		WebElement radioIcon = driver.findElement(By.id("item-2"));
		radioIcon.click(); 
		
		WebElement curEle;
		
		switch (str) {
			case "Yes":
				 curEle = mainBodyEle.findElement(By.id("yesRadio"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", curEle);
				break;
			case "Impressive":
				 curEle = mainBodyEle.findElement(By.id("impressiveRadio"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", curEle);
				break;
			case "No":
				 curEle = mainBodyEle.findElement(By.id("noRadio"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", curEle);
				break;
				
		}
//		WebElement resultShowEle = driver.findElement( RelativeLocator.with(By.className("custom-radio")).below(By.cssSelector("p.mt-3")) ) ;     
//		System.out.println( resultShowEle.getText() );
		
	}

}
