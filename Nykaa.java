package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	     driver.get("https://www.nykaa.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     
	    
	     Actions builder=new Actions(driver);
	     WebElement first=driver.findElement(By.xpath("//a[text()='brands']"));
	     builder.moveToElement(first).perform();
	     
	     //search L'Oreal paris and click L'Oreal paris
	   WebElement key=driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
	   key.sendKeys("L'Oreal Paris");
	   
	    driver.findElement(By.linkText("L'Oreal Paris")).click();
	     
	     
	    String text=driver.getTitle();
	    System.out.println(text);
	    String title="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
	    if(title.equals(text)) {
			System.out.println("Correct");
		}
	    else
	    {
			System.out.println("Wrong");
		}
	 
	    driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	    //driver.findElement(By.xpath("//span[@class='title'])[4]")).click();
	    driver.findElement(By.xpath("(//span[@class='title'])[4]/following::div")).click();
	     driver.findElement(By.xpath("(//span[@class='title '])[1]")).click();
	     
	     //click hare and haircare
	     
	    driver.findElement(By.xpath("//span[text()='Hair']")).click();
	    driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	     driver.findElement(By.xpath("(//span[@class='title']/following::div)[1]")).click();
	     
	     //click concern and color protection
	     
	     driver.findElement(By.xpath("//span[text()='Concern']")).click();
	     driver.findElement(By.xpath("((//span[@class='title'])[6]/following::div)[1]")).click();
	     
	    // check the filter is applied  with shampoo
	     WebElement findElement2 = driver.findElement(By.xpath("(//div[@id='filters-listing']//div)[3]"));
	     String text3 = findElement2.getText();
	     System.out.println(text3);
	     
	     
	     //click l oreal paris color protected shmapoo
	     driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
	     
	     
	     //go to the new window
	    // oldwindow=driver.getWindowHandle();
	     Set<String> window=driver.getWindowHandles();
	     List<String> window1=new ArrayList<String>(window);
	     driver.switchTo().window(window1.get(1));
	     
	   //select size as 175ml
	     
	     WebElement dropdown= driver.findElement(By.xpath("//select[@title='SIZE']"));
	     Select size=new Select(dropdown);
	     size.selectByValue("0");
	     
	     //print the mrp of the product
	     WebElement mrp= driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']//span)[2]"));
	     String text2 = mrp.getText();
	     System.out.println("Mrp rate:"+" "+text2);
	     
	     //click on ADD to BAG
	     driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
	     
	     
	     //go to shopping bag
	     
	     driver.findElement(By.xpath("//span[@class='cart-count']")).click();
	     //print the grand total amount
	     
	     driver.switchTo().frame(0);
	     String total =driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	     System.out.println(total);
	     //click proceed
	     driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
	     
	     //click on continue as Guest
	     driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	     //check if this grand total is the same in step14
	     
	     if(text2.equals(total))
	     {
	    	 System.out.println("grand total is same");
	     }
	     else
	     {
	    	 System.out.println("grand total is not same");
	     }
	     
	     
	     //close all windows
	     
	     
	     //driver.quit();
	     
	   }
}
