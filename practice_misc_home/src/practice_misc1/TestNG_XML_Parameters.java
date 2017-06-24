package practice_misc1;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG_XML_Parameters {

	
	
	@Test
	public void method1(){
		assertFalse(false);
		System.out.println("In method1");
	}
	
	@Test(priority=1,dependsOnMethods="method1")
	@Parameters({"url","uname","pwd"})
	public void login(String URL,String UNAME,String PWD){
		WebDriver driver=new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
		
		 //locate User name element and type the value
		 driver.findElement(By.name("txtUserName")).sendKeys(UNAME);
		 driver.findElement(By.name("txtPassword")).sendKeys(PWD);
		 driver.findElement(By.name("Submit")).click();
		
		//---verify home page welcome text
			String weltext = driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
			
			if(weltext.equals("Welcome "+UNAME)){
				System.out.println("Home page displayed");
			}
			else{
				System.out.println("Login failed");
				driver.quit();
				return;
			}
	}
}
