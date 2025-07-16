package TestingProjects.DemoQA;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxBinary.Channel;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Array;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ElementClickInterceptedException;
//import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
    	WebDriver driver = null;
    	try {
    	System.setProperty("webdriver.gecko.driver", "/Users/praveen-23755/Downloads/firefox/geckodriver");
//    	FirefoxBinary binary = new FirefoxBinary(new java.io.File("/Applications/Firefox.app/Contents/MacOS/firefox")); 
//		
//		FirefoxOptions options = new FirefoxOptions();
//        options.setBinary(binary);
    	
    	driver = new FirefoxDriver();
    	driver.manage().window().fullscreen();
    	
    	
//    	TextBox myTextBox01 = new TextBox( driver );
//    	
//    	
//    	myTextBox01.textBoxTest("all");
//    	
//    	myTextBox01.textBoxTest("fullName");
//    	
//    	myTextBox01.textBoxTest("email");
//    	
//    	myTextBox01.textBoxTest("currentAddress");
//    	
//    	myTextBox01.textBoxTest("permanentAddress");
//    	
//    	
//    	
//    	
//    	
//    	CheckBox myCheckBox = new CheckBox( driver );
//
//    	
//    	myCheckBox.clickTheElement("Home");
//    	myCheckBox.clickTheElement("Desktop");
//    	myCheckBox.clickTheElement("Notes");
//    	myCheckBox.clickTheElement("Commands");
//    	myCheckBox.clickTheElement("Documents"); 
//    	myCheckBox.clickTheElement("WorkSpace"); 
//    	myCheckBox.clickTheElement("Word File.doc");
//    	myCheckBox.clickTheElement("Excel File.doc");
//    	
//    	
//    	myCheckBox.clickTheElement( new ArrayList<>(Arrays.asList("Notes", "Documents", "Excel File.doc")) );
//    	myCheckBox.clickTheElement( new ArrayList<>(Arrays.asList("Notes", "Angular","Public", "Excel File.doc")) );
//    	myCheckBox.clickTheElement( new ArrayList<>(Arrays.asList("Desktop", "Downloads", "Veu", "Excel File.doc")) );
//    	
//    	
//    	
//    	
//    	RatioButton myRatioBtn = new RatioButton( driver );
//    	
//    	myRatioBtn.clickRatio( "Yes" ); 
//    	myRatioBtn.clickRatio( "No" ); 
//    	myRatioBtn.clickRatio( "Impressive" ); 
//    	
//    	
//    	WebTabs myWebTabs = new WebTabs( driver );
//    	myWebTabs.openWebtab();
//    	
//    	myWebTabs.addItems("hjkjhbnm", "Viswanart", "abc@hghb.com", "201", "10000000000", "ZOHO");
//
//    	myWebTabs.searchItem("1");
//    	
//    	myWebTabs.delectItem("delete-record-" + 1);
//    	
//    	myWebTabs.searchDelect("1");
//    	
//    	myWebTabs.editItem("edit-record-1","Praveen", "V", "abc@gamil.com", "21", "50000", "CRM");
//    	
//    	myWebTabs.searchByedit("Legal", "Praveen", "V", "abc@gamil.com", "21", "50000", "CRM"); 
//    	
//    	ButtonsClick myBtnEle = new ButtonsClick( driver );
//    	myBtnEle.openBtntab();
//    	
//    	myBtnEle.doubleClick();
//    	myBtnEle.rightClick();
//    	myBtnEle.dynamicClick();
//    	
//    	
//    	LinksClick myLinkEle = new  LinksClick(driver); 
//    	myLinkEle.openLink();
//    	
//    	myLinkEle.linkOpenNewTab("simpleLink"); 
//    	myLinkEle.linkOpenNewTab("dynamicLink"); 
//    	
//    	myLinkEle.apiCall("created");
//    	myLinkEle.apiCall("no-content");
//    	myLinkEle.apiCall("moved");
//    	myLinkEle.apiCall("bad-request");
//    	myLinkEle.apiCall("forbidden");
//    	myLinkEle.apiCall("invalid-url");
//    	
//    	BrokenLinksImage myBrokenEle = new BrokenLinksImage( driver );
//    	myBrokenEle.openImage();
//    	
//    	myBrokenEle.getValidLink();
//    	
//    	myBrokenEle.getBrokenLink();
    	
    	
//    	UploadAndDownload myuploadEle = new UploadAndDownload( driver );
//    	myuploadEle.openUpload();
//    	
//    	myuploadEle.uploadFile("/Users/praveen-23755/Downloads/sampleFile.jpeg");
//    	
//    	myuploadEle.downloadFile();
    	
    	
//    	DynamicProperties myDynamicEle = new DynamicProperties( driver );
//    	myDynamicEle.openDynamicTab(); 
//    	
//    	myDynamicEle.openLateBtn();
//    	myDynamicEle.colorBtn();
//    	myDynamicEle.lateVisibleBtn();
    	
//    	PractiesForm myFormEle = new PractiesForm( driver ); 
    	
//    	myFormEle.fillTheForm();  
    	
//    	BroserWindow myBroserWindowEle = new BroserWindow( driver );
//    	myBroserWindowEle.openNewTab();
    	
//    	myBroserWindowEle.openNewWindow();
    	
//    	myBroserWindowEle.openNewWindowMessage();
    	
    	
//    	AlertMessage myAlert = new AlertMessage( driver ); 
//    
//    	myAlert.openSeeAlert();
    	
//    	myAlert.openSeeLaterAlert();
    	
//    	myAlert.openSeeWithCheckAlert();

//    	myAlert.openSeePromtAlert();
    	
    	
    	
//    	Frames myFrame = new Frames(driver); 
//    	
//    	myFrame.goToFrameOne();
//    	myFrame.goBack();
//    	myFrame.goToFrameTwo();
    	
    	
//    	NestedFrame myNestedFrame = new NestedFrame( driver );
//    	myNestedFrame.open();
//    	
//    	myNestedFrame.goToNestedFram();
//    	myNestedFrame.goMain();
//    	myNestedFrame.goToOuterFrame(); 
    	
    	
//    	ModalDialogs myModalELe = new ModalDialogs(driver); 
//    	myModalELe.openSmallModal();
//    	myModalELe.openBigModal();
    	
    	
//    	Widgets myWidgetsEle = new Widgets( driver );
//    	myWidgetsEle.open();
    	
//    	myWidgetsEle.Accordian( "section1" ); 
//    	myWidgetsEle.Accordian( "section2" ); 
//    	myWidgetsEle.Accordian( "section3" ); 

//    	myWidgetsEle.autoComplete("Yellow");
//    	
//    	List<String> list = new ArrayList<>( Arrays.asList("yellow", "Black"));
//    	myWidgetsEle.autoComplete( list );
    	
//    	myWidgetsEle.datePicker("2014/12/01");
//    	myWidgetsEle.dateTimePicker("2025-07-04T14:30");   // Format is very important this method only accepts Format: yyyy-MM-ddTHH:mm  
    	
//					    	import java.time.LocalDateTime;
//					    	import java.time.format.DateTimeFormatter;
//					
//					    	public class FormatDateTime {
//					    	    public static void main(String[] args) {
//					    	        String input = "04-07-2025 14:30";
//					    	        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//					    	        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//					
//					    	        LocalDateTime dateTime = LocalDateTime.parse(input, inputFormat);
//					    	        String formatted = dateTime.format(outputFormat);
//					
//					    	        System.out.println("Formatted: " + formatted);  // 2025-07-04T14:30
//					    	    }
//					    	}

    	
    	
//    	myWidgetsEle.silderSetValue();
    	
//    	myWidgetsEle.progressBar(4);
    	
//    	myWidgetsEle.tabs("What");
//    	myWidgetsEle.tabs( "Orgin");
//    	myWidgetsEle.tabs( "Use" ); 
    	
//    	myWidgetsEle.toolTips(); 
    	
    	
//    	myWidgetsEle.menu("3"); 
//    	myWidgetsEle.menu("1");
//    	myWidgetsEle.menu("21");
//    	myWidgetsEle.menu("232");  
    	
//    	myWidgetsEle.selectMenu( "Group 1, option 1");
    	
//    	myWidgetsEle.selectOne("Mr.");
//    	myWidgetsEle.selectOne("Mrs.");
//    	myWidgetsEle.selectOne("Dr.");
    	
//    	myWidgetsEle.oldSelect("3"); 
    	
//    	List<String> list1 = new ArrayList<>( Arrays.asList("Green", "Black"));
//    	myWidgetsEle.selectMultiple( list1 );
    	
//    	List<String> list2 = new ArrayList<>( Arrays.asList("Volvo", "Opel"));
//    	myWidgetsEle.newSelect(list2); 
    	
    	
//    	Sortable mySortableEle = new Sortable( driver ); 
//    	mySortableEle.open(); 
//    	
//    	mySortableEle.chooseView("Grid");
//    	mySortableEle.selectIten("Three");
//    	
//    	Selectable mySelectableEle = new Selectable( driver); 
//    	mySelectableEle.open();
//    	
//    	List<String> elements1 = new ArrayList<>( Arrays.asList("Cras justo odio", "Porta ac consectetur ac", "Dapibus ac facilisis in"));
//    	mySelectableEle.chooseView("List");
//    	mySelectableEle.selectItem( elements1 ); 
//    	
//    	List<String> elements2 = new ArrayList<>( Arrays.asList("One", "Two", "Three", "Five", "Nine", "Seven"));
//    	mySelectableEle.chooseView("Grid");
//    	mySelectableEle.selectItem( elements2 ); 

    	
//    	Resizable myResizableEle = new Resizable( driver ); 
//    	myResizableEle.open();
//    	
//    	myResizableEle.resizeLimit(300, 100); 
//    	
//    	myResizableEle.resizeUnLimited(900, 300);
    	
//    	Droppable myDroppableEle = new Droppable( driver ); 
//    	myDroppableEle.open();
//    	
//    	myDroppableEle.simple();
//    	myDroppableEle.accept(1);
//    	myDroppableEle.accept(0);
    	
//    	myDroppableEle.preventPropogation("outerBoxNot");
//    	myDroppableEle.preventPropogation("innerBoxNot");
//    	myDroppableEle.preventPropogation("outerBox");
//    	myDroppableEle.preventPropogation("innerBox");
//    	
//    	myDroppableEle.revertDraggable(1); 
//    	myDroppableEle.revertDraggable(0);
    	
    	
    	Dragabble myDragabbleEle = new Dragabble(driver); 
    	myDragabbleEle.open();
    	
//    	myDragabbleEle.simple(80, 0);
//    	myDragabbleEle.axisRestriction("Y", 90); 
//    	myDragabbleEle.containerRestriction(10,100);
    	myDragabbleEle.styleCurser(100, 0, 0, 200, 50, 60);
    	
    	
    	
    	}catch(Exception e) {
    		e.printStackTrace();
//    		System.out.println( e );
    	}finally {
    		driver.quit();
    	}
    	
    }
}







