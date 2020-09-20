package Testcases;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon_csv {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
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
		
		
//		List<WebElement> productItems = driver.findElements((By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[1]/div/div/div[1]/h2")));
//		
//		System.out.println("Size is"+productItems.size());
//		int i=1;
//		for( WebElement b : productItems) {
//			System.out.println( i +"."+ b.getText());
//			i++;
//		}
		
		String csvCell[];
		String separator=",";
		try(OutputStream filestream = new BufferedOutputStream(new FileOutputStream("D://Write.txt")); // .csv ->file
				Writer outStreamWriter = new OutputStreamWriter(filestream, StandardCharsets.UTF_8);
				BufferedWriter buffWriter = new BufferedWriter(outStreamWriter)) 
		
		{
			//buffWriter.append("Product Name");
			//buffWriter.append(separator);
           // buffWriter.append("Price");
            
           // buffWriter.newLine();
          // buffWriter.flush();
            
            List<WebElement> productItems = driver.findElements((By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[1]/div/div/div[1]/h2")));
    		String ans;
    		
    		
    		System.out.println("Size is"+productItems.size());
    		int i=1;
    		for( WebElement b : productItems) {
    			System.out.println( i +"."+ b.getText());
    			ans= b.getText();
    			
    			buffWriter.append(i+"."+ ans+ "--> Rs. 0.00");
    			//buffWriter.append(separator);
    			
    			buffWriter.newLine();
                buffWriter.flush();
    			i++;
    		}

            
		}
		
		//.//span[@class='a-size-medium a-color-base a-text-normal']
		//.//span[@class='a-price-whole']
		
	}

}
