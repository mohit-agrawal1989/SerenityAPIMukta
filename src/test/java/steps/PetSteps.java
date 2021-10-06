package steps;

import com.google.common.reflect.TypeToken;
import com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.ListPets;
import models.Postpets.Category;
import models.Postpets.PostPet;
import models.Postpets.Tags;
import services.TestingService;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PetSteps {

    TestingService ts = new TestingService();
    Response res;
    PostPet pet = new PostPet();
    Category c = new Category();
    List<ListPets> postEntity;
    @When("^user find the pet by status \"([^\"]*)\"$")
    public void getPets(String str){
        res = ts.getPetByStatus(str);
    }

    @Then("verify the response")
    public void verifyTheResponse() {
        Type listType = new TypeToken<List<ListPets>>(){}.getType();

        postEntity = ts.gson().fromJson(res.getBody().prettyPrint(), listType);
        System.out.println(postEntity.get(0).getId());
    }

    @When("user enter pet name \"([^\"]*)\"$")
    public void userEnterPetName(String name) {
        c.setName(name);
        c.setId(198900);
        pet.setCategory(c);
    }

    @And("user enter photourl \"([^\"]*)\"$")
    public void userEnterPhotourl(String url) {
        String[] s = new String[1];
        s[0] = url;
        pet.setPhotoUrls(s);
    }

    @And("user enter status of pet \"([^\"]*)\"$")
    public void userEnterStatusOfPet(String status) {
        pet.setStatus(status);
    }

    @Then("verify pet is posted successfully")
    public void verifyPetIsPostedSuccessfully() {
        pet.setId(198900);
        pet.setName("bareilly");
        Tags t1 = new Tags();
        Tags[] t = new Tags[1];
        t1.setId(198900);
        t1.setName("bareilly");
        t[0] = t1;
        pet.setTags(t);
        res = ts.postPet(pet);
        pet = null;
        pet = ts.gson().fromJson(res.getBody().prettyPrint(), PostPet.class);
        System.out.println(pet.getId()+""+pet.getName());
    }
}
