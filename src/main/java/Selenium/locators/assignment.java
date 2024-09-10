package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Anvesh");
		driver.findElement(By.name("email")).sendKeys("anvesh@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("shroodle");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("01-01-1955");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		
		
		
		

	}

}
