package services;

import helper.ApiHelper;
import io.restassured.response.Response;
import models.Postpets.PostPet;

public class TestingService extends ApiHelper {

    public static Response getPetByStatus(String str) {
        return getPetsData().when().queryParam("status", str).get("/pet/findByStatus");
    }

    public static Response postPet(PostPet pt) {
        return getPetsData().body(gson().toJson(pt)).log().all().post("/pet");
    }
}
