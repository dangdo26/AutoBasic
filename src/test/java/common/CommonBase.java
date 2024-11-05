package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class CommonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String URl) {


        System.out.println("Launching Chrome browser...");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URl);
        return driver;
    }
}
