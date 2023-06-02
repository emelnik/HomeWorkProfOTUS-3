package services;

import static io.restassured.RestAssured.given;

import dto.PetRequestDTO;

import io.restassured.response.ValidatableResponse;

public class AddPetInStoreApi {

  private static final String PATH_ADD_PET = "/pet";

  public ValidatableResponse addPetInStore(PetRequestDTO petRequestDTO) {

    return given(new BaseRequest().getReqSpec())
        .log().all()
        .body(petRequestDTO)
        .when()
        .post(PATH_ADD_PET)
        .then()
        .log().all();
  }

}
