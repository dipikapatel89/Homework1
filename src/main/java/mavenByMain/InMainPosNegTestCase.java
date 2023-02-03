package mavenByMain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InMainPosNegTestCase {

	static WebDriver driver;
	public static void main(String[] args)
	{
		
	Launchbrowser();
	LoginTest();
	tearDown();
	Launchbrowser();
	NegLoginTest();
	tearDown();

	}	
	public static void Launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe"); 
	    driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public static void LoginTest()
	{
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
			
	}
	
	public static void NegLoginTest()
	{
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123456");
		driver.findElement(By.name("login")).click();
			
	}
	
	public static void tearDown()
	{
		driver.close();
	}
	

}
