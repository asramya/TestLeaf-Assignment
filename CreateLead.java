package week2.day3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {


	//		1. load the URL - http://leaftaps.com/opentaps/control/main
	//		2. Login as user -> DemoSalesManager & password -> crmsfa
	//		3. Click on CRM/SFA
	//		4. Click on Create Lead
	//		5. Enter mandatory fields - Company Name, First Name & Last Name
	//		6. Click on Submit
	//		7. Verify lead has been created using title
	//		8. Close browser


	public static void main(String[] args) {

		// to launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// to launch the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		//driver.navigate().to("http://leaftaps.com/opentaps/control/main");

		//enter Username
		driver.findElementById("username").sendKeys("DemoSalesManager");

		//enter Password
		driver.findElementById("password").sendKeys("crmsfa");

		// click login
		driver.findElementByClassName("decorativeSubmit").click();


		//click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();

		//click on Create Lead
		driver.findElementByLinkText("Create Lead").click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Get title in create lead page
		String title1 = driver.getTitle();
		//System.out.println(" title in the create lead page : " + title1);

		//enter Company name
		driver.findElementById("createLeadForm_companyName").sendKeys("WoltersKulwer");

		// enter Forename
		driver.findElementById("createLeadForm_firstName").sendKeys("Ramya");

		//enter Surname
		driver.findElementById("createLeadForm_lastName").sendKeys("A");
		
		
		// Choose the dropdown source using one of the text
		
		WebElement ddown1 = driver.findElementByName("dataSourceId");
		Select dd1 = new Select(ddown1);
		dd1.selectByVisibleText("Conference");
		
		
		//Choose Industry dropdown the last index
		WebElement ddown2 = driver.findElementByName("industryEnumId");
		Select dd2 = new Select(ddown2);
		List<WebElement> options = dd2.getOptions();
		int size = options.size();
		System.out.println(size);
		dd2.selectByIndex(size-1);
		System.out.println(ddown2.isSelected());
	
		
		
	
		
		
		
		

		/*//click Create Lead button
		driver.findElementByClassName("smallSubmit").click();

		//Verify the lead is created
		String title2 = driver.getTitle();
		System.out.println(" title in the view lead page : " + title2);	System.out.println(title2);
		String 	title3 ="View Lead | opentaps CRM";

		if (title2.equalsIgnoreCase(title3))
		{
			System.out.println(" Lead is created");
		}else
			System.out.println(" Lead is not created");
*/
		// close browser
		//driver.close();

	}


}
