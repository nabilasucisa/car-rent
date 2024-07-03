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
    @NotBlank(message = "Name must be filled!")
    private String name;
    @NotNull(message = "Available cannot be null!")
    private Boolean available;
    @NotNull(message = "Price cannot be null!")
    private Integer price;
    @NotNull(message = "Brand ID cannot be null!")
    private Integer brand_id;
}
