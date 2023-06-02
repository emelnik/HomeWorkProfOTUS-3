package pet;

import dto.Category;
import dto.PetRequestDTO;
import dto.PetResponseDTO;
import dto.Tag;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.AddPetInStoreApi;
import services.DeletePetInStore;

import java.util.ArrayList;
import java.util.List;

public class AddPetInStore_Test {

  //В этом тесте создаем зверюшку и проверяем что в респонсе приходит имя и название категории которую мы создавали
  @Test
  public void addPetInStore() {

    List<String> petPhotoUrl = new ArrayList<>();
    List<Tag> petTagList = new ArrayList<>();

    String petName = "Barsik002";
    String categoryName = "Cat";
    int idPet = 100500;

    petPhotoUrl.add("https://www.mail.ru");
    petTagList.add(new Tag(10, "kity2"));

    AddPetInStoreApi addPetInStoreApi = new AddPetInStoreApi();

    PetRequestDTO petRequestDTO = PetRequestDTO
        .builder()
        .id(idPet)
        .category(new Category(123, categoryName))
        .name(petName)
        .photoUrls(petPhotoUrl)
        .tags(petTagList)
        .status("available")
        .build();

    PetResponseDTO petResponseDTO = addPetInStoreApi
        .addPetInStore(petRequestDTO)
        .extract()
        .body()
        .as(PetResponseDTO.class);

    Assertions.assertEquals(petName, petResponseDTO.getName());
    Assertions.assertEquals(categoryName, petResponseDTO.getCategory().getName());

    new DeletePetInStore().deletePet(idPet).statusCode(HttpStatus.SC_OK);

  }

}
