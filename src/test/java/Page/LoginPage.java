package Page;

import org.openqa.selenium.By;
import org.testng.Assert;

import static Keywords.WebUi.*;

public class LoginPage {

    String URL = "http://test-system.crmstar.vn/";

    By usernameInput = By.id("email");
    By passwordInput = By.id("password");
    By loginBtn = By.className("btn-success");


//    fl-message
    public By messageErrorLogin = By.className("fl-message");
    public By messageLoginPass = By.className("toast-message");
    public void verifyErrorMessageDisplay(String expected, String message) {
        Assert.assertTrue(getWebElement(messageErrorLogin).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(messageErrorLogin), expected, message);
    }
    public void verifyPassMessageDisplay(String expected, String message) {
        Assert.assertTrue(getWebElement(messageLoginPass).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(messageLoginPass), expected, message);
    }



    public void enterUsername(String userName) {
        setText(usernameInput, userName);

    }

    public void enterPassword(String password) {
        setText(passwordInput, password);

    }

    public void clickBtnLogin() {
        clickElement(loginBtn);

    }


    public void loginPass(String userName, String password) {
        openURL(URL);
        enterUsername(userName);
        enterPassword(password);
        clickBtnLogin();
        waitForElementVisible(messageLoginPass);
        verifyPassMessageDisplay("Đăng nhập thành công!", "Thông báo không hợp lệ");
    }
    public void loginFail(String userName, String password) {
        openURL(URL);
        enterUsername(userName);
        enterPassword(password);
        clickBtnLogin();
        waitForElementVisible(messageErrorLogin);
        verifyErrorMessageDisplay("Email hoặc mật khẩu không đúng", "cảnh báo không khớp");

    }







}
