package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/"); 
		driver.manage().window().maximize();
		
		//select from drop down
		Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		select.selectByVisibleText("Electronics");
		
		//enter a text in search box
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("earphones");
		Thread.sleep(9000);
		////div[@id='nav-flyout-iss-anchor']/div/div/div/div
		
		List<WebElement> list = driver.findElements((By.xpath("//div[@id='nav-flyout-iss-anchor']/div/div/div/div")));

		System.out.println("Size is"+list.size());
		for(WebElement a:list)
		{
		    System.out.println(a.getText());
		    
		    if(a.getText().equals("earphones with microphone wired")) {
		    	a.click();
		    	break;
		    }
		    System.out.println();
		}
		
		////div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[1]/div/div/div[1]/h2
		
		
		List<WebElement> productItems = driver.findElements((By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[1]/div/div/div[1]/h2")));
		
		System.out.println("Size is"+productItems.size());
		int i=1;
		for( WebElement b : productItems) {
			System.out.println( i +"."+ b.getText());
			i++;
		}
		
		////div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/a/span[1]
		////div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/a/span[1]/span/span[2]
/*		List<WebElement> productPrice = driver.findElements((By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/a/span[1]/span/span[2]")));
		
		System.out.println("Size is"+productPrice.size());
		
		int j=1;
		for( WebElement b : productPrice) {
			System.out.println( j +"."+ "Rs."+  b.getText());
			j++;
		}
		
		*/
		//WebElement Box = driver.findElement(By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div"));
		
		
		
		
	}

}
