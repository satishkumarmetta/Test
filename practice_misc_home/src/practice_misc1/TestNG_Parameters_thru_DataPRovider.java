package practice_misc1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG_Parameters_thru_DataPRovider {

	@DataProvider(name="test_data_provider")
	public static Object[][] testdata() {
		return new Object[][] { {"qaplanet1","user1","valid"},{"qaplanet2","user1","invalid"}};
		//return new Object[][] { {"qaplanet1","user1"},{"qaplanet2","user1"},{"qaplanet2","user2"},{"qaplanet3","user3"}};		
		
	}

	
	@Test(dataProvider="test_data_provider")
	///////******@Parameters({"uname","pwd"})
	public void login(String UNAME,String PWD,String validity) throws Exception{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
		
		 //locate User name element and type the value
		 driver.findElement(By.name("txtUserName")).sendKeys(UNAME);
		 driver.findElement(By.name("txtPassword")).sendKeys(PWD);
		 driver.findElement(By.name("Submit")).click();
		
	if(validity.equals("valid")){
		 
		 
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
			
			
//---Log out from application	
			driver.findElement(By.linkText("Logout")).click();
			
			Thread.sleep(3000);
			
			String stitle= driver.getTitle();

	//---Verify Login page
			if(stitle.equals("OrangeHRM - New Level of HR Management")){
				System.out.println("Logout success & Login page displayed");
			}else{
				System.out.println("Logout failed");
			}
			
			driver.close();
			}
		else{ String invalid_msg= driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]")).getText();
			  assertEquals(invalid_msg,"Invalid Login");
			  Reporter.log("Invalid data test passed");
			  driver.quit();
		}
	}
}
