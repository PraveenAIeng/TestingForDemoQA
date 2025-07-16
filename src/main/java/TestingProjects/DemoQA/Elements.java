package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Elements {
	
	
	public void openElements( WebDriver driver ) {
		driver.get("https://demoqa.com");
		//WebElement elementEle = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1][@class='card-body']/h5[text()='Elements']"));
		WebElement elementEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
//		elementEle.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementEle);
	}
	
	

	
}



