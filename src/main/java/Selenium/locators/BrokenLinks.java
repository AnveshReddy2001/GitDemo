package Selenium.locators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        //System.setProperty("webdriver.chrome.driver", "C://path_to_chromedriver//chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

            SoftAssert softAssert = new SoftAssert();

            for (WebElement link : links) {
                String url = link.getAttribute("href");
                if (url == null || url.isEmpty()) {
                    System.out.println("URL is either not configured for anchor tag or it is empty");
                    continue;
                }

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();

                    System.out.println("URL: " + url + " - Response Code: " + responseCode);

                    if (responseCode >= 400) {
                        System.err.println("The link with text \"" + link.getText() + "\" is broken with code " + responseCode);
                    }

                    softAssert.assertTrue(responseCode < 400, "The link with text \"" + link.getText() + "\" is broken with code " + responseCode);
                } catch (IOException e) {
                    System.err.println("Exception while checking URL: " + url + " - " + e.getMessage());
                    softAssert.fail("Exception while checking URL: " + url);
                }
            }

            softAssert.assertAll();
        } finally {
            driver.quit();
        }
    }
}
