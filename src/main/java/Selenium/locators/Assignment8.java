package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		WebElement autoDropDown = driver.findElement(By.id("autocomplete"));

		autoDropDown.sendKeys("Ind");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ui-menu-item-wrapper').click()");

		System.out.println(autoDropDown.getAttribute("value"));

	}

}
