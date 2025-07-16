package TestingProjects.DemoQA;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTabs extends Elements {
	
	WebDriver driver;
	WebElement mainBodyEle;
	
	WebTabs( WebDriver driver) {
		this.driver = driver;
		
	}
	
	void openWebtab() {
		this.openElements(driver);
		
		mainBodyEle = driver.findElement(By.id("app")); 
		
		WebElement webTabIcon = driver.findElement(By.id("item-3"));
		webTabIcon.click(); 
	}
	
	void addItems(String firstName, String LastName, String email, String age, String salary, String department) {
//		this.openWebtab();
		
		WebElement addBtn = mainBodyEle.findElement(By.id("addNewRecordButton")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", addBtn);
		
		WebElement formELement = driver.findElement(By.id("userForm")); 
		
		
		WebElement formFirstName = formELement.findElement(By.id("firstName-wrapper")).findElement(By.tagName("input"));
		formFirstName.sendKeys(firstName);
		
		WebElement formLastName = formELement.findElement(By.id("lastName"));
		formLastName.sendKeys(LastName);
		
		WebElement formMail = formELement.findElement(By.id("userEmail"));
		formMail.sendKeys(email);
		
		WebElement formAge = formELement.findElement(By.id("age")); 
		formAge.sendKeys(age);
		
		WebElement formSalary = formELement.findElement(By.id("salary"));
		formSalary.sendKeys(salary);
		
		WebElement formDepartment = formELement.findElement(By.id("department"));
		formDepartment.sendKeys(department);
		
		WebElement formSubmitBtn = formELement.findElement(By.id("submit"));
		( (JavascriptExecutor) driver).executeScript("arguments[0].click()", formSubmitBtn);
	}
	
	
	List<WebElement> searchItem(String key) {
//		this.openWebtab();
		
		WebElement searchEle = mainBodyEle.findElement(By.id("searchBox"));
		searchEle.sendKeys(key);
		//((JavascriptExecutor) driver).executeScript("arguments[0].submit()", searchEle); 
		
		List<WebElement> resultList = mainBodyEle.findElements(By.className("rt-tr-group"));
		
		int i = 0;
		while (i < resultList.size()) {
			if ( resultList.get(i).getText().isBlank()) {
				resultList.remove(i);
			}else {
				System.out.println( resultList.get(i).getText());
				i++;
			}
			
		}
			
//		for ( int i = 0; i<resultList.size(); i++) {
//			
//			if ( resultList.get(i).getText().isBlank()) {
//				resultList.remove(i)
//			}else
//				System.out.println( resultList.get(i).getText());
//		}
//		
		searchEle.clear();
		return resultList;
		
	}
	
	void delectItem(String id) {
//		this.openWebtab();
		WebElement delectIcon = mainBodyEle.findElement(By.id(id)); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", delectIcon);
	}
	
	
	void searchDelect( String key) {
		List<WebElement> resultList = this.searchItem(key);
		
		System.out.println(resultList);
		
		List<String> deleteItem = new ArrayList<>(); 
		
		for (int i = 0; i<resultList.size(); i++) {
			WebElement cur = resultList.get(i).findElement(By.cssSelector("span[title='Delete']"));
			deleteItem.add( cur.getAttribute("id") );
				
		}
		
		
		
		for (String i : deleteItem) {
			WebElement delectIcon = mainBodyEle.findElement(By.id(i)); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", delectIcon);
		}
		
	}
	
	void editItem( String id, String firstName, String LastName, String email, String age, String salary, String department) {
		
//		this.openWebtab();
		
		WebElement addBtn = mainBodyEle.findElement(By.id(id)); 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", addBtn);
		
		WebElement formELement = driver.findElement(By.id("userForm")); 
		
		
		WebElement formFirstName = formELement.findElement(By.id("firstName-wrapper")).findElement(By.tagName("input"));
		formFirstName.clear();
		formFirstName.sendKeys(firstName);
		
		WebElement formLastName = formELement.findElement(By.id("lastName"));
		formLastName.clear();
		formLastName.sendKeys(LastName);
		
		WebElement formMail = formELement.findElement(By.id("userEmail"));
		formMail.clear();
		formMail.sendKeys(email);
		
		WebElement formAge = formELement.findElement(By.id("age")); 
		formAge.clear();
		formAge.sendKeys(age);
		
		WebElement formSalary = formELement.findElement(By.id("salary"));
		formSalary.clear();
		formSalary.sendKeys(salary);
		
		WebElement formDepartment = formELement.findElement(By.id("department"));
		formDepartment.clear();
		formDepartment.sendKeys(department);
		
		WebElement formSubmitBtn = formELement.findElement(By.id("submit"));
		( (JavascriptExecutor) driver).executeScript("arguments[0].click()", formSubmitBtn);
		
	}
	
	void searchByedit(String key, String firstName, String LastName, String email, String age, String salary, String department) {
		List<WebElement> resultitem = this.searchItem(key);
		System.out.println(resultitem);
		for (WebElement i : resultitem) {
			WebElement cur = i.findElement(By.cssSelector("span[title='Edit']"));
			String id = cur.getAttribute("id");
			this.editItem(id,firstName, LastName, email, age, salary, department);   
		}
	}
	
}































