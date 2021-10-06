package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.net.URI;

public class ApiHelper {

    public static Gson gson;

    static String ReferenceUrl = "https://petstore.swagger.io/v2";

    protected static RequestSpecification getPetsData() {
        RestAssured.baseURI = URI.create(ReferenceUrl).toString();
        RequestSpecification request = RestAssured.given();

        request
                .header("accept", "application/json")
                .header("Content-Type", "application/json;charset=UTF-8");

        return request;
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }
}
