package helperFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class webDriverUtils {

    public static WebDriver webDriver;

    public static void setupDriver() throws InterruptedException {
        System.out.println("Setting up Selenium WebDriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
