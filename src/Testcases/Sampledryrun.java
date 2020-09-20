package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sampledryrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=earphones+with+microphone+wired&i=electronics&ref=nb_sb_noss_1");
		driver.manage().window().maximize();

		ArrayList<WebElement> box = (ArrayList<WebElement>) driver
				.findElements(By.cssSelector(".s-include-content-margin.s-border-bottom.s-latency-cf-section"));

		int j = 1;
		System.out.println(box.size());
		for (int i = 0; i < box.size(); i++) {

			WebElement body = box.get(i);
			String item = body.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"))
					.getText();

			List<WebElement> dynamicElement = body.findElements(By.xpath(".//span[@class='a-price-whole']"));

			if (dynamicElement.size() != 0) {
              // If list size is non-zero, element is present
              System.out.println(j + "-->" + item + "Price present " + ": Rs." + dynamicElement.get(0).getText());
                }
            else {
            	// Else if size is 0, then element is not present
           System.out.println(j + "-->" + item + ":" + "Price Not available in website");
            }
           j++;
		}

	}

}
