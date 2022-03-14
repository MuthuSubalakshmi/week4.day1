package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt\r\n");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 driver.switchTo().frame(0);
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("TestLeaf");
			alert.accept();
	        String src = driver.findElement(By.id("demo")).getText();
	        if (src.contains("TestLeaf"))
	        {
	        	System.out.println("Name is displayed");
	        }
	}

}
