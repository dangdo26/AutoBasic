package testsuite;

import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorPractice extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    public void locator(){
        WebElement username = driver.findElement(By.name("email"));
        WebElement passWord = driver.findElement(By.name("pass"));
        WebElement mobileNumber = driver.findElement(By.name("mobile number"));
        System.out.println("username is: " + username );
        System.out.println("passWord is: " + passWord );
        System.out.println("mobileNumber is: " + mobileNumber );



    }

    public static void main(String[] args) {
        int a = 1250 + 100 + 40;
        int b = 800 + 50 ;
        int c = a - b;
        System.out.println(c);
    }
}
