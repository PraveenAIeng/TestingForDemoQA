package TestingProjects.DemoQA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Widgets implements Open {
	WebDriver driver;
	
	Widgets( WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get("https://demoqa.com");
		WebElement WidgetsEle = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Widgets']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", WidgetsEle); 
	}
	
	void Accordian( String id) {
		try {
			WebElement accordianEle = driver.findElement(By.xpath("//li[@id='item-0']/span[text()='Accordian']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", accordianEle);
			
			System.out.println(driver.findElement(By.id( id + "Content" )).isDisplayed());
			if ( !driver.findElement(By.id( id + "Content" )).isDisplayed() ) {
				WebElement sectionHeadingEle = driver.findElement(By.id( id + "Heading" ));
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", sectionHeadingEle); 
			}
			
			
			Thread.sleep(3000);
			
//			WebElement contentEle = driver.findElement(By.className("collapse show"));    compound class name not permited to access selenium 
			String textItem = driver.findElement(By.id( id + "Content" )).findElement(By.tagName("p")).getText();
			
			System.out.println( textItem );
		}catch( Exception e) {
			System.out.println( e );
		}
		
		
				
	}
	
	
	void autoComplete( List<String> list) { 
		WebElement autoComEle = driver.findElement(By.xpath("//li[@id='item-1']/span[text()='Auto Complete']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", autoComEle);
		
		WebElement autoComplectInputEle = driver.findElement(By.id("autoCompleteMultipleInput"));         
		
		for (int i = 0; i<list.size(); i++) {
			autoComplectInputEle.sendKeys( list.get(i ));
			autoComplectInputEle.sendKeys( Keys.TAB);
			
		}
	}
	
	void autoComplete( String key) { 
		WebElement autoComEle = driver.findElement(By.xpath("//li[@id='item-1']/span[text()='Auto Complete']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", autoComEle);
		
		WebElement autoComplectInputEle = driver.findElement(By.id("autoCompleteSingleInput"));         
		
		autoComplectInputEle.sendKeys( key);
		autoComplectInputEle.sendKeys( Keys.TAB);
	}
	
	void datePicker(String date) {
		
		WebElement dateTabEle = driver.findElement(By.xpath("//li[@id='item-2']/span[text()='Date Picker']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", dateTabEle); 
		
		WebElement dateEle = driver.findElement(By.id("datePickerMonthYearInput"));
		dateEle.clear();
		dateEle.sendKeys( date );
		dateEle.sendKeys(Keys.ENTER); 
		
		System.out.println( dateEle.getAttribute("value") ); 
		
		
	}
	
	void dateTimePicker( String date ) {
		WebElement dateTabEle = driver.findElement(By.xpath("//li[@id='item-2']/span[text()='Date Picker']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", dateTabEle); 
		
		WebElement dateTimeEle = driver.findElement(By.id("dateAndTimePickerInput"));
		dateTimeEle.clear();
		dateTimeEle.sendKeys( date );
		dateTimeEle.sendKeys(Keys.ENTER); 
		
		System.out.println( dateTimeEle.getAttribute("value") ); 
		
	}
	
	
	void silderSetValue() {
		WebElement sliderTabEle = driver.findElement(By.xpath("//li[@id='item-3']/span[text()='Slider']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", sliderTabEle); 
		
		
		WebElement sliderEle = driver.findElement(By.className("range-slider")); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", sliderEle, "75");
		
		
//		Actions action = new Actions(driver);

		// Move slider by offset: this depends on the width of the slider
//		action.clickAndHold(sliderEle).moveByOffset(50, 0).release().perform();
		
		System.out.println( sliderEle.getAttribute("value") ); 
	}
	
	void progressBar( int sec) { 
		try {
			WebElement barTapEle = driver.findElement(By.xpath("//li[@id='item-4']/span[text()='Progress Bar']")); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", barTapEle);
			
			WebElement barEle = driver.findElement(By.id("progressBar"));
			Thread.sleep(1000);
			System.out.println( barEle.getText() );
			
			WebElement startStopBtn = driver.findElement(By.id("startStopButton")); 
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", startStopBtn); 
			
			Thread.sleep(sec * 1000);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", startStopBtn); 
			
			System.out.println( barEle.getText() );
			
			
		}catch( Exception e) {
			
			System.out.println( e ); 
			
		}
		
		
		
		
		
	}
	
	void tabs( String item ) {
		WebElement tapEle = driver.findElement(By.xpath("//li[@id='item-5']/span[text()='Tabs']")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", tapEle);
		WebElement mainContainerEle = driver.findElement(By.id("tabsContainer"));
		
		switch( item ) {
		case "What":
			WebElement whatEle = mainContainerEle.findElement(By.id("demo-tab-what")); 
			whatEle.click(); 
			
			WebElement whatContent = mainContainerEle.findElement(By.id("demo-tabpane-what"));
			System.out.println( "What: " +  whatContent.getText() ); 
			break;
			
			
		case "Orgin": 
			WebElement orginEle = mainContainerEle.findElement(By.id("demo-tab-origin")); 
			orginEle.click(); 
			
			WebElement orginContent = mainContainerEle.findElement(By.id("demo-tabpane-origin"));
			System.out.println( "Orgin: " +  orginContent.getText() ); 
			break;
			
		case "Use": 
			WebElement useEle = mainContainerEle.findElement(By.id("demo-tab-use")); 
			useEle.click(); 
			
			WebElement useContent = mainContainerEle.findElement(By.id("demo-tabpane-use"));
			System.out.println( "Use: " +  useContent.getText() ); 
			
		}
	}
	
	void toolTips() {
		
		try {
			WebElement toolTipEle = driver.findElement(By.xpath("//li[@id='item-6']/span[text()='Tool Tips']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", toolTipEle); 
			
			WebElement toolTipContainer = driver.findElement(By.id("toopTipContainer")); 
			
			Actions actions = new Actions(driver); 
			
			WebElement toolBtnEle = toolTipContainer.findElement(By.id("toolTipButton"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toolBtnEle);
			actions.moveToElement(toolBtnEle).perform();
//			get output
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement tooltipMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonToolTip")));
			System.out.println( tooltipMessage.getText() ); 
			
			Thread.sleep(1000);
//			log
			
			WebElement inputEle = toolTipContainer.findElement(By.id("toolTipTextField"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputEle);
			actions.moveToElement(inputEle).perform();
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			tooltipMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("textFieldToolTip"))); 
			System.out.println( tooltipMessage.getText() );
			
			Thread.sleep(1000);
			
			WebElement textAngerEle = toolTipContainer.findElement(By.xpath("//div[@id='texToolTopContainer']/a"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textAngerEle);
			actions.moveToElement(textAngerEle).perform();
			
			tooltipMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contraryTexToolTip"))); 
			System.out.println( tooltipMessage.getText() );
			
			Thread.sleep(1000);
			
			WebElement timeAngerEle = toolTipContainer.findElement(By.xpath("//div[@id='texToolTopContainer']/a[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timeAngerEle);
			actions.moveToElement(timeAngerEle).perform();
			
			tooltipMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sectionToolTip"))); 
			System.out.println( tooltipMessage.getText() );
			
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}
		
		
	}
	
	void menu( String num) {
		try {
			WebElement menuEle = driver.findElement(By.xpath("//li[@id='item-7']/span[text()='Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", menuEle); 
			
			
			WebElement naveEle = driver.findElement(By.id("nav")); 
			
			char i = num.charAt(0);
			
			WebElement curItem = naveEle.findElement(By.xpath(String.format("//ul[@id='nav']/li[%c]", i)));
			Actions actions = new Actions(driver); 
			
			if (num.length() == 1 ) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", curItem);
			}else {
				actions.moveToElement(curItem).perform(); 
				for (int j =1; j<num.length(); j++) {
					i = num.charAt(j);
					curItem = curItem.findElement(By.xpath(String.format(".//ul/li[%c]", i)));
					actions.moveToElement(curItem).perform(); 
				}
			}
			
			System.out.println( curItem.findElement(By.tagName("a")).getText() ); 
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	void selectMenu(String key) {
		try {
			WebElement selectTabEle = driver.findElement(By.xpath("//li[@id='item-8']/span[text()='Select Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectTabEle); 
			
			WebElement selectEle = driver.findElement(By.className("css-1wa3eu0-placeholder"));
			selectEle.click(); 
			
			WebElement optionsContainerEle = driver.findElement(By.className("css-26l3qy-menu")); 
			
			optionsContainerEle.findElement(By.xpath(String.format(".//div[@tabindex='-1' and text()='%s']", key))).click();
			
			System.out.println( driver.findElement(By.className("css-1uccc91-singleValue")).getText() ); 
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	void selectOne(String key) {
		try {
			WebElement selectTabEle = driver.findElement(By.xpath("//li[@id='item-8']/span[text()='Select Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectTabEle); 
			
			WebElement selectEle = driver.findElement(By.id("selectOne")).findElement(By.className("css-1wa3eu0-placeholder"));      
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectEle);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectEle);  
			selectEle.click();
			
			WebElement optionsContainerEle = driver.findElement(By.className("css-26l3qy-menu")); 
			
			optionsContainerEle.findElement(By.xpath(String.format(".//div[@tabindex='-1' and text()='%s']", key))).click();
			
			System.out.println( driver.findElement(By.className("css-1uccc91-singleValue")).getText() ); 
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	void oldSelect( String key ) {
		try {
			WebElement selectTabEle = driver.findElement(By.xpath("//li[@id='item-8']/span[text()='Select Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectTabEle); 
			
			WebElement selectEle = driver.findElement(By.id("oldSelectMenu"));
			Select select = new Select(selectEle); 
//			select.selectByVisibleText(key);
			
			select.selectByValue(key);
			
//			select.selectByIndex(4);
			
			
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	void selectMultiple(List<String>  keys) {
		try {
			WebElement selectTabEle = driver.findElement(By.xpath("//li[@id='item-8']/span[text()='Select Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectTabEle); 
			
			WebElement selectEle = driver.findElement(By.xpath("//div[contains(@class, '-placeholder') and contains(text(), 'Select...')]"));      
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectEle);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectEle);  
			selectEle.click();
			
			WebElement optionsContainerEle = driver.findElement(By.className("css-26l3qy-menu")); 
			
			for (String i : keys) {
				optionsContainerEle.findElement(By.xpath(String.format(".//div[@tabindex='-1' and text()='%s']", i))).click();
			}
			
//			Thread.sleep(3000);
//			System.out.println( driver.findElement(By.className("css-1hwfws3")).getText() ); 
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	void newSelect( List<String>  keys ) {
		try {
			WebElement selectTabEle = driver.findElement(By.xpath("//li[@id='item-8']/span[text()='Select Menu']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectTabEle); 
			
			WebElement selectEle = driver.findElement(By.id("cars"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectEle);
			Select select = new Select(selectEle); 
//			select.selectByVisibleText(key);
			
//			select.selectByValue(key);
			
//			select.selectByIndex(4);
			
			for (String i : keys) {
				select.selectByVisibleText(i);
			}
			
			
			
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

























