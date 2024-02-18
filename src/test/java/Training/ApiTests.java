package Training;

import io.restassured.http.ContentType;
import models.UserDataDeser;
import models.UserDataSer;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test
    public void getListOfUsers() {
        String endpoint = "https://reqres.in/api/users?page=2";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getSingleUser() {
        String endpoint = "https://reqres.in/api/users";
        var response =
                given()
                        .queryParam("id", 2)
                        .when()
                        .get(endpoint)
                        .then();
        response.log().body();

    }

    @Test
    public void createUser() {
        String endpoint = "https://reqres.in/api/users";
        String body = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;
        var response = given().body(body).when().post(endpoint).then();
        response.log().all();
    }

    @Test
    public void updateUser() {
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        var response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteUser() {
        String endpoint = "https://reqres.in/api/users/2";
        var response = given().when().delete(endpoint).then();
        response.log().all();
    }

    //Serialization
    @Test
    public void createUserSerialized() {
        String endpoint = "https://reqres.in/api/users";
        UserDataSer userData = new UserDataSer("may", "engineer");
        var response = given().body(userData).when().post(endpoint).then();
        response.log().all();
    }

    @Test
    public void getSingleUserMatcher() {
        String endpoint = "https://reqres.in/api/users";

        given()
                .queryParam("id", 2)
        .when()
                .get(endpoint)
        .then()
              .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.size()", greaterThan(0));
                //.body("data.id[0]", equalTo(2));


    }

    //Deserialization
    //@Test
  /*  public void getSingleUserDeserialized() {
        String endpoint = "https://reqres.in/api/users";
        UserDataDeser expected = new UserDataDeser(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg","https://reqres.in/#support-heading","To keep ReqRes free");


           UserDataDeser actual = given()
                        .queryParam("id", 2)
                        .when()
                        .get(endpoint)
                        .as(UserDataDeser.class);


    }*/


}
