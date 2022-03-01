package week3rdAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	      ChromeDriver driver=new ChromeDriver();
	      driver.get("https://jqueryui.com/droppable");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	      
	      driver.switchTo().frame(0);
	      WebElement drag=driver.findElement(By.id("draggable"));
	      WebElement drag1=driver.findElement(By.id("droppable"));
	     
	           Actions builder=new Actions(driver);
	          builder.dragAndDrop(drag, drag1).build().perform();
	          driver.switchTo().defaultContent();
	}

}
