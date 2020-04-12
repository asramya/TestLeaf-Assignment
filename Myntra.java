package week2.Day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	/*1) Open https://www.myntra.com/
		2) Mouse over on WOMEN (Actions -> moveToElement
		3) Click Jackets & Coats
		4) Find the total count of item (top) -> getText -> String

			 String str = driver.findElementByClassName("title-count").getText();
			 split, 
			 String text = str.replaceAll("\\D","") -> String
			 Integer.parseInt(text) -> int

		5) Validate the sum of categories count matches
		6) Check Coats
		7) Click + More option under BRAND	
		8) Type MANGO and click checkbox
		9) Close the pop-up x
		10) Confirm all the Coats are of brand MANGO
		    findElements (brand) -> List<WebElement> 
		    foreach -> getText of each brand 
		    compare > if(condition)
		11) Sort by Better Discount
		12) Find the price of first displayed item
		     findElements (price) -> List<WebElement> 
		     get(0) -> WebElement -> getText -> String -> int
		13) Mouse over on size of the first item
		14) Click on WishList Now
		15) Close Browser*/

	public static void main(String[] args) throws InterruptedException {

		// to launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com");

		Thread.sleep(3000);

		//2)Mouse over on WOMEN (Actions -> moveToElement
		WebElement women = driver.findElementByXPath("//div//a[text()='Women']");

		Actions builder =new Actions(driver);
		builder.moveToElement(women).perform();

		Thread.sleep(3000);

		WebElement jacket = driver.findElementByXPath("//div//li//a[contains(text(),'Jackets & Coats')]");

		Thread.sleep(3000);

		//3) Click Jackets & Coats
		builder.moveToElement(jacket).click().perform();

		//Find the total count of item (top) -> getText -> String
		String count = driver.findElementByClassName("title-count").getText();	
		String text = count.replaceAll("\\D","");
		int tc = Integer.parseInt(text);
		System.out.println("Total count: " + tc );

		//5) Validate the sum of categories count matches
		String j1 = driver.findElementByXPath("(//label[@class='common-customCheckbox vertical-filters-label'])[1]").getText();
		String j2 = j1.replaceAll("\\D","");
		int j3 = Integer.parseInt(j2);
		System.out.println("Jacket count: " + j2);
		String c1 = driver.findElementByXPath("(//label[@class='common-customCheckbox vertical-filters-label'])[2]").getText();
		String c2 = c1.replaceAll("\\D","");
		int c3 = Integer.parseInt(c2);
		System.out.println("Coats Count: " + c3);	
		int total = j3 + c3 ;	
		System.out.println("Jackets and Coats count: "+ total);
		if (total == tc)

		{

			System.out.println("Total count is matched with sum of categories");
		}	 
		else{
			System.out.println("Total count is not matched with sum of categories");
		}

		// 6) Check Coats
		driver.findElementByXPath("//label[text()='Coats']/div").click();

		Thread.sleep(3000);

		//7) Click + More option under BRAND
		driver.findElementByXPath("//*[@class='brand-more']").click();

		// 8) Type MANGO and click checkbox
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("mango");

		Thread.sleep(3000);

		//driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div").click();

		driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div[1]").click();

		// 9) Close the pop-up x
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();

		// 10) Confirm all the Coats are of brand MANGO


		Thread.sleep(3000);

		List<WebElement> brand = driver.findElementsByXPath("//h3[@class='product-brand']");
		System.out.println("Nuber of coats of brand MANGO " + brand.size());
		for (WebElement each : brand) 
			if(!each.getText().contains("MANGO")) {
				System.out.println("Other Brand");
			}


		System.out.println("Verified-Mango Brand");


		//11) Sort by Better Discount
		WebElement sort = driver.findElementByXPath("//*[@class='sort-sortBy']");
		Actions builder1 =new Actions(driver);
		builder1.moveToElement(sort).perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//label[text()='Better Discount']").click();


		//12) Find the price of first displayed item
		List<WebElement> discount = driver.findElementsByClassName("product-discountedPrice");
		String firstdisplayed = discount.get(0).getText();
		String price = firstdisplayed.replaceAll("\\D","");
		int amount = Integer.parseInt(price);
		System.out.println("Price of first displayed item " + amount);

		//13) Mouse over on size of the first item
		WebElement size = driver.findElementByXPath("(//h3[text()='MANGO'])[1]");
		builder.moveToElement(size).perform();

		//14) Click on WishList Now
		driver.findElementByXPath("(//div[@class='product-actions product-prelaunchActions'])[1]/span").click();

		//15) Close Browser
		driver.close();

	}




}


