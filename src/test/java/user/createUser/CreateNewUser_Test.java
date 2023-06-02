package user.createuser;

import static org.hamcrest.Matchers.equalTo;

import dto.GetUserResponseDTO;
import dto.UserRequestDTO;
import dto.UserResponseDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserCreateApi;
import services.UserGetApi;

public class CreateNewUser_Test {

  private final String username = "testik007";
  private final int id = 299;
  private final String email = "testikk@mail.ru";
  private final String firstName = "Testik007";
  private final String lastName = "Testirovich007";

  //В данном тесте проверяем создание пользователя с заполнением нижеперечисленных полей
  //проверяем что апишка возвращает корректный код ответа, тип и сообщение
  @Test
  public void createUser() {
    UserCreateApi userApi = new UserCreateApi();

    UserRequestDTO user = UserRequestDTO.builder()
        .id(id)
        .email(email)
        .firstName(firstName)
        .lastName(lastName)
        .password("123456")
        .username(username)
        .userStatus(201)
        .build();

    UserResponseDTO userResponse = userApi.createUser(user).extract().body().as(UserResponseDTO.class);

    Assertions.assertEquals(200, userResponse.getCode());
    Assertions.assertEquals("unknown", userResponse.getType());
    Assertions.assertEquals("299", userResponse.getMessage());

  }

  //В данном тесте создаем юзера только с одним полем username и проверяем что юзер успешно создался
  @Test
  public void createUserOnlyUsernameField() {

    UserCreateApi userCreateApi = new UserCreateApi();

    UserRequestDTO userRequestDTO = UserRequestDTO
        .builder()
        .username("tosik")
        .build();

    userCreateApi
        .createUser(userRequestDTO)
        .statusCode(200)
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"));

  }

  //В данном тесте проверяем что пользователь созданный выше корректно создался
  //запрос ответил 200 и поля заполнены согласно созданному юзеру
  @Test
  public void getUserByUsername() {

    UserCreateApi userCreateApi = new UserCreateApi();

    UserRequestDTO user = UserRequestDTO.builder()
        .id(id)
        .email(email)
        .password("123456")
        .username(username)
        .userStatus(201)
        .build();

    userCreateApi.createUser(user).statusCode(HttpStatus.SC_OK);


    UserGetApi userGetApi = new UserGetApi();

    GetUserResponseDTO getUserResponseDTO = userGetApi.getUser(username)
        .statusCode(HttpStatus.SC_OK)
        .extract()
        .body()
        .as(GetUserResponseDTO.class);

    Assertions.assertEquals(201, getUserResponseDTO.getUserStatus());
    Assertions.assertEquals(username, getUserResponseDTO.getUsername());
    Assertions.assertEquals(id, getUserResponseDTO.getId());
    Assertions.assertEquals(email, getUserResponseDTO.getEmail());
  }
}
