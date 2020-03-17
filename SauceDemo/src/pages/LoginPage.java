package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	WebDriver driver;
	By userName = By.id("user-name");
	By Password = By.id("password");
	By loginButton = By.className("btn_action");
	By errorMessage = By.xpath("/html/body/div[2]/div[1]/div[1]/div/form/h3");
	By burgerMenu = By.className("bm-burger-button");
	By logOutButton = By.id("logout_sidebar_link");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUser(String stringUserName) {
		driver.findElement(userName).sendKeys(stringUserName);
	}
	
	public void setPassword(String stringPassword) {
		driver.findElement(Password).sendKeys(stringPassword);
	}
	
	public void loginButton() {
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	public void logOut() {
		driver.findElement(burgerMenu).click();
		driver.findElement(logOutButton).click();
	}
	
	public String select_product_Container() {
		Select Container = new Select (driver.findElement(By.className("product_sort_container"))); 
		Container.selectByValue("lohi");
		return null;
	}
	
	
	public void login(String stringUserName, String stringPasword) {
		this.setUser(stringUserName);
		this.setPassword(stringPasword);
		this.loginButton();
		
	}
	
}


