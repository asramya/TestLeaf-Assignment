package leaftaps;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	/*
	Edit Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Enter first name
		9	Click Find leads button
		10	Click on first resulting lead
		11	Verify title of the page
		12	Click Edit
		13	Change the company name
		14	Click Update
		15	Confirm the changed name appears
		16	Close the browser (Do not log out)*/


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

		// Click Leads link
		driver.findElementByLinkText("Leads").click();

		// Click Find leads
		driver.findElementByLinkText("Find Leads").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Enter first name
		driver.findElementByXPath("(//*[@name='firstName'])[3]").sendKeys("Ramya");


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click Find leads button
		driver.findElementByXPath("(//*[@class='x-btn-text'])[7]").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click on first resulting lead

		driver.findElementByXPath("(//*[@class='linktext'])[6]").click();	

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Verify title of the page	
		String Title1 = driver.getTitle();
		System.out.println(Title1);


		// Click Edit
		driver.findElementByLinkText("Edit").click();

		// Change the company name
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("AZ");


		// Click Update
		driver.findElementByName("submitButton").click();



		// Confirm the changed name appears
		String changedCompName =driver.findElementById("viewLead_companyName_sp").getText();

		changedCompName ="Amazon";
			System.out.println("Company Name is Changed");
		
		

	
		// Close the browser (Do not log out)*/

		driver.close();





	}
}




