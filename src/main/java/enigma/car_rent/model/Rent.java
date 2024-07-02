package enigma.car_rent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rents")

public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean completed;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDateTime started_at;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDateTime ends_at;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
