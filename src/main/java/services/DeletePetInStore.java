package services;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

public class DeletePetInStore {

  private static final String PATH_DELETE_PET = "/pet/{petId}";

  public ValidatableResponse deletePet(int petId) {

    return given(new BaseRequest().getReqSpec())
        .log().all()
        .pathParam("petId", petId)
        .when()
        .delete(PATH_DELETE_PET)
        .then()
        .log().all();

  }

}
