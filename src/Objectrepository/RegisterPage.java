package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;

	}

	By RegisterBtn = By.xpath("//div[@class='navbar-right hidden-xs']/a[2]");
	By userName = By.cssSelector("#input-username");
	By firstName = By.cssSelector("#input-firstname");
	By lastName = By.cssSelector("#input-lastname");
	By emailId = By.cssSelector("#input-email");
	By passWord = By.cssSelector("#input-password");
	By regBtn = By.xpath("//div[@id='button-register']/button[1]");

	public WebElement UserName() {
		return driver.findElement(userName);
	}

	public WebElement FirstName() {
		return driver.findElement(firstName);
	}

	public WebElement LastName() {
		return driver.findElement(lastName);
	}

	public WebElement EmailId() {
		return driver.findElement(emailId);
	}

	public WebElement PassWord() {
		return driver.findElement(passWord);
	}

	public WebElement Register() {
		return driver.findElement(RegisterBtn);
	}

	public WebElement RegisterBtn() {
		return driver.findElement(regBtn);
	}

}
