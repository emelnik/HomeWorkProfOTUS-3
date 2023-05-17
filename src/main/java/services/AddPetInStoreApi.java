package services;

import dto.PetRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AddPetInStoreApi {

  private static final String BASE_URL = "https://petstore.swagger.io/v2";
  private static final String PATH_ADD_PET = "/pet";

  private RequestSpecification reqSpec;

  public AddPetInStoreApi(){
    reqSpec = given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse addPetInStore(PetRequestDTO petRequestDTO){

  return given(reqSpec)
        .log().all()
        .body(petRequestDTO)
        .when()
        .post(PATH_ADD_PET)
        .then()
        .log().all();
  }

}
