package LearnNew;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Set path to geckodriver (Firefox)
        System.setProperty("webdriver.gecko.driver", "/Users/praveen-23755/Downloads/firefox/geckodriver"); // <-- Change this

        WebDriver driver = new FirefoxDriver();

        try {
            // STEP 1: Open first tab and go to Google
            driver.get("https://www.google.com");
            Thread.sleep(2000);  // Wait for page to load

            // Search for "Selenium WebDriver"
            WebElement searchBox1 = driver.findElement(By.name("q"));
            searchBox1.sendKeys("Selenium WebDriver");
            searchBox1.sendKeys(Keys.RETURN);
            Thread.sleep(3000); // Let the results load

            // STEP 2: Open a new tab using JavaScript
            ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

            // STEP 3: Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));  // Switch to second tab

            // STEP 4: Open Google and search for "Java Automation"
            driver.get("https://www.google.com");
            Thread.sleep(2000);

            WebElement searchBox2 = driver.findElement(By.name("q"));
            searchBox2.sendKeys("Java Automation");
            searchBox2.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            // STEP 5: Done. You now have two tabs with different searches.
            System.out.println("Searches completed in two tabs.");

        } finally {
            Thread.sleep(3000); // Wait before closing
            driver.quit(); // Close all tabs and browser
        }
    }
}
