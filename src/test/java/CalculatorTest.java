import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorTest {

    @Test
    public void addTwoNumbers() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            //driver.get("file:///C:/NARESH/DEVOPS/SELENIUM/MAVEN/calculator.html");
			driver.get("file:///C:/NARESH/DEVOPS/SELENIUM/MAVEN/JNKCalculator.html");

            System.out.println(
                "Enter two numbers in Chrome and click Add."
            );

            WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofMinutes(5));

            wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                    By.id("result"), "Sum ="
                )
            );

            String actualResult =
                driver.findElement(By.id("result")).getText();

            System.out.println(
                "Result displayed on webpage: " + actualResult
            );

            Assert.assertTrue(
                actualResult.startsWith("Sum ="),
                "Addition result was not displayed"
            );

        } finally {
			Thread.sleep(5000);  // Wait for 5 seconds
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}