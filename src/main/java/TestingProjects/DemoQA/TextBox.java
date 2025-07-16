package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends Elements {
	
	WebDriver driver;
	
	TextBox ( WebDriver driver) {
		this.driver = driver;
	}
	
	public void textBoxTest(String method) {
//		driver.get("https://demoqa.com/elements");
		
		this.openElements( driver );
		
		WebElement textBoxIcon = driver.findElement(By.id("item-0"));
		textBoxIcon.click();
		
		WebElement mainBodyEle = driver.findElement(By.id("app"));
		
		switch ( method ) {
		case "fullName":
			this.fullName(mainBodyEle);
			break;
		case "email":
			this.email(mainBodyEle);
			break; 
		case "currentAddress":
			this.currentAddress(mainBodyEle); 
			break;
		case "permanentAddress":
			this.permanentAddress(mainBodyEle);
			break; 
		case "all":
			this.textBoxFull(mainBodyEle);
			break;
		}
	}
	
	
	public void textBoxFull( WebElement mainBodyEle) {
		
//		WebElement mainBodyEle = driver.findElement(By.id("app"));
//		
//		
//		WebElement textBoxIcon = driver.findElement(By.id("item-0"));
//		textBoxIcon.click();
		
		WebElement userNameEle = driver.findElement(By.id("userName"));
		userNameEle.sendKeys("Praveen Viswanathan");
		
		WebElement emailId = driver.findElement(By.id("userEmail"));
		emailId.sendKeys("abcdef@gmail.com");
		
		WebElement curAddressEle = driver.findElement(By.id("currentAddress"));
		curAddressEle.sendKeys("123/09, chennai 600002");
		
		
		WebElement perAddressELe = driver.findElement(By.id("permanentAddress"));   
		perAddressELe.sendKeys("09/8, Nagapatinam, 600002");
		
//		WebElement stmBtnEle = mainBodyEle.findElement(By.id("submit"));
//		stmBtnEle.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement stmBtnEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
//		stmBtnEle.click();
		
		WebElement stmBtnEle = driver.findElement(By.id("submit"));

		// Scroll into view
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stmBtnEle);
		 // small wait after scroll
//		try {
//		    Thread.sleep(3000); // Pause 3 seconds
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}
		
//		Thread.sleep(3000);

		// Click using JavaScript to avoid ad/frame blocking
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stmBtnEle);
		
		WebElement outputEle = driver.findElement(By.id("output"));
		System.out.println( outputEle.getText()); 
		
	}
	
	
	public void fullName( WebElement mainBodyEle ) {
		
		
		WebElement userNameEle = mainBodyEle.findElement(By.id("userName"));
		userNameEle.sendKeys("Praveen Viswanathan");
	}
	
	
	public void email( WebElement mainBodyEle ) {
		
		
		WebElement emailId = mainBodyEle.findElement(By.id("userEmail"));
		emailId.sendKeys("abcdef@gmail.com");
	}
	
	public void currentAddress(WebElement mainBodyEle) {
		
		
		WebElement curAddressEle = mainBodyEle.findElement(By.id("currentAddress"));
		curAddressEle.sendKeys("123/09, chennai 600002");
		
	}
	
	public void permanentAddress( WebElement mainBodyEle ) {
		
		WebElement perAddressELe = mainBodyEle.findElement(By.id("permanentAddress"));   
		perAddressELe.sendKeys("09/8, Nagapatinam, 600002");
	}
	
}
