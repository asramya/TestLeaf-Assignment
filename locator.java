package week1Day3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;

public class locator {

	public static void main(String[] args) {


		// add system property -> webdriver.chrome.driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Open the chrome browser
		// ChromeDriver (C) -> Written by Selenium Team
		ChromeDriver driver = new ChromeDriver();

		// Load the URL :: get ->
		//driver.get("http://leaftaps.com/opentaps/control/main");



		// driver.get("https://google.co.in"); // get() & navigate().to()
		driver.navigate().to("https://google.co.in");	

		// Print the title
		String title = driver.getTitle();
		System.out.println(title);

		// Refresh the screen/page
		driver.navigate().refresh();


		// Find the method -> Print the full URL 
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// Print the browser name or version		
		String browserName = driver.getCapabilities().getBrowserName();
		System.out.println(browserName);

		String version = driver.getCapabilities().getVersion();
		System.out.println(version);

		Platform platform = driver.getCapabilities().getPlatform();
		System.out.println(platform);	

		//Navigate backwards
		//driver.navigate().back();

		// close the browser
		driver.close();

	}



}
