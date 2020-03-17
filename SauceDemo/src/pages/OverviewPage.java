package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
	WebDriver driver;
	
	By countItem = By.xpath("/html/body/div/div[2]/div[1]/div[2]/a/span");
	By finishButton = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]");
	
	public OverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String countItem() {
		return driver.findElement(countItem).getText();
	}
	
	public void finishButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(finishButton));
		driver.findElement(finishButton).isDisplayed();
		driver.findElement(finishButton).click();
	}

}
