package utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import constants.FrameworkConstants;

public final class DataProviderUtils {

    private DataProviderUtils() {
    }

    @DataProvider
    public static Object[] getData(Method m) {

        String testname = m.getName();
        System.out.println(testname);

        List<Map<String, String>> list = ExcelUtils.getTestDetails("data");

        List<Map<String, String>> refinedList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname)) {
                if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    refinedList.add(list.get(i));
                }

            }
        }

        System.out.println(refinedList);
        return refinedList.toArray();

    }

}
