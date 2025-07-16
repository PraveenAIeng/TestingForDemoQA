package TestingProjects.DemoQA;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractiesForm extends Forms{
	
	WebDriver driver;
	private Map<String, String> hobbiesId = new HashMap<>();
	
	PractiesForm( WebDriver driver) {
		this.driver = driver; 
		this.openForm(driver);
		
		hobbiesId.put("Sports", "hobbies-checkbox-1");
		hobbiesId.put("Reading", "hobbies-checkbox-2");
		hobbiesId.put("Music", "hobbies-checkbox-3");
	}
	
	
	
	void fillTheForm( ) {
		
		List<String> hobbie = new ArrayList<>();
    	hobbie.add("Sports");
    	hobbie.add("Music");
		
		User myUser = new User.Builder()
				.setFirstName("Praveen")
				.setLastName("Viswanathan")
				.setEmail("abcd@gmail.com")
				.setAge("20")
				.setGender("male")
				.setDob("21-12-2005")
				.setMobile("9876543210")
				.setCurrentAddress("Address address")
				.setHobbies( hobbie )
				.setState("NCR")
				.setSubject("Maths")
				.setPicturePath("/Users/praveen-23755/Downloads/sampleFile.jpeg")
				.setCity("Delhi")
				.build();
		
		WebElement firstNameEle = this.formElement.findElement(By.id("firstName"));
		firstNameEle.sendKeys(myUser.getFirstName()); 
		
		WebElement lastNameELe = formElement.findElement(By.id("lastName"));
		lastNameELe.sendKeys(myUser.getLastName());
		
		WebElement emailEle = this.formElement.findElement(By.id("userEmail"));
		emailEle.sendKeys(myUser.getEmail()); 
		
		switch ( myUser.getGender()) {
		case "male":
			WebElement maleEle = this.formElement.findElement(By.id("gender-radio-1"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", maleEle); 
			break;
		case "female":
			WebElement femaleEle = this.formElement.findElement(By.id("gender-radio-2"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", femaleEle); 
			break;
		case "others":
			WebElement otherEle = this.formElement.findElement(By.id("gender-radio-3"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", otherEle); 
			break;
		}
		
		WebElement mobileEle = this.formElement.findElement(By.id("userNumber"));
		mobileEle.sendKeys(myUser.getMobile());
		
//		WebElement dobEle = this.formElement.findElement(By.id("dateOfBirthInput"));
//		dobEle.sendKeys( dob ); 
		
		WebElement subjectEle = this.formElement.findElement(By.id("subjectsInput"));
		subjectEle.sendKeys(myUser.getSubject());
		subjectEle.sendKeys(Keys.TAB);
		
		int i;
		WebElement curEle;
		List<String> curHobbies = myUser.getHobbies();
		for (i = 0; i<curHobbies.size(); i++) {
			curEle = this.formElement.findElement(By.id( hobbiesId.get( curHobbies.get(i) )));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", curEle); 
			
		}
		
		WebElement selectPictureEle = this.formElement.findElement(By.id("uploadPicture"));
		selectPictureEle.sendKeys( myUser.getPicturePath() );
		
		
		WebElement curentAddressEle = this.formElement.findElement(By.id("currentAddress")); 
		curentAddressEle.sendKeys( myUser.getCurrentAddress());
		
		WebElement stateEle = this.formElement.findElement(By.id("react-select-3-input"));
		stateEle.sendKeys( myUser.getState() );
		stateEle.sendKeys(Keys.TAB);
		
		WebElement cityEle = this.formElement.findElement(By.id("react-select-4-input"));
		cityEle.sendKeys( myUser.getCity() );
		cityEle.sendKeys(Keys.ENTER);
		cityEle.submit();
	}

}
