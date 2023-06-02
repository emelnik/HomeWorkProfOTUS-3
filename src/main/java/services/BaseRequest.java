package services;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;

public class BaseRequest {

  private RequestSpecification reqSpec;

  public RequestSpecification getReqSpec() {
    reqSpec = given()
        .baseUri(System.getProperty("base.url", "https://petstore.swagger.io/v2"))
        .contentType(ContentType.JSON);
    return reqSpec;
  }
}
