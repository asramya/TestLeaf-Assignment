package leaftaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteLead {

	public static void main(String[] args) {


		// to launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();*/

		
		driver.manage().window().maximize();

		// to launch the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

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
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Click Find leads
		driver.findElementByLinkText("Find Leads").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Click on Phone
		driver.findElementByXPath("//span[contains(text(),'Phone')]").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Enter phone number
		driver.findElementByName("phoneCountryCode").clear();
		driver.findElementByName("phoneNumber").sendKeys("8939982404");

		// Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement CompanyName = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		String CName = CompanyName.getText();
		System.out.println(CName);
		
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElementByXPath("//a[text()='Delete']").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByPartialLinkText("Find Leads").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByName("id").sendKeys(CName);
		driver.findElementByPartialLinkText("Find Leads").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ErrorMessage = driver.findElementByXPath("//div[@class='x-paging-info']");
		String ErrorMessage1 =  ErrorMessage.getText();
		String Expected = "No records to display";
		if(ErrorMessage1.equalsIgnoreCase(Expected))
		{
			System.out.println("Record Not Found");
		}
		else
		{
			System.out.println("Record Found");
		}

		driver.close();

	}

}
