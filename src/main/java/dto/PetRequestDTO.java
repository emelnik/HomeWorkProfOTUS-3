
package dto;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PetRequestDTO {

  private Category category;

  private int id;

  private String name;

  private List<String> photoUrls;

  private String status;

  private List<Tag> tags;

}
