package Testcase;

import Page.LogoutPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LogoutTestcase extends BaseTest {
    LogoutPage logout = new LogoutPage();

    @Test
    public void logoutPass(){
        logout.logoutPass();
    }


}
