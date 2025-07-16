package TestingProjects.DemoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Droppable implements Open {
	WebDriver driver;
	
	Droppable(WebDriver driver) {
		this.driver = driver; 
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub 
		driver.get("https://demoqa.com");
		WebElement interactionsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Interactions']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", interactionsEle); 
		
		WebElement droppableTabEle = driver.findElement(By.xpath("//li[@id='item-3']/span[text()='Droppable']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", droppableTabEle);

	} 
	
	void simple() {
		WebElement simpleEle = driver.findElement(By.id("droppableExample-tab-simple"));
		simpleEle.click();
		
		WebElement dragEle = driver.findElement(By.id("draggable")); 
		WebElement dropEle = driver.findElement(By.id("droppable")); 
		
		Actions actions = new Actions( driver ); 
		
		actions.clickAndHold(dragEle)
			.moveToElement(dropEle,-35,-47)
			.release()
			.perform();
		
		System.out.println(dropEle.findElement(By.tagName("p")).getText());
		
	}
	
	void accept(int i) {
		WebElement acceptNavEle = driver.findElement(By.id("droppableExample-tab-accept")); 
		acceptNavEle.click();
		
		WebElement mainContainerEle = driver.findElement(By.id("acceptDropContainer"));
		WebElement acceptEle = mainContainerEle.findElement(By.id("acceptable"));
		WebElement nonAcceptEle = mainContainerEle.findElement(By.id("notAcceptable")); 
		WebElement dropEle = mainContainerEle.findElement(By.id("droppable")); 
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropEle);
		
		Actions actions = new Actions(driver); 
		
		if (i==1) {
			actions.dragAndDrop(acceptEle, dropEle)
				.perform();
			System.out.println(dropEle.findElement(By.tagName("p")).getText());
			
		}else {
			actions.clickAndHold(nonAcceptEle)
				.moveToElement(dropEle)
				.release()
				.perform();
		    System.out.println(dropEle.findElement(By.tagName("p")).getText());
		}
	}
	
	void preventPropogation( String key) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppableExample-tab-preventPropogation"))); 
		navEle.click(); 
		
		WebElement mainContainerEle = driver.findElement(By.id("ppDropContainer")); 
		WebElement dragBoxEle = mainContainerEle.findElement(By.id("dragBox"));
		WebElement outerBoxNotELe = mainContainerEle.findElement(By.id("notGreedyDropBox"));
		WebElement innerBoxNotEle = mainContainerEle.findElement(By.id("notGreedyInnerDropBox")); 
		
		WebElement outerBox = mainContainerEle.findElement(By.id("greedyDropBox"));
		WebElement innerBox = mainContainerEle.findElement(By.id("greedyDropBoxInner"));  
		
		Actions actions = new Actions(driver); 
		
		switch( key ) {
		case "outerBoxNot":
			actions.clickAndHold(dragBoxEle)
				.moveToElement(outerBoxNotELe, 0, -83)
				.release()
				.perform();
			System.out.println(outerBoxNotELe.findElement(By.tagName("p")).getText());
//			System.out.println(innerBoxNotEle.findElement(By.tagName("p")).getText());
			break;
		case "innerBoxNot":
			actions.dragAndDrop(dragBoxEle, innerBoxNotEle).perform(); 
			System.out.println(innerBoxNotEle.findElement(By.tagName("p")).getText());
			break;
		case "outerBox":
			actions.clickAndHold(dragBoxEle)
			.moveToElement(outerBox, 0, -60)
			.release()
			.perform();
			System.out.println(outerBox.findElement(By.tagName("p")).getText());
			break;
		case "innerBox":
			actions.dragAndDrop(dragBoxEle, innerBox).perform(); 
			System.out.println(innerBox.findElement(By.tagName("p")).getText());
			break;
		}
	}
	
	void revertDraggable(int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppableExample-tab-revertable"))); 
		navEle.click(); 
		
		WebElement mainContainerEle = driver.findElement(By.id("revertableDropContainer")); 
		WebElement willRevertEle = mainContainerEle.findElement(By.id("revertable")); 
		WebElement notRevertEle = mainContainerEle.findElement(By.id("notRevertable"));
		
		WebElement droppableEle = mainContainerEle.findElement(By.id("droppable"));
		Actions actions = new Actions(driver); 
		if (i==1) {
			actions.dragAndDrop(willRevertEle, droppableEle).perform();
			System.out.println(droppableEle.findElement(By.tagName("p")).getText());
		}else {
			actions.dragAndDrop(notRevertEle, droppableEle).perform();
			System.out.println(droppableEle.findElement(By.tagName("p")).getText());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
