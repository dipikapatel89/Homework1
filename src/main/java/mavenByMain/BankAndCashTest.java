package mavenByMain;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankAndCashTest {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Before
	public void Launchbrowser() {
		System.out.println("Before annotation");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void LoginTest() {
		System.out.println("positive test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("IT dept");
		driver.findElement(By.id("description")).sendKeys("checking account");
		driver.findElement(By.id("balance")).sendKeys("800");
		driver.findElement(By.id("account_number")).sendKeys("12345678");
		driver.findElement(By.id("contact_person")).sendKeys("dolly");
		driver.findElement(By.id("contact_phone")).sendKeys("546888287");
		driver.findElement(By.id("ib_url")).sendKeys("https://www.google.com/");
		driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/button")).click();
	}

	/*@Test
	public void NegLoginTest() {
		System.out.println("neg test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123456");
		driver.findElement(By.name("login")).click();
		
		
	
		}*/

	/*@After
	public void tearDown() {
		System.out.println("After annotation");
		driver.close();
		driver.quit();
	}*/
}
