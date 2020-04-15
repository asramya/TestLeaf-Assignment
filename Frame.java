package week3.Day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// Lauch the URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		//switct to alert by id
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
		
		System.out.println("Alert is accepted");
		
		driver.close();
		
		

		




	}
}
