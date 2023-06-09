package services;

import static io.restassured.RestAssured.given;

import dto.UserRequestDTO;

import io.restassured.response.ValidatableResponse;

public class UserCreateApi {

  private static final String PATH_CREATE_USER = "/user";

  public ValidatableResponse createUser(UserRequestDTO userCreateDTO) {

    return given(new BaseRequest().getReqSpec())
        .log().all()
        .body(userCreateDTO)
        .when()
        .post(PATH_CREATE_USER)
        .then()
        .log().all();

  }

}
