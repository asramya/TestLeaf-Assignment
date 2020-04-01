package week1.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hw2Facebook {
	
	//Login to Facebook and logout in Chrome.
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		driver.findElementById("email").sendKeys("xxxx@test.com");
		driver.findElementById("pass").sendKeys("xxxxx");
		driver.findElementById("u_0_b").click();
			
		
		driver.findElementByLinkText("Account Settings").click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		driver.findElementByXPath("//span[contains(text(),'Log Out')]").click();
				
				
		
		
	}

}
