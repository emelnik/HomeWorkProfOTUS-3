package user.createuser;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.UserGetApi;

public class CreateNewUserNegative_Test {

  //В данном тесте запрашиваем несуществующего пользователя и проверяем что ответ будет 404
  @Test
  public void getNonexistentUser() {

    UserGetApi userGetApi = new UserGetApi();

    userGetApi.getUser("blablabla")
        .statusCode(HttpStatus.SC_NOT_FOUND);

  }

}
