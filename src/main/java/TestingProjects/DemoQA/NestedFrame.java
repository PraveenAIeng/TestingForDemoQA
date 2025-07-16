package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame implements Open{

	WebDriver driver;
	private WebElement framesWrapperEle; 
	
	NestedFrame( WebDriver driver){
			this.driver = driver;

	}
	
	public void open() {
		driver.get("https://demoqa.com");
		WebElement alertEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertEle); 
		
		WebElement frameEle = driver.findElement(By.xpath("//li[@id='item-3']/span[text()='Nested Frames']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", frameEle); 
		
		framesWrapperEle = driver.findElement(By.id("framesWrapper"));
	}
	
	void goToOuterFrame() { 
		try {
			WebElement outerFrame = framesWrapperEle.findElement(By.id("frame1")); 
			driver.switchTo().frame(outerFrame);
			Thread.sleep(2000);
			System.out.println( driver.findElement(By.tagName("body")).getText()); 
			
			
		}catch( Exception e ) {
			System.out.println( e ); 
		}
		
		
	}
	
	void goBack() {
		driver.switchTo().parentFrame();
	}
	
	void goMain() {
		driver.switchTo().defaultContent();
	}
	
	void goToNestedFram() {
		try {
			this.goToOuterFrame();
//			WebElement innerFrame = framesWrapperEle.findElement(By.tagName("iframe")); 
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			System.out.println( driver.findElement(By.tagName("body")).getText()); 
			
			
		}catch( Exception e ) {
			System.out.println( e ); 
		}
	}
}
