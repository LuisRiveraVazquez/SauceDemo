package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	
	By checkOutButton = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]");
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkOutButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(checkOutButton).click();
	}

}
