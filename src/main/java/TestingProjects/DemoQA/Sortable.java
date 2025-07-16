package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sortable implements Open{
	WebDriver driver;
	private String view = "List";
	
	Sortable( WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get("https://demoqa.com");
		WebElement interactionsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Interactions']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", interactionsEle); 
		
		WebElement sortableTabEle = driver.findElement(By.xpath("//li[@id='item-0']/span[text()='Sortable']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", sortableTabEle);
	}
	
	void chooseView( String view) {
		if (view == "List") {
			WebElement viewEle = driver.findElement(By.id("demo-tab-list"));
			viewEle.click();
		}else {
			WebElement viewEle = driver.findElement(By.id("demo-tab-grid"));
			viewEle.click();
		}
		
		this.view  = view;
			
	}
	
	void selectIten( String key) {
		WebElement selectItemEle;
		if (this.view == "List") {
			selectItemEle = driver.findElement(By.id("demo-tabpane-list")).findElement(By.xpath(String.format(".//div[contains(@class, 'list-group-item-action') and text()='%s']", key)) ); 
		}else {
			selectItemEle = driver.findElement(By.id("demo-tabpane-grid")).findElement(By.xpath(String.format(".//div[contains(@class, 'list-group-item-action') and text()='%s']", key)) ); 
		}
		
		System.out.println( selectItemEle.getText() );
	}

}
