package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnDropDown {
	
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {
		
		//Storing web element
		
		
		//By type Element List
		By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
		By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
		By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
		By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
		
		

		String userName = "demo@techfios.com";
		
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		String DashboardHeader = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		System.out.println("Header: "+ DashboardHeader);
		
		Assert.assertEquals("Dashboard Page not available", "Dashboard", DashboardHeader);
		
		
	}
	
	public void addContact() {
		
		
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
