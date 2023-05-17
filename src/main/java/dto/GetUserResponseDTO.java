
package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetUserResponseDTO {

    private String email;

    private String firstName;

    private int id;

    private String lastName;

    private String password;

    private String phone;

    private int userStatus;

    private String username;

}
