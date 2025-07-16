package TestingProjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicProperties extends Elements {
	WebDriver driver;
	WebElement mainBodyEle;
	
	DynamicProperties( WebDriver driver ) {
		this.driver = driver;
	}
	
	public static String rgbaToHex(String rgba) {
        rgba = rgba.replace("rgb(", "").replace(")", "");
        String[] parts = rgba.split(",");

        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());

        return String.format("#%02x%02x%02x", r, g, b);
    }
	
	void openDynamicTab() {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app"));
		
		WebElement dynamicIcon = driver.findElement(By.id("item-8"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", dynamicIcon); 
 	}
	
	void openLateBtn( ) {
		try {
			WebElement lateBtnEle = mainBodyEle.findElement(By.id("enableAfter"));
			
			if ( !lateBtnEle.isEnabled() ) {
				System.out.println( "Button is not Enabled");
			}
			
			Thread.sleep(5000);
			
			if ( lateBtnEle.isEnabled() ) {
				System.out.println( "Button is now Enabled after 5 sec");
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", lateBtnEle); 
			}
			
		}catch( Exception e) {
			System.out.println( e );
		}
	}
	
	void colorBtn() {
		String code;
		try {
			
			WebElement colorBtnEle = mainBodyEle.findElement(By.id("colorChange"));
			
			code = colorBtnEle.getCssValue( "color" );
			
			System.out.println( code);
			System.out.println( rgbaToHex(code) );

			
			Thread.sleep(5000);
			
			colorBtnEle = mainBodyEle.findElement(By.id("colorChange"));
			
			code = colorBtnEle.getCssValue( "color" );
			
			System.out.println( code);
			System.out.println( rgbaToHex(code) );
			
		}catch( Exception e) {
			System.out.println( e );
		}
		 
		
	}
	
	void lateVisibleBtn() {
		WebElement lateVisibleEle;
		try {
			lateVisibleEle = mainBodyEle.findElement(By.id("visibleAfter"));  
			if ( lateVisibleEle.isDisplayed() )
				System.out.println( "Late visible button is not Visible..");
			
			Thread.sleep(5000);
			
			lateVisibleEle = mainBodyEle.findElement(By.id("visibleAfter"));  
			if ( lateVisibleEle.isDisplayed() )
				System.out.println( "Late visible button is Now Visible after 5 sec...");
			
			
		} catch( Exception e) {
			System.out.println( e );
		}
	}
}
