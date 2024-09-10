package Selenium.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class dropdown {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.goindigo.in/");
        Thread.sleep(2000);

        
        WebElement from = driver.findElement(By.id("origin"));
        from.sendKeys("Hyderabad");

       
        Thread.sleep(2000);

        
        List<WebElement> hyderabadOptions = driver.findElements(By.cssSelector("div.ac_results li a"));

        // Click on the first option for "Hyderabad"
        if (!hyderabadOptions.isEmpty()) {
            hyderabadOptions.get(0).click();
        }

        // Find the "To" input field and enter "Delhi"
        WebElement to = driver.findElement(By.id("destination"));
        to.sendKeys("Delhi");

        // Wait for a while to let the auto-suggest options load
        Thread.sleep(2000);

        // Find all auto-suggest options for "Delhi"
        List<WebElement> delhiOptions = driver.findElements(By.cssSelector("div.ac_results li a"));

        // Click on the first option for "Delhi"
        if (!delhiOptions.isEmpty()) {
            delhiOptions.get(0).click();
        }

        // Close the browser
        driver.quit();
    }
}
