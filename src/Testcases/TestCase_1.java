package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objectrepository.LoginPage;

public class TestCase_1 {

	@Test
	public void Execute() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");

		LoginPage lp = new LoginPage(driver);
		lp.LoginPage().click();
		lp.Emailid().sendKeys("cab@gmail.com");
		lp.Passwd().sendKeys("Bts@v123");
		lp.LoginBtn().click();
		String msg = lp.DisplayErrMsg().getText();
		// System.out.println(msg.trim());
		String expectdmsg = "No match";
		Assert.assertTrue(msg.contains(expectdmsg));
	}

}
