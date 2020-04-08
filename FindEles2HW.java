package week2.day2;

import java.util.List;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindEles2HW {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		
		//Go to images, Find out how many images are available
		driver.findElementByXPath("//img[@alt='Images']").click();
		List<WebElement> allImages = driver.findElementsByTagName("img");
		int  total = allImages.size();		
		System.out.println("Number of images available in the webpage" + total);
		
		//Find the last image by using the key board buttons
		allImages.get(total-1).click();
		
		//Go to radio buttons, find how many radio buttons 
		driver.navigate().back();
		driver.findElementByXPath("//img[@alt='Radio Button']").click();
		List<WebElement> allRadioButtons = driver.findElementsByXPath("//input[@type='radio']");
		int radioButtonSize = allRadioButtons.size();
		System.out.println(radioButtonSize);
		
		//Go to the check box, check all the check box(Mark/select all the check box ) using findElement
		driver.navigate().back();
		driver.findElementByXPath("//img[@alt='Checkbox']").click();
		List<WebElement> allcheckbox = driver.findElementsByXPath("//input[@type='checkbox']");	
		int totalCheckbox = allcheckbox.size();
		System.out.println(totalCheckbox);
		for (WebElement webElement : allcheckbox)
		{
			
				webElement.click();
		
		}
}
}
