package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsClick extends Elements {
	WebDriver driver;
	WebElement mainBodyEle;
	
	ButtonsClick( WebDriver driver) {
		this.driver = driver;
	}
	
	void openBtntab() {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app")); 
		
		WebElement btnIcon = driver.findElement(By.id("item-4"));
		btnIcon.click(); 
	}
	
	void doubleClick() {
		WebElement doubleBtnEle = mainBodyEle.findElement(By.id("doubleClickBtn"));
		
		Actions actions = new Actions(driver);
		actions.doubleClick( doubleBtnEle ).perform();
		
		WebElement outputEle =  mainBodyEle.findElement(By.id("doubleClickMessage"));
		System.out.println( outputEle.getText());
	}
	
	void rightClick() {
		WebElement rightBtnEle = mainBodyEle.findElement(By.id("rightClickBtn"));
		
		Actions actions = new Actions(driver);
		actions.contextClick( rightBtnEle ).perform();
		
		WebElement outputEle =  mainBodyEle.findElement(By.id("rightClickMessage"));
		System.out.println( outputEle.getText());
	}
	
	void dynamicClick() {
		WebElement clickBtnEle = mainBodyEle.findElement(By.xpath(".//button[@type='button' and text()='Click Me']"));
		
		Actions actions = new Actions(driver);
		actions.click( clickBtnEle ).perform();
		
		WebElement outputEle =  mainBodyEle.findElement(By.id("dynamicClickMessage"));
		System.out.println( outputEle.getText());
	}
}
