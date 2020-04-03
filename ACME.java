package week1.Day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACME {

	public static void main(String[] args) throws InterruptedException {
		
		// LauNch the chrome browser

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("https://acme-test.uipath.com/account/login");
		// Enter Username
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		// Enter password
		driver.findElementById("password").sendKeys("leaf@12");
		// Click login
		driver.findElementById("buttonLogin").click();
		
		//Click on Vendor
		WebElement ele = driver.findElementByXPath("(//button[contains(@class,'btn btn-default')])[5]");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();

		//Click on Search for Vendor
		driver.findElementByLinkText("Search for Vendor").click();
		
		// Enter vendor Name
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		// Click Search
		driver.findElementById("buttonSearch").click();

		//Find the Country Name based on the Vendor
		String country =(driver.findElementByXPath("//table/tbody/tr[2]/td[5]")).getText(); 		
		System.out.println(" For vendor Blue Lagoo the country is " + country);
			
		//Click Logout	
		driver.findElementByLinkText("Log Out").click();
			
		//close browser
		driver.close();
		


	}

}
