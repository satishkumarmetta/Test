package practice_misc1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG_annotations_All_Example {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeclass(){
		System.out.println(" beforeclass");
		//System.setProperty("webdriver.gecko.driver", "c:\\gecko.exe")
		driver = new FirefoxDriver();
		wait=new WebDriverWait(driver,60);
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		driver.manage().window().maximize();
		}
	@Test(priority=2)
	public void test1_method(){
		System.out.println("TestNG test1_method");
	}
	@Test(priority=1)
	public void test2_method(){
		System.out.println("TestNG test2_method");
	}
	
	@Test
	public void test3_method(){
		System.out.println("TestNG test3_method");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before test");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void aftersuite(){
		System.out.println("after Suite");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("after Method");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after Test");
	}
	
	@AfterClass
	public void afterclass(){
		System.out.println(" I am in the AFter classs");
		driver.close();
		driver.quit();
	}
	
}
