package week3.Day5;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNow {
	//Mergre Lead
	public static void main(String[] args) throws InterruptedException {

		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 1. Launch the ServiceNow application URL: https://dev92474.service-now.com/	
		driver.get("https://dev92474.service-now.com/");


		// 2. Login with valid credentials username as admin and password as India@123	
		//switch to iframe
		driver.switchTo().frame("gsft_main");
		//Enter the username
		driver.findElementByName("user_name").sendKeys("admin");
		//Enter the password
		driver.findElementByName("user_password").sendKeys("India@123");
		//Click Login"
		driver.findElementById("sysverb_login").click();

		// 3. Enter Incident in filter navigator and press enter
		driver.findElementById("filter").sendKeys("Incident");
		driver.findElementById("filter").sendKeys(Keys.ENTER);



		Thread.sleep(4000);

		// 4. Click on Create new option Under Incident
		driver.findElementByXPath("//div[text()='Create New']").click();


		// 5. Get the text of Number Field and Store it in a String
		//switch to iframe
		driver.switchTo().frame("gsft_main");
		//Get the text of Number
		String value = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(value);


		// 6. Click on the Search Button Available in the Caller Field & Choose First Value Opened in the new Window

		//Click on the Search Button Available in the Caller Field

		driver.findElementByXPath("//div[@class='input-group ref-container']//button[@id='lookup.incident.caller_id']").click();
		Thread.sleep(3000);

		//Switch  to Window
		Set<String> allWindow = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWindow);
		String secWin = list.get(1);

		driver.switchTo().window(secWin);
		//Choose First Value 
		driver.findElementByXPath("//a[text()='Abel Tuter']").click();

		String firstWin = list.get(0);
		driver.switchTo().window(firstWin);

		driver.switchTo().frame("gsft_main");

		// 7. Select the Value as Software in Category Field

		WebElement category = driver.findElementById("incident.category");	
		Select dd1 = new Select(category);		
		dd1.selectByValue("software");

		//8.Select Email in Sub Category Field
		WebElement subcategory = driver.findElementById("incident.subcategory");	
		Select dd2 = new Select(subcategory);		
		dd2.selectByValue("email");

		// 9. Select Walk-in in Contact Type Field
		WebElement contacttype = driver.findElementById("incident.contact_type");	
		Select dd3 = new Select(contacttype);		
		dd3.selectByValue("walk-in");

		//10. Select state as In-Progress 
		WebElement state = driver.findElementById("incident.state");	
		Select dd4 = new Select(state);		
		dd4.selectByValue("2");

		//11. Select Urgency as High
		WebElement urgency = driver.findElementById("incident.urgency");	
		Select dd5 = new Select(urgency);		
		dd5.selectByValue("1");

		//12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window

		driver.findElementByXPath("//div[@class='input-group ref-container'] //*[@id='lookup.incident.assignment_group']").click();

		Thread.sleep(3000);

		//Switch  to Window
		Set<String> allwindow2 = driver.getWindowHandles();
		List<String> first1 = new ArrayList<String>(allwindow2);
		String fir = first1.get(1);
		driver.switchTo().window(fir);

		//Choose last Value 
		driver.findElementByXPath("//a[text()='Openspace']").click();

		String par = first1.get(0);
		driver.switchTo().window(par);

		driver.switchTo().frame("gsft_main");

		//13. Enter Short Description as "Creating Incident For the Purpose of Management"
		driver.findElementById("incident.short_description").sendKeys("Short Descriotion");

		//14. Click on the Submit Button
		driver.findElementById("sysverb_insert_bottom").click();


		//15. Enter The Incident Number Newly created in Search Field and Press Enter
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input").sendKeys(value);
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input").sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		//16. Click on the newly Created Incident Displayed
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		Thread.sleep(3000);

		//17. Verify the Incident Number

		String creIncident = driver.findElementById("incident.number").getAttribute("value");
		if(value.equals(creIncident)) {
			System.out.println("Incident Number is same");

			//18. Update Impact as High
			WebElement impact = driver.findElementById("incident.impact");
			Select dd6 = new Select(impact);
			dd6.selectByValue("1");


			//19. Update Description as "Successfully Created an incident"
			driver.findElementById("incident.description").sendKeys("Successfully created an Incident");

			//20. Enter Work Notes as "Done Right"
			driver.findElementById("activity-stream-textarea").sendKeys("Done Right");
			
			//21. Click on the Update button.
			driver.findElementById("sysverb_update_bottom").click();

			driver.switchTo().defaultContent();
			
			//22. Logout and Close
			driver.findElementByXPath("//span[@class='sn-avatar-image']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//a[text()='Logout']").click();
			driver.close();



		}



	}
}

