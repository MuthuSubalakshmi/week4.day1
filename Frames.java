package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		// to select text box topic
		
		  driver.switchTo().frame(0);
		  
		  driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("animals");
		  //To select the checkbox 
		  driver.switchTo().frame("frame3");
		  driver.findElement(By.xpath("//input[@id='a']")).click();
		 
		
		  driver.switchTo().defaultContent();
		// to select the dropdown
		driver.switchTo().frame(1);
		Select animals = new Select(driver.findElement(By.id("animals")));
		animals.selectByVisibleText("Baby Cat");
	
		
		
	}

}
