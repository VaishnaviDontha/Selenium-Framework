package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {

    }

    @Test
    public void loginLogoutTests() {

        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        
        String title = ohlp.enterUserName("Admin").enterPassword("admin123").clickLogin().clickWelcome().clickLogout().getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");

    }

}
