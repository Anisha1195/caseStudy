package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Objectrepository.RegisterPage;

public class TestCase_2 {

	@Test
	public void Execute_2() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENSOL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		RegisterPage rp = new RegisterPage(driver);
		rp.Register().click();
		rp.UserName().sendKeys("Anishabts");
		rp.FirstName().sendKeys("Kim");
		rp.LastName().sendKeys("Taehyung");
		rp.EmailId().sendKeys("anas@gmail.com");
		rp.PassWord().sendKeys("Bts@v123");
		Select select = new Select(driver.findElement(By.id("input-country")));
		select.selectByValue("113");
		// srp.RegisterBtn().click();
	}
}