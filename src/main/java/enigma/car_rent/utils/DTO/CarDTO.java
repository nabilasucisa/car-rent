package enigma.car_rent.utils.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CarDTO {
    @NotBlank
    private String name;
    private Boolean available = true;
    @NotNull
    private Integer price;
    @NotNull
    private Integer brand_id;
}
