package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By LoginBtn = By.linkText("Login");
	By emailId = By.cssSelector("#input-email");
	By password = By.cssSelector("#input-password");
	By LoginClick = By.xpath("//div[@class='col-sm-6']/button[1]");
	By ErrorMsg = By.cssSelector(".alert.alert-danger");

	public WebElement Emailid() {
		return driver.findElement(emailId);
	}

	public WebElement Passwd() {
		return driver.findElement(password);
	}

	public WebElement LoginBtn() {
		return driver.findElement(LoginClick);
	}

	public WebElement LoginPage() {
		return driver.findElement(LoginBtn);
	}

	public WebElement DisplayErrMsg() {
		return driver.findElement(ErrorMsg);
	}

}
