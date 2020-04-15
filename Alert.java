package week3.Day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// Lauch the URL
		driver.get("http://leafground.com/pages/Alert.html");

		//Click the button to display a alert box.
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		//Switch to Alert
		org.openqa.selenium.Alert alert = driver.switchTo().alert();

		//Accept the alert
		alert.accept();

		System.out.println("Alert is Accepted");

		//Click the button to display a confirm box.
		driver.findElementByXPath("//button[text()='Confirm Box']").click();

		//Cancel or dismiss the alert
		alert.dismiss();

		System.out.println("Alert is dismissed");
		//Click the button to display a prompt box.
		// Confirm Alert
		driver.findElementByXPath("//button[text()='Prompt Box']").click();

		//Send data to alert
		//Prompt Alert
		alert.sendKeys("WoltersKulwer");	
		System.out.println("Data is entered");
		alert.accept();


		//Click the below button and click OK.
		// Sweet Alert
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='OK']").click();


		System.out.println("Sweet Alert is handled");





	}
}
