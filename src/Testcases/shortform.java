package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class shortform {

	public static void main(String[] args) {
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
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		//List<WebElement> descriptions = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));///html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]
		List<WebElement> prices = driver.findElements(By.xpath(".//span[@class='a-price-whole']"));
		WebElement body = driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"));
		List<WebElement> descriptions = body.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
//		for(int i = 0; i < descriptions.size(); i++) {
//			int j=1;
//	        String desc = descriptions.get(i).getText();
//	        String price = prices.get(i).getText();
//	        System.out.println(j +"."+ desc +":"+ price);
//	        j++;
//	}
		System.out.println(+descriptions.size());
		System.out.println(+prices.size());
		
		//div[@class='a-section a-spacing-medium'] //span[@class='a-size-medium a-color-base a-text-normal']
		
		//WebElement price = driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']"));
		
		WebElement Pricetag = driver.findElement(By.xpath("//div[@class='sg-col-inner'] //div[@class='a-section a-spacing-none a-spacing-top-small']"));
				
        for(int i = 0; i < descriptions.size(); i++) {
			
			String desc = descriptions.get(i).getText();
			
			if(Pricetag.isDisplayed()) {
				
				String price = prices.get(i).getText();
		        System.out.println(desc +":"+ price);
		       
			}
			
		}

	}

}
