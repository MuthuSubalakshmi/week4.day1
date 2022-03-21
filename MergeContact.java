package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * /Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement elementBtn1= driver.findElement(By.linkText("CRM/SFA"));
		elementBtn1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement contacts= driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//span[text()='From Contact']//following::a[1]")).click();
		
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().window(allhandles.get(0));
		
		driver.findElement(By.xpath("//span[text()='To Contact']//following::a[1]")).click();
		Set<String> allwindowHandles1 = driver.getWindowHandles();
		List<String> currentwindow1 = new ArrayList<String>(allwindowHandles1);
		String newwindow1 = currentwindow1.get(1);
		driver.switchTo().window(newwindow1);
		
		
		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(currentwindow1.get(0));
		
	
		driver.findElement(By.linkText("Merge")).click();
	
	
		
		Alert alert=driver.switchTo().alert();
		 String text=alert.getText();
		 System.out.println(text);
		 alert.accept();
		 String title = driver.getTitle();
		 System.out.println("The title is :"+title);

			if (title.contains("View Contact")) {
				System.out.println("This case is PASSED");

			} else {
				System.out.println("This case is FAILED");
			}
			
	}

}
