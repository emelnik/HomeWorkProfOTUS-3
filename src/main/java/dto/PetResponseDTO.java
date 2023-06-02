
package dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonSerialize
public class PetResponseDTO {

  private Category category;

  private int id;

  private String name;

  private List<String> photoUrls;

  private String status;

  private List<Tag> tags;

}
