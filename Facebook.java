package com.selenium.pratice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Amit Kunjir
 * Assignment 1 - It will login to facebook and update status to "Hello World"
 */
public class Facebook {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
	    //Variable for Username.Change the variable value before execution i.e it should be your Facebook Username.
		String UserName = "YourUsername";
				
		//Variable for Username.Change the variable value before execution i.e it should be your Facebook Password.
		String Password = "YourPassord";
		
		//Using ChromerOptions class to disable runtime notifications from chrome like provide location notification
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("disable-infobars");
		coptions.addArguments("disable-notifications");
		
		//Initializing Chrome Browser i.e opening ChromeBrowser and passing the ChromeOptions to it so that Browser can know 
		WebDriver driver = new ChromeDriver(coptions);
		
		//Open Facebook URL
		driver.get("https://www.facebook.com/");
		
		//Opening the browser window in Maximize mode.
		driver.manage().window().maximize();
		
		//Finding Element of UserName and Password Fields and then entering values in that fields.
		driver.findElement(By.id("email")).sendKeys(UserName);
		driver.findElement(By.id("pass")).sendKeys(Password);
		
		//Clicking on login after entring the Username and Password.	
		driver.findElement(By.id("loginbutton")).submit();
		
		//Element of Status block
		By status = By.cssSelector("textarea#js_a");
		
		//Waiting until Status block is present on UI
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(status));
		
		//Clicking in status block and then typing "Hello World" in it once status block is available 
		driver.findElement(status).click();
		driver.findElement(status).sendKeys("Hello World");
		
		//Clicking on Share to Update the Status
		driver.findElement(By.xpath("//button[@data-testid='react-composer-post-button']")).click();
		
		//Closing browser window	
		driver.close();
		
		//Closing the browser session
		driver.quit();
		
		
	}

}
