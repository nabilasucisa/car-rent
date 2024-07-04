package enigma.car_rent.utils.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class RentDTO {
    private Boolean completed = false;
    @NotNull (message = "Started Date Rent cannot be null!")
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date started_at;
    @NotNull (message = "End Date Rent cannot be null!")
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date ends_at;
    private Integer price;
    @NotNull (message = "Car ID cannot be null!")
    private Integer car_id;
    @NotNull (message = "User ID cannot be null!")
    private Integer user_id;

}
