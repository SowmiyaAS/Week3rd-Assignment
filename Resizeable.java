package week3rdAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	      ChromeDriver driver=new ChromeDriver();
	      driver.get("https://jqueryui.com/resizable");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	      driver.switchTo().frame(0);
	      
	      WebElement size=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	     
	           Actions builder=new Actions(driver);
	          builder.dragAndDropBy(size,75,40).build().perform();
	          driver.switchTo().defaultContent();
	}

}
