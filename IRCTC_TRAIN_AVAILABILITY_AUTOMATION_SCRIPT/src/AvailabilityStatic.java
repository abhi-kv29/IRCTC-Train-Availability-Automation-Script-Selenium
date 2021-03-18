//WORKS SAME BUT USING PARENT CHILD RELATIONSHIP FOR SELECTING SOURCE AND DESTINATION

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class AvailabilityStatic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Documents\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
			
		driver.findElement(By.id("origin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c58-8']/li[2]")).click();
		driver.findElement(By.id("destination")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c58-9']/li[5]")).click(); 
		driver.findElement(By.cssSelector("span[class='ng-tns-c59-10 ui-calendar']")).click();
		
		driver.findElement(By.cssSelector("span[class='ng-tns-c59-10 ui-calendar']")).click();
		Thread.sleep(3000);
		
		while(!driver.findElement(By.cssSelector("span[class='ui-datepicker-month ng-tns-c59-10 ng-star-inserted']")).getText().contains("April") && !driver.findElement(By.cssSelector("span[class='ui-datepicker-year ng-tns-c59-10 ng-star-inserted']")).getText().contains(" 2021"))
		{
			driver.findElement(By.cssSelector("span[class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c59-10']")).click();
		}
			
		Thread.sleep(3000);		
		
		int count = driver.findElements(By.cssSelector("td[class='ng-tns-c59-10 ng-star-inserted'] a")).size();
		
		for(int i=0; i<count; i++)
		{
			String text = driver.findElements(By.cssSelector("td[class='ng-tns-c59-10 ng-star-inserted'] a")).get(i).getText();
			if(text.equalsIgnoreCase("15"))
			{
				driver.findElements(By.cssSelector("td[class='ng-tns-c59-10 ng-star-inserted'] a")).get(i).click();
				break;
			}
		}	
		
		driver.findElement(By.id("journeyClass")).click();
		Thread.sleep(2000);
		List<WebElement> classOptions = driver.findElements(By.cssSelector("div[class='ui-dropdown-items-wrapper ng-tns-c66-11'] ul li"));
		
		for (WebElement option: classOptions)
		{
			if(option.getText().equalsIgnoreCase("AC 3 Tier (3A)"))
			{
				System.out.println(option.getText());
				option.click();
				break;
				
			}
		}
		
		driver.findElement(By.id("journeyQuota")).click();
		Thread.sleep(2000);
		List<WebElement> quotaOptions = driver.findElements(By.cssSelector("div[class='ui-dropdown-items-wrapper ng-tns-c66-12'] ul li"));
		
		for (WebElement quota: quotaOptions)
		{
			if(quota.getText().equalsIgnoreCase("LADIES"))
			{
				System.out.println(quota.getText());
				quota.click();
				break;
			
			}
		}
		
		System.out.println(driver.findElement(By.id("availableBerth")).isSelected());
		driver.findElement(By.cssSelector("label[for='availableBerth']")).click();
		System.out.println(driver.findElement(By.id("availableBerth")).isSelected());
	  
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	
	}

}
