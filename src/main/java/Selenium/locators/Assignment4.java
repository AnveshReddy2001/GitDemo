package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();

		driver.switchTo().frame("frame-top");

		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.tagName("body")).getText());

		driver.switchTo().parentFrame();

		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());

		driver.switchTo().parentFrame();

		driver.switchTo().frame("frame-right");
		System.out.println(driver.findElement(By.tagName("body")).getText());

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame-bottom");
		System.out.println(driver.findElement(By.tagName("body")).getText());

		driver.quit();

	}

}
