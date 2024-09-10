package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment6 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qaclickacademy.com/practice.php");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		WebElement table = driver.findElement(By.id("product"));

		List<WebElement> tr = table.findElements(By.tagName("tr"));
		System.out.println(tr.size());

		List<WebElement> th = tr.get(0).findElements(By.tagName("th"));
		System.out.println(th.size());

		List<WebElement> td = tr.get(1).findElements(By.tagName("td"));
		for (WebElement td1 : td) {
			System.out.print(td1.getText() + "_____");
		}

	}

}
