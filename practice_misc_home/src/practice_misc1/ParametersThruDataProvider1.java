package practice_misc1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersThruDataProvider1 {
	
	@DataProvider(name="test1")
	public static Object[][] data() {
		return new Object[][] { {2,true},{6,false},{9,true},{15,false}};
		
	}
	
	@Test(dataProvider="test1")
	public void testprimenumberchecker(Integer x, Boolean y){
		System.out.println(x+" "+y);
	}
	
}
