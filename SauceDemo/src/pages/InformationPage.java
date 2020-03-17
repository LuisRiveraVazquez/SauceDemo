package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
	WebDriver driver;
	
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By zip_PostalCode = By.id("postal-code");
	By continueButton = By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input");
	By errorMessage = By.xpath("/html/body/div/div[2]/div[3]/div/form/h3/button");
	
	public InformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setfirstName(String stringfirstName) {
		driver.findElement(firstName).sendKeys(stringfirstName);
	}
	
	public void setlastName(String stringlastName) {
		driver.findElement(lastName).sendKeys(stringlastName);
	}
	
	public void setpostalCode(String stringpostalCode) {
		driver.findElement(zip_PostalCode).sendKeys(stringpostalCode);
	}
	
	public void continueButton() {
		driver.findElement(continueButton).click();
	}
	
	public void ErrorButton() {
		driver.findElement(errorMessage).isDisplayed();
	}
	
	public void continueButton (String stringfirstName, String stringlastName, String stringpostalCode ) {
		this.setfirstName(stringfirstName);
		this.setlastName(stringlastName);
		this.setpostalCode(stringpostalCode);
		this.continueButton();
		
	}

}
