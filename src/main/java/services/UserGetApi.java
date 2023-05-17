package services;

import dto.GetUserResponseDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserGetApi {

  private static final String BASE_URL = "https://petstore.swagger.io/v2";
  private static final String PATH_GET_USER = "https://petstore.swagger.io/v2/user/{username}";

  public ValidatableResponse getUser(String username){

    return given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON)
        .log().all()
        .pathParam("username", username)
        .when()
        .get(PATH_GET_USER)
        .then().log().all();

  }

}
