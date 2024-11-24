package Testcase;

import Page.LoginPage;
import common.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTestcase extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTestcase.class);
    LoginPage login = new LoginPage();

    @Test
    public void loginPass (){
        login.loginPass("admin@gmail.com","12345678");

    }
    @Test
    public void loginFailWithInvalidEmail(){
        login.loginFail("admin324@gmail.com","12345678");

    }
    @Test
    public void loginFailWithInvalidPassword(){
        login.loginFail("admin@gmail.com","123456782443");

    }
    @Test
    public void loginFailWithInvalidEmailAndPassword(){
        login.loginFail("admin324@gmail.com","12345678132");

    }



}
