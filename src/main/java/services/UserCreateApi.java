package services;


import dto.UserRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserCreateApi {

  private static final String BASE_URL = "https://petstore.swagger.io/v2";
  private static final String PATH_CREATE_USER = "/user";

  private RequestSpecification reqSpec;

  public UserCreateApi() {
    reqSpec = given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createUser(UserRequestDTO userCreateDTO) {

    return given(reqSpec)
        .log().all()
        .body(userCreateDTO)
        .when()
        .post(PATH_CREATE_USER)
        .then()
        .log().all();

  }

}
