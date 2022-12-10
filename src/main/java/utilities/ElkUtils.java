package utilities;

import static io.restassured.RestAssured.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import enums.ConfigProperties;
import io.restassured.response.Response;

public final class ElkUtils {

    private ElkUtils() {
    }

    public static void sendDetailsToElk(String testname, String status) {

        if (PropertyUtils.get(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
            Map<String, String> map = new HashMap<>();
            map.put("testname", testname);
            map.put("status", status);
            map.put("executionTime", LocalDate.now().toString());

            Response res = given().header("Content-Type", "application/json")
                    .body(map)
                    .post("http://localhost:9200/automation/results");

            Assert.assertEquals(res.getStatusCode(), 201);
            res.prettyPrint();
        }
    }

}
