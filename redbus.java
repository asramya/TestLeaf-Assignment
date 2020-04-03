package week1.Day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class redbus {

	public static void main(String[] args) throws InterruptedException 

	{
		// Launch the chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Launch the URL
		driver.get("https://www.redbus.in/");
		//Enter 'from' place as 'Chennai'
		driver.findElementByXPath("//*[@id='src']").sendKeys("Chennai (All Locations)");			
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@id='src']").sendKeys(Keys.TAB);
		
		//Enter 'to' place as 'Bangalore'
		driver.findElementById("dest").sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@id='src']").sendKeys(Keys.TAB);
		
		// Click on onward date
		driver.findElementByXPath("//*[@id='search']/div/div[3]/span").click();
		driver.findElementByXPath("(//td[text()='30'])[2]").click();	
		Thread.sleep(3000);
		
		//Click on 'Search Buses'
		driver.findElementById("search_btn").click();
	
		// Click Check 'After 6 pm' under 'DEPARTURE TIME'
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		
		// Check 'Sleeper' under 'BUS TYPE'
		driver.findElementByXPath("//*[@for='bt_SLEEPER']").click();
		Thread.sleep(3000);
		
		// Click on 'Seats Available' to sort
		driver.findElementByLinkText("Seats Available").click();

		System.out.println("Seats Available is clicked");


	}

}
