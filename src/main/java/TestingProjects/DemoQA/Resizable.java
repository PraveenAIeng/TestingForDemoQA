package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Resizable implements Open {
	WebDriver driver;
	
	Resizable( WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		driver.get("https://demoqa.com");
		WebElement interactionsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Interactions']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", interactionsEle); 
		
		WebElement resizableTabEle = driver.findElement(By.xpath("//li[@id='item-2']/span[text()='Resizable']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", resizableTabEle);
	}
	
	void resizeLimit(int x, int y) {
		WebElement sizeEle = driver.findElement(By.id("resizableBoxWithRestriction")).findElement(By.className("react-resizable-handle"));
		Actions actions = new Actions(driver); 
		actions.clickAndHold(sizeEle)
			.moveByOffset(x, y)
			.release()
			.perform();
		
	}
	
	void resizeUnLimited(int x, int y) {
		WebElement sizeEle = driver.findElement(By.id("resizable")).findElement(By.className("react-resizable-handle"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeEle);
		Actions actions = new Actions(driver); 
		actions.clickAndHold(sizeEle)
			.moveByOffset(x, y)
			.release()
			.perform();
		
	}

}
