package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTableAssignment1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/table.html ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ArrayList<Integer> list = new ArrayList<Integer>();
        WebElement elementTable = driver.findElement(By.id("table_id"));
        List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
        System.out.println("Total number of Rows :"+listRows.size());
        WebElement firstRow = listRows.get(1);
        int totalColumn = firstRow.findElements(By.tagName("td")).size();
        System.out.println("Total number of Columns :"+totalColumn);
      //  WebElement thirdRow = listRows.get(2);
      // String thirdRowColumn = thirdRow.findElements(By.tagName("td")).get(1).getText();
      // System.out.println(thirdRowColumn );
        for(int i=0;i<listRows.size();i++) { // This loop is to loop all the rows
        	WebElement currentRow = listRows.get(i); // To get the current row
        	List<WebElement> listColumns = currentRow.findElements(By.tagName("td")); // To get the corresponding row column
        	for(int j=0;j<listColumns.size();j++) {
	        	if(listColumns.get(j).getText().contains("Learn to interact with Elements")){
	        		System.out.println("Learn to interact with Elements Progress is :: "+listColumns.get(1).getText());
	         	}
	        	if(j == 1)
	        	{
	        		if(listColumns.get(j).getText().equals("30%"))
	        		{
                        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	        			
	        		}
	        	}
        	}
        }
        
        
        
        
}

        
}    
	


