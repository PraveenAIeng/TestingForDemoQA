package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames extends AlertsAndFrames {
	
	static WebDriver driver;
	private WebElement framesWrapperEle; 
	
	Frames(WebDriver driver) {
		this.driver = driver;
		this.openAlerts(driver); 
		
		WebElement frameEle = driver.findElement(By.xpath("//li[@id='item-2']/span[text()='Frames']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", frameEle);  
		
		framesWrapperEle = driver.findElement(By.id("framesWrapper"));
	}
	
	void goToFrameOne() {
		try {
			WebElement frameLocal  = framesWrapperEle.findElement(By.id("frame1")); 
			driver.switchTo().frame(frameLocal);
			Thread.sleep(3000);
			System.out.println( driver.findElement(By.id("sampleHeading")).getText()); 
		}catch( Exception e) {
			System.out.println( e ); 
		}
		
	}
	
	void goToFrameTwo () {
		try {
			//WebElement frameEle = framesWrapperEle.findElement(By.id("frame2")); 
			driver.switchTo().frame("frame2");
			Thread.sleep(3000);
			System.out.println( driver.findElement(By.tagName("h1")).getText()); 
		}catch(Exception e ) {
			System.out.println( e ); 
		}
		
	}
	
	void goBack() {
		driver.switchTo().parentFrame();
	}

}
