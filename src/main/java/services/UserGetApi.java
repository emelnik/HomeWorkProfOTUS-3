package services;

import static io.restassured.RestAssured.*;

import io.restassured.response.ValidatableResponse;

public class UserGetApi {

  private static final String PATH_GET_USER = "/user/{username}";

  public ValidatableResponse getUser(String username) {

    return given(new BaseRequest().getReqSpec())
        .log().all()
        .pathParam("username", username)
        .when()
        .get(PATH_GET_USER)
        .then().log().all();

  }

}
