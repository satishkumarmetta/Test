package practice_misc1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class auto_suggestion {

	@Test
	public void method1() throws Exception{
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> LWE=  driver.findElements(By.xpath("//div[@class='sbqs_c']"));
		
		// way1
		
		 	for(WebElement e:LWE){
			System.out.println(e.getText());
		}
		
		
		//Way 2
		   /*Iterator<WebElement> Iter= LWE.iterator();
		while(Iter.hasNext()){
			WebElement E= Iter.next();
			String text= E.getText();
			System.out.println(text);
			if(text.equals("selenium testing")){
				E.click();
				break;
			}
			
		}*/
		Thread.sleep(5000);
		driver.close();
		   
	}
}
