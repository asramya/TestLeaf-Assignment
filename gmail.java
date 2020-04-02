package week1.day2;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail {

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();


		driver.get("http://www.leafground.com/pages/Edit.html");


		driver.findElementById("email").sendKeys("test@test.com");
		driver.findElementByXPath("//input[@value='Append ']").clear();
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("TestData");
		String att = driver.findElementByName("username").getAttribute("value");
		System.out.println(att);
		
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		System.out.println( driver.findElementByXPath("//input[@disabled='true']").isEnabled());







	}



}
