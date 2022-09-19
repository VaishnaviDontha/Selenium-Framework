package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/testData/testdata.xlsx");
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

        return data;
        
        
    }

}
