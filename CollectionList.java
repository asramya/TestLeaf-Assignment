package week3.Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectionList {
	//		1) https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC
	//		2) Click on Sort on Date
	//		3) Get all the Train Names
	//		   Xpath: //div[@id='divTrainsList']//td[@class=''][2] 
	//		   findElements -> List<WebElement>
	//		4) Create another List using ArrayList (trainNames)
	//		5) for each loop : List<WebElement>
	//		6) You will get each WebElement : get its text 
	//		7) Add the text to your created list (trainNames.add())
	//		8) After the loop ends, sort it
	//		9) Print it with the loop!!
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
		driver.findElementById("chkSelectDateOnly").click();
		
		List<WebElement> alltrain = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		
		List<String> tr = new ArrayList<String>();
		for (WebElement eachTrain : alltrain) {
			String train = eachTrain.getText();
			tr.add(train);
			System.out.println("Total Train" + tr.size());
		}
		Collections.sort(tr);
	
		for (int i = 0; i < tr.size(); i++) {
			System.out.println(tr.get(i));

	}
}
}