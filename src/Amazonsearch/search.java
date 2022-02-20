package Amazonsearch;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class search {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 12");

		WebElement searchclick=driver.findElement(By.id("nav-search-submit-button"));
		searchclick.click();
		
		List<WebElement> iphonename=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> iphoneprice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));

    	//Search items count
		System.out.println("Number of Phones listed "+iphonename.size());

    	//Iterate and ignore other than iphone12
    	for(int count=0; count<iphonename.size(); count++) {    	
    		if(iphonename.get(count).getText().toLowerCase().contains("iphone 12"))
    		{    			
    			System.out.println("I phone Name:"+iphonename.get(count).getText() + ":" + iphoneprice.get(count).getText());
    		}
    	}
		
    	driver.close();
				
		
	}
}
