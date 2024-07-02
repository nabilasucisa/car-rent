package enigma.car_rent.utils.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CarDTO {
    private String name;
    private Boolean available;
    private Integer price;
    private Integer brand_id;
}
