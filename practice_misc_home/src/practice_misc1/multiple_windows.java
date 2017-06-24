package practice_misc1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multiple_windows {

	public static void main(String args[]) throws Exception{
		
		WebDriver driver= new FirefoxDriver();
		driver.navigate().to("http://gmail.com/");
		//get first window handle
		String handle1=driver.getWindowHandle();
		System.out.println("I am in window 1");
		System.out.println("handle 1 =  "+handle1);
		
		
		WebDriverWait wait=new WebDriverWait(driver,35);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Help"))).click();
		//Thread.sleep(10000);
		
		Set<String> handles= driver.getWindowHandles();
		
		 //Iterator<String> it= handles.iterator();
		  Object[] array= handles.toArray();
		  String handle1_1= (String) array[0];
		  String handle2= (String) array[1];
		  System.out.println("handle 1 from getHANDLES = "+handle1_1);
		System.out.println("handle 2 = "+handle2);
		
		driver.switchTo().window(handle2);
		System.out.println("I am in window 2");
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Not Now"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='expanding_cta_close_button']"))).click();
		//driver.findElement(By.xpath(".//*[@id='expanding_cta_close_button']")).click();
		//String handle2= driver.getWindowHandle();
		
		//Thread.sleep(4000);
		//String phonenum=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='u_0_3u']/div[1]/div[1]"))).getText();
		boolean status=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".accordion-homepage>h1"),"Welcome to the Google Account Help Center"));
		
		
		System.out.println("first status of window 2"+status);
		

		driver.switchTo().window(handle1);
		System.out.println("I am in window 1, switched to window 1");
		String textinfirstwindow= driver.findElement(By.xpath(".//*[@id='initialView']/footer/ul/li[3]/a")).getText();
		System.out.println(textinfirstwindow);
		
		driver.switchTo().window(handle2);
		String textinWindow2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/footer/div[1]/div[1]/div/div/h2"))).getText();
		
		System.out.println("second status of window 2"+textinWindow2);
	}
}
