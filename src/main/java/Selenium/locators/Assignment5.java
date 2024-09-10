package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		WebElement labelElement = driver.findElement(By.cssSelector("label[for='bmw']"));
		String label = labelElement.getText();

		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(label);

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(label);
		Thread.sleep(2000);

		driver.findElement(By.id("alertbtn")).click();

	}

}
