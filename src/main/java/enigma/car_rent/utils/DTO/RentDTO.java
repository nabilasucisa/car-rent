package enigma.car_rent.utils.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class RentDTO {
    private Boolean completed;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDateTime started_at;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDateTime ends_at;
    private Integer price;
    private Integer car_id;
    private Integer user_id;

}
