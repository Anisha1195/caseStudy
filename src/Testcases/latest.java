package Testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Go to Amazon.in

Select a value from the dropdown (Ex.- Electronics)

Enter a text (Ex.- Earphones)

Select the third option from the auto-suggestion box)

Write all the names and their corresponding prices of the products displayed in one CSV file
*/
public class latest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Go to amazon website 
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		// select Electronics from drop down
		Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		select.selectByVisibleText("Electronics");

		// enter earphones in search box text in search box and select the third option from auto sugesstive drop down
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("earphones");
		Thread.sleep(9000);

		List<WebElement> list = driver.findElements((By.xpath("//div[@id='nav-flyout-iss-anchor']/div/div/div/div")));

		System.out.println("Size is" + list.size());
		for (WebElement a : list) {
			System.out.println(a.getText());

			if (a.getText().equals("earphones with microphone wired")) {
				a.click();
				break;
			}
			System.out.println();
		}

		// Get the list of all the product names along with their prices displayed in the amazon website and write the result in csv file
		ArrayList<WebElement> box = (ArrayList<WebElement>) driver
				.findElements(By.cssSelector(".s-include-content-margin.s-border-bottom.s-latency-cf-section"));

		int j = 1;
		System.out.println(box.size());
		for (int i = 0; i < box.size(); i++) {

			WebElement body = box.get(i);
			String item = body.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"))
					.getText();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement	tag = body.findElement(By.cssSelector(".a-row.a-size-base.a-color-base"));
			WebElement pricetag = body.findElement(By.xpath(".//span[@class='a-price-whole']"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if (tag.isEnabled()) {
				String price = pricetag.getText();
				System.out.println("-->" + item + ":" + price);
			} else {
				System.out.println("-->" + item + ":" + "PRICE AMOUNT IS NOT DISPLAYED IN WEBSITE");
			}

		}
	}
}
