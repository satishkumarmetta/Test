package practice_misc1;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG_skip_Test_Run {

	
	
	@Test(priority=1)
	public void login(){
		Reporter.log("Login method execution started");
		assertFalse(true);
		Reporter.log("Login passed");
		//Reporter.log("Login failed");
	}
	
	@Test(priority=2,dependsOnMethods="login")
	public void logout(){
		Reporter.log("Log out success");
		//System.out.println();
	}
}
