package Page;

import Testcase.LoginTestcase;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Keywords.WebUi.*;

public class LogoutPage {

    LoginTestcase loginpass = new LoginTestcase();

    By userSetting = By.id("dropdownMenuLink");
    By dropdownLogout = By.xpath("//button[text() = 'Đăng xuất']");
    By confirmLogout = By.xpath("//button[text() = 'Đăng xuất' and contains(@class, 'btn-success')]");
    By textLogoutPass = By.xpath("//h4[text() ='Đăng nhập']");




    public void enterUser(){
        clickElement(userSetting);
    }
    public void enterDropdownLogout(){
        clickElement(dropdownLogout);
    }
    public void enterconfirmLogout(){
        clickElement(confirmLogout);
    }


    public void logoutPass() {
        loginpass.loginPass();
        sleep(7);
        enterUser();
        enterDropdownLogout();
        enterconfirmLogout();
        waitForElementVisible(textLogoutPass);
        Assert.assertEquals(getTextElement(textLogoutPass), "Đăng nhập", "Login title không khớp");

    }
}
