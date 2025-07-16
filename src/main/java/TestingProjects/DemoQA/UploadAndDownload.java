package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownload extends Elements {
	WebDriver driver;
	WebElement mainBodyEle;
	
	UploadAndDownload( WebDriver driver ) {
		this.driver = driver;
	}
	
	void openUpload() {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app"));
		
		WebElement uploadIcon = driver.findElement(By.id("item-7"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", uploadIcon); 
 	} 
	
	void uploadFile(String file) {
		try {
			WebElement uploadEle = mainBodyEle.findElement(By.id("uploadFile"));
			uploadEle.sendKeys(file);
			
			System.out.println( mainBodyEle.findElement(By.id("uploadedFilePath")).getText() ); 
			
		}catch( Exception e) {
			System.out.println( e );
		}
		
	}
	
	void downloadFile() {
		WebElement downloadEle = mainBodyEle.findElement(By.id("downloadButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", downloadEle);
	}
}
