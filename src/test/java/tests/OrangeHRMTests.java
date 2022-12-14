package tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import enums.CategoryType;
import pages.OrangeHRMLoginPage;

import utilities.DataProviderUtils;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {

    }

    @FrameworkAnnotation(author = {"Vaishnavi"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void loginLogoutTests(Map<String,String> data) throws Exception {

        // Reporting.createTest("loginlogouttests"); moving this to Base Test as this
        // doesn't define any test data
        // Driver.initDriver(data.get("browser"));

        // ReportingManager.getExtenttest().assignAuthor("Vaishnavi").assignAuthor("Author2").assignCategory("Smoke").assignCategory("Regression");
        
        String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");

    }

    @DataProvider(parallel = true)
    public Object[][] loginTestData() {

        return new Object[][] {
                { "Admin", "admin123" }
                // { "Admin", "admin12" },
                // { "Admin", "admin13" },
                // { "Admin", "admin23" }

        };

    }


    @Test
    public void newTest(Map<String,String> data)  {

        String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");
        
    }
   
    
    /*
     * Integration of Excel with DataProvider
    @Test(dataProvider = "loginTestDataViaExcel")
    public void loginTestDataViaExcelTest(String uname, String pwd) {

    OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();

    String title = ohlp.enterUserName(uname)
    .enterPassword(pwd)
    .clickLogin()
    .clickWelcome()
    .clickLogout()
    .getTitle();

    Assertions.assertThat(title).isEqualTo("OrangeHRM");

    }

    @DataProvider()
    public Object[][] loginTestDataViaExcel() throws IOException {

    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
    "/src/main/java/testData/testdata.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet("Sheet1");

    int row = sheet.getLastRowNum();
    int col = sheet.getRow(0).getLastCellNum();

    System.out.println("Row :" + row + "Column :" + col );

    Object[][] data = new Object[row][col];

    for (int i = 1; i <= row; i++) {

    for (int j = 0; j < data.length; j++) {

    data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

    }

    }

    workbook.close();
    return data;

    }
     */
    

}
