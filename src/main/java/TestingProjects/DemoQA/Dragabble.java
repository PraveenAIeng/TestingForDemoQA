package TestingProjects.DemoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dragabble implements Open {
	WebDriver driver;
	
	Dragabble( WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		
		driver.get("https://demoqa.com");
		WebElement interactionsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Interactions']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", interactionsEle); 
		
		WebElement droppableTabEle = driver.findElement(By.xpath("//li[@id='item-4']/span[text()='Dragabble']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", droppableTabEle);
	}
	
	void simple(int x, int y) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement simpleEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tab-simple"))); 
		simpleEle.click(); 
		
		WebElement dragEle = driver.findElement(By.id("dragBox")); 
		
		Actions actions = new Actions( driver ); 
		
		actions.clickAndHold(dragEle)
			.moveByOffset(x, y)
			.release()
			.perform();
		
	}
	
	void axisRestriction(String s, int num) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tab-axisRestriction"))); 
		navEle.click(); 
		
		WebElement dragXEle = driver.findElement(By.id("restrictedX")); 
		WebElement dragYEle = driver.findElement(By.id("restrictedY")); 
		
		Actions actions = new Actions( driver ); 
		
		if ( s.equals("X")) {
			actions.clickAndHold(dragXEle).moveByOffset(num, 0).perform();
		}else {
			actions.clickAndHold(dragYEle).moveByOffset(0, num).perform();
		}
		
	}
	
	void containerRestriction(int x, int y) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tab-containerRestriction"))); 
		navEle.click();
		
		WebElement containmentWrapperEle = driver.findElement(By.id("containmentWrapper"));
		WebElement moveItem = containmentWrapperEle.findElement(By.tagName("div"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(moveItem, x, y).perform(); 
		
		
		WebElement dragTextEle = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content')]/span"));  
		actions.dragAndDropBy(dragTextEle, x, y).perform();
	}
	
	void styleCurser( int x1, int y1, int x2, int y2, int x3, int y3) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tab-cursorStyle"))); 
		navEle.click();
		
		WebElement mainContainer = driver.findElement(By.id("draggableExample-tabpane-cursorStyle"));
		WebElement cursorCenterEle = mainContainer.findElement(By.id("cursorCenter"));
		WebElement cursorTopLeftEle = mainContainer.findElement(By.id("cursorTopLeft"));
		WebElement cursorBottomEle = mainContainer.findElement(By.id("cursorBottom"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(cursorCenterEle, x1, y1).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cursorTopLeftEle);
		actions.dragAndDropBy(cursorTopLeftEle, x2, y2).perform();
		actions.dragAndDropBy(cursorBottomEle, x3, y3).perform();
		
		
	}
	

}
