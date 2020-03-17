package testSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.InformationPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductPage;

public class TestPage {
	
	WebDriver driver;
	LoginPage objLoginPage;
	HomePage objHomePage;
	ProductPage objProductPage;
	InformationPage objInformationPage;
	OverviewPage objOverviewPage;
	
	static String URL = "https://www.saucedemo.com/";
	@BeforeTest
	@Parameters("browser")
	public void browser(String browser) {
		
		 if(browser.equalsIgnoreCase("firefox")){
			 System.setProperty("webdriver.gecko.driver", "/Users/luisrivera/eclipse-workspace1/SauceDemo/Lib/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Firefox is opened");
			
		}
		 else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome is opened");
			
		}
		else {
			System.out.println("browser Undefined");
		}
	}
	
	@BeforeTest
	public void setup(){
		//System.setProperty("webdriver.gecko.driver", "/Users/luisrivera/eclipse-workspace1/SauceDemo/Lib/geckodriver");
		//driver = new FirefoxDriver();
		driver.navigate().to(URL);
	}
	
	@Test (enabled = true)
	public void Login_with_a_valid_user(){
		
		objLoginPage = new LoginPage(driver);
		objLoginPage.login("standard_user", "secret_sauce");
		objHomePage = new HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageTitle().contains("Products"));
		
	}
	
	@Test(enabled = false)
	public void Login_with_a_invalid_user(){
		objLoginPage = new LoginPage(driver);
		objLoginPage.login("standa", "secret_s");
		Assert.assertTrue(objLoginPage.getErrorMessage().contains("Username and password do not match any user in this service"));
		
	}
	
	@Test(enabled = false)//(dependsOnMethods = { "Login_with_a_valid_user" })
	public void Logout_from_products_page(){
		objLoginPage = new LoginPage(driver);
		objLoginPage.logOut();
	}
	
	@Test(enabled = false)//(dependsOnMethods = { "Login_with_a_valid_user" })
	public void Navigate_to_the_shopping_cart(){
		objHomePage = new HomePage(driver);
		objHomePage.select_product_Container();
	}
	
	@Test(enabled = false)//(dependsOnMethods = { "Login_with_a_valid_user" })
	public void Add_a_single_item_to_the_shopping_cart(){
		objHomePage = new HomePage(driver);
		objHomePage.add_To_Cart();
		Assert.assertTrue(objHomePage.countItem().contains("1"));
	}
	
	@Test(enabled = false)//(dependsOnMethods = { "Login_with_a_valid_user" })
	public void Add_multiple_item_to_the_shopping_cart(){
		objHomePage = new HomePage(driver);
		objHomePage.add_Items_To_Cart();
		Assert.assertTrue(objHomePage.countItem().contains("3"));
	}
	
	@Test(enabled = false) //(dependsOnMethods = { "Add_multiple_item_to_the_shopping_cart" })
	public void Continue_with_missing_mail_information() {
		objHomePage = new HomePage(driver);
		objHomePage.go_To_Item_Page();
		objProductPage = new ProductPage(driver);
		objProductPage.checkOutButton();
		objInformationPage = new InformationPage(driver);
		objInformationPage.continueButton("", "", "");
		//objInformationPage.ErrorButton();
	}
	
	@Test (enabled = false) //(dependsOnMethods = { "Continue_with_missing_mail_information" })
	public void Fill_users_information() {
		objInformationPage = new InformationPage(driver);
		objInformationPage.continueButton("Luis", "Rivera", "45180");
	}
	
	@Test (enabled = false) //(dependsOnMethods = { "Fill_users_information" })
	public void Final_order_items() {
		objOverviewPage = new OverviewPage(driver);
		objOverviewPage.countItem();
		Assert.assertTrue(objOverviewPage.countItem().contains("3"));
	}
	
	@Test (enabled = false) //(dependsOnMethods = { "Final_order_items" })
	public void Complete_a_purchase() {
		objOverviewPage = new OverviewPage(driver);
		objOverviewPage.finishButton();
	}
	
}

//System.setProperty("webdriver.chrome.driver", "/Users/luisrivera/eclipse-workspace1/SauceDemo/chromedriver");
 //WebDriver driver = new ChromeDriver();


//WebDriver driver = new SafariDriver();
