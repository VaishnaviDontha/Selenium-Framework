package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FrameworkConstants;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetname) {

        FileInputStream fis = null;
        List<Map<String, String>> list = null;

        try {
            fis = new FileInputStream(FrameworkConstants.getExcelpath());
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetname);

            Map<String, String> dataMap = null;
            list = new ArrayList<>();

            int rownum = sheet.getLastRowNum();
            int colnum = sheet.getRow(0).getLastCellNum();

            /*
             * starting from i = 1 because the excel holds headers
             */

            for (int i = 1; i <= rownum; i++) {

                dataMap = new HashMap<>();

                for (int j = 0; j < colnum; j++) {

                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();

                    dataMap.put(key, value);

                }

                list.add(dataMap);
                workbook.close();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return list;
    }

}
