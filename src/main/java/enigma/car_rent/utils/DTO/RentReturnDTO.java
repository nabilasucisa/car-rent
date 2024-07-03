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

public class RentReturnDTO {
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date return_at;
}