package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHW {

	/*
	 * URL - http://www.leafground.com/pages/table.html
	 * 1) Set the property for chromedriver and initialize the driver
	 * 2) launch the url
	 * 3) Get the table and store it as a webelement
	 * 4) Find the number of rows based on its tag name and store it in a list
	 * 5) Find the number of cols based on its tag name and store it in a list
	 * 6) Print the size of the rows
	 * 7) Print the size of the cols
	 * 8) Get the progress value of 'Learn to interact with Elements' and store it in a variable
	 * 9) Print the text of the variable
	 * 10) Find the vital task for the least completed progress and check the box
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// Get the table and store it as a webelement	
		WebElement table = driver.findElementById("table_id");

		//Find the number of rows based on its tag name and store it in a list

		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rows_count = allRows.size();
		//Print the size of the rows
		System.out.println("row " +  rows_count);

		//Find the number of cols based on its tag name and store it in a list
		WebElement firstRow = allRows.get(0);
		List<WebElement> allColumn = firstRow.findElements(By.tagName("th"));
		int col_count = allColumn.size();
		//Print the size of the cols
		System.out.println("col " + col_count);

		//Get the progress value of 'Learn to interact with Elements' and store it in a variable
		String data	= driver.findElementByXPath("//tr[@class='even']/td[2]").getText();
		//Print the text of the variable	
		System.out.println("progress value of 'Learn to interact with Elements' "+  data);
						
		WebElement sec_row = allRows.get(2);
		String rowname = sec_row.getText();
		System.out.println(rowname);	
		
		//Find the vital task for the least completed progress and check the box
		String lastcomp = driver.findElementByXPath("//*[@id=\'table_id\']/tbody/tr[4]/td[3]/input").getText();
		System.out.println("value" + lastcomp);
		
		driver.findElementByXPath("//*[@id=\'table_id\']/tbody/tr[4]/td[3]/input").click();
		
	
		







	}
}