package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {

    }

    @Test(dataProvider = "loginTestData")
    public void loginLogoutTests(String username, String password) {

        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        
        String title = ohlp.enterUserName(username)
                            .enterPassword(password)
                            .clickLogin()
                            .clickWelcome()
                            .clickLogout()
                            .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");

    }


    @DataProvider(parallel = true)
    public Object[][] loginTestData() {


        return new Object[][]{
            {"Admin","admin123"},
            {"Admin12","admin"},
            {"Admin","admin123"},
            {"Admin","admin123"}

        };
        
    }

}
