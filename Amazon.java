package week3rdAssignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
	     ChromeDriver driver=new ChromeDriver();
	     driver.get("https://www.amazon.in/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     
	     //search oneplus 9 pro
   driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
   driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
   
 //get first product price
   String price = driver.findElement(By.xpath("(//span[@class='a-price-whole']//ancestor::span)[2]")).getText();
	System.out.println("price is :"+" "+price);
  
	
//customer ratings
	String price1 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text']//ancestor::span)[2]")).getText();
	System.out.println(price1);
	
//click on the stars
 
	driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
	
	//get 5star percentage
	String text=driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a")).getText();
	System.out.println(text);
	
	
	//Click the first text link of the first image
		driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
		
	// window handling
	Set<String> window=driver.getWindowHandles();
	List<String> windowhandles=new ArrayList<String>(window);
	driver.switchTo().window(windowhandles.get(1));
	
	
	
	
	//Take a screen shot of the product displayed
	File source=driver.getScreenshotAs(OutputType.FILE);
	File des=new File("./amazonscreenshot.png");
	FileUtils.copyFile(source, des);
	
	//Click 'Add to Cart' button
	
	 
	WebElement findElement = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	findElement.click();
	Thread.sleep(2000);
	
	//Get the cart subtotal and verify if it is correct
	String subtotal =driver.findElement(By.xpath("(//div[@class='a-column a-span11 a-text-left a-spacing-top-large']//span)[3]")).getText();	
		//System.out.println(subtotal);
		//replace for.00
		
	String replaceAll=subtotal.replace(".00","");
	System.out.println("subtotal is: "+replaceAll);
	
	

	//verify first product price and subtotal
		if(price.equals(replaceAll))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("not correct");
		}
	
	
	Thread.sleep(2000);
	
	}

}
