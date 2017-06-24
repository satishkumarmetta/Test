package practice_misc1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multiple_windows_gmail_ex {

	public static void main(String args[]) throws Exception{
		
		WebDriver driver= new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		/*
		//get first window handle
		String handle1=driver.getWindowHandle();
		System.out.println("I am in window 1");
		//below is just for info
		System.out.println("handle 1 =  "+handle1);*/		
		
		WebDriverWait wait=new WebDriverWait(driver,35);
		
		//locate element 'Help' and click on it
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='initialView']/footer/ul/li[1]/a"))).click();
	
		//get handles of all opened windows using driver object
		Set<String> handles= driver.getWindowHandles();
		
		//
		  Object[] array= handles.toArray();
		  String handle1= (String) array[0];
		  String handle2= (String) array[1];
		  
		  //print handles just for info
		System.out.println("window(handle) 1 = "+handle1);
		System.out.println("window(handle) 2 = "+handle2);
		
		//switch to window 2
		driver.switchTo().window(handle2);
		System.out.println("I am in window 2");
		
		//get text present in element1 from window 2
		String win2text1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/section/div/article/nav/h1"))).getText();
		
		//print  text present in element1 from window 2
		System.out.println("window 2, text of element 1(should be\"Welcome to the Google Account Help Center)\" =" +win2text1);
		
		//switch to window 1
		driver.switchTo().window(handle1);
		System.out.println("I am in window 1, switched to window 1");
		String textinfirstwindow= driver.findElement(By.xpath(".//*[@id='initialView']/footer/ul/li[1]/a")).getText();
		System.out.println("window 1, element text should be \"Help\" = "+textinfirstwindow);
		
		//switchto window 2
		driver.switchTo().window(handle2);
		driver.manage().window().maximize();
		String win2text2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/footer/div[1]/div[1]/div/div/h2"))).getText();
		
		//window 2, text of element 2
		System.out.println("window 2, text of element 2 should be \"Protect your account\" = "+win2text2);
		Thread.sleep(2000);
		//close window 2
		driver.close();
		Thread.sleep(3000);
		//switchto window 1
		driver.switchTo().window(handle1);
		driver.close();
		//wait.until(ExpectedConditions)
		
	}
}
