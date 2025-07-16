package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Forms {
	
	protected WebElement formElement;
	
	void openForm( WebDriver driver) {
		try {
			driver.get("https://demoqa.com");
			WebElement formEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Forms']")); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", formEle); 
			
			WebElement practiecFormEle = driver.findElement(By.xpath("//li[@id='item-0']/span[text()='Practice Form']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", practiecFormEle); 
			
			formElement = driver.findElement(By.id("userForm")); 
		}catch(Exception e) {
			System.out.println( e );
		}
		
	}
}
