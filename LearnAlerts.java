package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("http://www.leafground.com/pages/Alert.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		 driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		 Alert alert=driver.switchTo().alert();
		 String text=alert.getText();
		 System.out.println(text);
		 alert.accept();
		 //confirm box
		 driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		 System.out.println(alert.getText()); 
		 alert.dismiss();
		 //prompt
		 driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	
		 alert.sendKeys("Testleaf");
			alert.accept();
		 
			
	}

}
