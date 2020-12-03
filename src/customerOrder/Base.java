package customerOrder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {
WebDriver driver;// this has to be globe to use it amoung other methods in the class
	
	@BeforeMethod
	public void initialization() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakmi\\OneDrive\\Desktop\\drivers\\chromedriver.exe");
	//C:\Users\lakmi\OneDrive\Desktop\drivers\New folder
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.qatarairways.com/en-us/homepage.html");
	//System.out.println("print the title "+driver.getTitle());
	String pageTitle = driver.getTitle();
	//Assert.assertEquals("McDonald's: Burgers, Fries & More. Quality Ingredients.", pageTitle);

	
	}
	
	@AfterMethod
	public void BrowserClose() {
	//driver.quit();
	}
	
	@Test()
	public void changeLocation() 
	{
		
		WebElement radio1 = driver.findElement(By.xpath("//span[text()='Round trip']"));
		radio1.click();
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		
			System.out.println("print current url :"+ driver.getCurrentUrl());
		}
		
	
	
	
	   @Test()
	    public void doubleClickelement() throws InterruptedException
		
		{
			
			Actions action = new Actions(driver);
			WebElement fromkey = driver.findElement(By.xpath("//input[@id='T7-from']"));
			fromkey.sendKeys("New York (JFK)");
			action.moveToElement(fromkey).doubleClick().build().perform();
			
			WebElement toKey = driver.findElement(By.xpath("//input[@id='T7-to']"));
			toKey.sendKeys("Doha (DOH)");
			action.moveToElement(toKey).build().perform();
			
			//CALANDER ELEMENTS SELECTIONS
			WebElement depDate = driver.findElement(By.xpath("//input[@id='T7-departure_1']"));
			depDate.click();
			depDate.sendKeys("23 Dec 2020");
			depDate.click();
			
			//CALANDER ELEMENTS SELECTIONS
			WebElement retuenday = driver.findElement(By.xpath("//input[@id='T7-arrival_1']"));
			retuenday.click();
			retuenday.sendKeys("21 Feb 2021");
			retuenday.click();
			
			//SELECTING "PASSENGERS" WITH DIFFERENT TYPES AND DIFFERENT QUANTIIES WITH "DROPDOWN" SELECTIONS 
			WebElement passengerNum = driver.findElement(By.xpath("//input[@id='T7-passengers']"));
			passengerNum.click();
			WebElement identifier = driver.findElement(By.name("adults"));
			Select dropdown = new Select(identifier);
			dropdown.selectByVisibleText("2"); 
			WebElement identifier2 = driver.findElement(By.name("child"));
			Select dropdown2 = new Select(identifier2);
			dropdown2.selectByVisibleText("1");
			
			//CONFIRM THE DROPDOWN LIST
			driver.findElement(By.xpath("//input[@type='button'][@value='Confirm']")).click();
			
			//selecting check box by USING MOUSE OPERATIOS TO MOVE TO THE CHECKBOX
			WebElement cheakbox = driver.findElement(By.xpath("//input[@id='premiumOnly']"));
			action.moveToElement(cheakbox).click().build().perform();
			
			//click show flight button
			driver.findElement(By.xpath("//button[@id='T7-search']")).click();
			WebElement element1 = driver.findElement(By.xpath("//a[text()='Book with Qmiles']"));
   			element1.click();
   			action.moveToElement(element1).click().build().perform();
			
					
			System.out.println(" print alert :"+driver.getTitle());
		}
	   
	   		@Test
	   		public void bookWithQsmiles() {
	   			//driver.get("https://booking.qatarairways.com/nsp/views/fareSelection.xhtml?selLang=en");
	   			//Actions action = new Actions(driver);
   	   			//driver.findElement(By.linkText("Book with Qmiles")).click();
	   			//WebElement element1 = driver.findElement(By.xpath("//a[text()='Book with Qmiles']"));
	   			//element1.click();
	   			//action.moveToElement(element1).click().build().perform();
	   			//action.moveByOffset((int) 172.95, 43).click(element1).build().perform();
	   			
	   			System.out.println(" print alert :"+driver.getTitle());
	   			//driver.findElement(By.xpath("//*[@id="cpmBurgundyBanner"]/div/a)]")).click();
	   			//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	   			//for(int i= 0; i<frames.size(); i++) {
	   				//frames.get(i).click();
	   				//System.out.println(frames.get(i).getAttribute("id"));
	   				
	   			}
	   			
	   			//driver.switchTo().frame("frame_name");
	   			//driver.switchTo().frame("frame_id");
	   			//driver.switchTo().frame(0);
	   		}
		
		
		








