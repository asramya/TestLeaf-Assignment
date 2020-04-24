package week4;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC01_ServiceNow {
	public static void main(String[] args) throws InterruptedException {

		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Launch the ServiceNow application
		driver.get("https://dev92474.service-now.com/");

		// 2. Login with valid credentials username as admin and password as India@123	
		//switch to iframe
		driver.switchTo().frame("gsft_main");
		//Enter the username
		driver.findElementByName("user_name").sendKeys("admin");
		//Enter the password
		driver.findElementByName("user_password").sendKeys("India@123");
		//Click Login
		driver.findElementById("sysverb_login").click();

		// 3. Enter change in filter navigator and press enter
		driver.findElementById("filter").sendKeys("CHANGE");	
		Thread.sleep(3000);

		// 4. Click on Create new option
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();

		//switch to iframe
		driver.switchTo().frame("gsft_main");

		// 5. Create new normal Change by filling mandatory fields
		driver.findElementByXPath("//html/body/form/div[2]/a").click();
		
		//Get the change request number
		String value = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(value);
		// Enter the text in mandatory field short description
		driver.findElementById("change_request.short_description").sendKeys("Short Descp");
		// Click Submit button
		driver.findElementById("sysverb_insert_bottom").click();
			
		//search for the newly created request
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(value,Keys.ENTER);
	
		// Click on newly created change request in search
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		Thread.sleep(3000);
		
		// Verify the change Number
		String ncr = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("change Number:"+ncr);
		if (ncr.contains(value)) {
			System.out.println("created successfully ");
		}
		else {
			System.out.println("created unsuccessfully");
		}
		driver.close();



	}



}


