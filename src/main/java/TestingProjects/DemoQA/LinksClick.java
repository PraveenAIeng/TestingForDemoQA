package TestingProjects.DemoQA;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksClick extends Elements {
	WebDriver driver;
	WebElement mainBodyEle;
	
	LinksClick( WebDriver driver) {
		this.driver = driver;
	}
	
	void openLink() {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app")); 
		
		WebElement linkIcon = driver.findElement(By.id("item-5"));
		linkIcon.click(); 
	}
	
	void linkOpenNewTab( String link) {
		WebElement linkTextEle = mainBodyEle.findElement(By.id(link)); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", linkTextEle); 
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		TextBox myText = new TextBox(driver);
		myText.textBoxTest("all");
	}
	
	void apiCall( String api) {
		try {
			WebElement apiEle = mainBodyEle.findElement(By.id(api));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", apiEle); 
			Thread.sleep(1000);
			
			WebElement responseEle = mainBodyEle.findElement(By.id("linkResponse")); 
			System.out.println( responseEle.getText() ); 
		}catch (Exception e) {
			System.out.println( 'e'  );
		}
		
	}
}
