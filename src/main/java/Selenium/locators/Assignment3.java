package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Multiple Windows")).click();

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentid = it.next();
		String childid = it.next();

		driver.switchTo().window(childid);

		System.out.println(driver.findElement(By.cssSelector("div.example > h3")).getText());

		driver.switchTo().window(parentid);

		System.out.println(driver.findElement(By.cssSelector("div.example > h3")).getText());
		
		driver.quit();

	}

}
