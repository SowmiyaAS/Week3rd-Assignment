package week3rdAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	      ChromeDriver driver=new ChromeDriver();
	      driver.get("https://jqueryui.com/selectable");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       
	      driver.switchTo().frame(0);
	      WebElement from=driver.findElement(By.xpath("//li[text()='Item 1']"));
	      WebElement to=driver.findElement(By.xpath("//li[text()='Item 3']"));
	     
	           Actions builder=new Actions(driver);
	          builder.clickAndHold(from).moveToElement(to).perform();
	          driver.switchTo().defaultContent();
	
	
	
	}

}
