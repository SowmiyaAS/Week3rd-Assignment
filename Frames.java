package week3rdAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	     ChromeDriver driver=new ChromeDriver();
	     driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
	     driver.switchTo().frame(0);
	     driver.findElement(By.xpath("//input[1]")).sendKeys("Testleaf");
	     
	     driver.switchTo().frame("frame3");
	     driver.findElement(By.xpath("//input[@id='a']")).click();
	     driver.switchTo().defaultContent();
	     
	     driver.switchTo().frame("frame2");
	     WebElement ele=driver.findElement(By.xpath("//select[@class='col-lg-3']"));
	     Select text=new Select(ele);
	     text.selectByValue("big baby cat");
	     driver.switchTo().defaultContent();
	
	}

}
