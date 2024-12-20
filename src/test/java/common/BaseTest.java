package common;

import constant.ConstantGlobal;
import driver.DriverManager;
import helpers.CaptureHelper;
import helpers.SystemsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import static constant.ConstantGlobal.BROWSER;


public class BaseTest {


    CaptureHelper cap = new CaptureHelper();



    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver() {
        WebDriver driver = setupDriver(BROWSER);
        //Set giá trị driver đã đc khởi tạo vào ThreadLocal
        DriverManager.setDriver(driver);
    }

    public WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
//        String userDataDirectory = "C://Users//LENOVO//AppData//Local//Google//Chrome//User Data";
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--user-data-dir=" + userDataDirectory);
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        //WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        FirefoxOptions options = new FirefoxOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless");
            options.addArguments("window-size=1800,900");
        }
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }



}
