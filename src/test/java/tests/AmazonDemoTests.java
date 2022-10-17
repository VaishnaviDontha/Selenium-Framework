package tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import reports.ReportingManager;

public final class AmazonDemoTests {

    private AmazonDemoTests(){}

    @Test
    public void amazonTests() throws Exception {

        ReportingManager.getExtenttest().assignAuthor("Vaishnavi").assignAuthor("Author2").assignCategory("Smoke").assignCategory("Regression");
        String title = new AmazonHomePage().clickHamburger().clickElectonics().clickOnSubMenuItem("Headphones").getTitle();
        Assertions.assertThat(title).isNotNull().isNotBlank();
        
    }
    
}
