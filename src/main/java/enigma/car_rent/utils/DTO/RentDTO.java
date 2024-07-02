package enigma.car_rent.utils.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class RentDTO {
    private Boolean completed;
    private Date started_at;
    private Date ends_at;
    private Integer price;
    private Integer car_id;
    private Integer user_id;

}
