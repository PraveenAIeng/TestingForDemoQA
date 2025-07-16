package TestingProjects.DemoQA;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends Elements {
	
	WebDriver driver;
	WebElement mainBodyEle;
	
	CheckBox (WebDriver driver) {
		this.driver = driver;
	}
	
	void openAllButton() {
		
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app")); 
		
		WebElement checkBoxIcon = driver.findElement(By.id("item-1"));
		checkBoxIcon.click(); 
		
		WebElement homeBtnEle = mainBodyEle.findElement(By.cssSelector("button.rct-collapse.rct-collapse-btn"));
		
		Queue<WebElement> arrowButtons = new LinkedList<>();
		arrowButtons.add(homeBtnEle);
		
		
		
		List<WebElement> clickedItem = new ArrayList<>();
		clickedItem.add(homeBtnEle);
				
		while (arrowButtons.size() != 0) {
			WebElement temp = arrowButtons.poll(); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", temp);
			
			List<WebElement> tempEle = mainBodyEle.findElements(By.cssSelector("button.rct-collapse.rct-collapse-btn")); 
			
			
			for (int i = 0; i< tempEle.size(); i++) {
				if ( !clickedItem.contains(tempEle.get(i))) {
					arrowButtons.add(tempEle.get(i));
					clickedItem.add(tempEle.get(i));
				}
				
			}
			
		}
		
				
	}
	
	void clickTheElement( String item) {
		this.openAllButton();
		
		WebElement CheckEle = mainBodyEle.findElement(By.xpath(String.format("//span[@class='rct-title' and text()='%s']", item)));
		CheckEle.click();
		
		WebElement resultEle = mainBodyEle.findElement(By.id("result"));
		System.out.println( resultEle.getText() );
		
	}
	
	void clickTheElement( ArrayList<String> item) {
		this.openAllButton();
		
		for ( int i =0; i<item.size(); i++) {
			WebElement CheckEle = mainBodyEle.findElement(By.xpath(String.format("//span[@class='rct-title' and text()='%s']", item.get(i))));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", CheckEle);
		}
		
		
		WebElement resultEle = mainBodyEle.findElement(By.id("result"));
		System.out.println( resultEle.getText() );
		
	}
	
	
	
}
