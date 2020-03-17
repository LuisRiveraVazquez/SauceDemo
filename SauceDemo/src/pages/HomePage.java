package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	By titlePage = By.className("product_label");
	//By productContainer = By.className("product_sort_container");
	By addToCart = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button");
	By addTocart2 = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button");
	By addTocart3 = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button");
	By addTocart4 = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[6]/div[3]/button");
	By countItem = By.xpath("/html/body/div/div[2]/div[1]/div[2]/a/span");
	By cartimage = By.xpath("//*[@id=\"shopping_cart_container\"]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	
	}
	
	public String getHomePageTitle() {
		return driver.findElement(titlePage).getText();
	}
	
	public String select_product_Container() {
		Select Container = new Select (driver.findElement(By.className("product_sort_container"))); 
		Container.selectByValue("lohi");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		return null;
	}
	
	public void add_To_Cart() {
		driver.findElement(addToCart).click();
	}
	public String countItem() {
		return driver.findElement(countItem).getText();
	}
	public void add_Items_To_Cart() {
		driver.findElement(addTocart2).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(addTocart3).click();
		driver.findElement(addTocart4).click();
	}
	
	public void go_To_Item_Page() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0)");
		driver.findElement(cartimage).isEnabled();
		driver.findElement(cartimage).click();
	}
	
	
	
	

}


