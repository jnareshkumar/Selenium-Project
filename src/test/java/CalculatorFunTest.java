import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorFunTest {

    @Test
    public void verifyCalculatorElements() throws InterruptedException	{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("file:///C:/NARESH/DEVOPS/SELENIUM/MAVEN/JNKCalculator.html");

            // Verify the web elements
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='num1']")).isDisplayed(),"First Number is not displayed");

	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='num2']")).isDisplayed(),"Second Number is not displayed");

    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).isDisplayed(),"Result is not displayed");

            System.out.println("All three elements are displayed.");

            // Wait up to 5 minutes for you to click Add Numbers
            WebDriverWait wait =  new WebDriverWait(driver, Duration.ofMinutes(5));

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"), "Sum ="));

            // Read and verify the result
            String actualResult = driver.findElement(By.id("result")).getText();       
			System.out.println("Result displayed on webpage: " + actualResult);

            Assert.assertTrue(actualResult.startsWith("Sum ="),"Addition result was not displayed");

            System.out.println("Calculator functional test PASS.");
        } 
		finally 
		{
           Thread.sleep(5000);  // Wait for 5 seconds
			driver.quit();
			System.out.println("Browser closed.");
        }
    }
}