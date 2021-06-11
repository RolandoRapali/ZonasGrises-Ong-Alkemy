package alkemy.challenge.Challenge.Alkemy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {

    @JsonIgnore
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String image;

    private int phone;

    private String adress;

}
