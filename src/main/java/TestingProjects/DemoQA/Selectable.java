package TestingProjects.DemoQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Selectable implements Open {
	WebDriver driver;
	private String view = "List";
	
	Selectable( WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public void open() {
		driver.get("https://demoqa.com");
		WebElement interactionsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Interactions']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", interactionsEle); 
		
		WebElement selectableTabEle = driver.findElement(By.xpath("//li[@id='item-1']/span[text()='Selectable']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectableTabEle);

	}
	
	void chooseView( String view ) {
		if (view == "List") {
			WebElement viewEle = driver.findElement(By.id("demo-tab-list"))	;
			viewEle.click();
			this.view = view;
		}else {
			WebElement viewEle = driver.findElement(By.id("demo-tab-grid"))	;
			viewEle.click();
			this.view = view;
		}
	}
	
	void selectItem(List<String> elements) {
		if (this.view == "List") {
			for (String i : elements) {
				WebElement curItem = driver.findElement(By.id("demo-tabpane-list")).findElement(By.xpath(String.format(".//li[contains(@class, 'list-group-item-action') and text()='%s']", i)));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", curItem);
				curItem.click(); 
			}
			
		}else {
			for (String i : elements) {
				WebElement curItem = driver.findElement(By.id("demo-tabpane-grid")).findElement(By.xpath(String.format(".//li[contains(@class, 'list-group-item-action') and text()='%s']", i)));   
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", curItem);
				curItem.click(); 
			}
		}
		
	}
	

}
