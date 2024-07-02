package enigma.car_rent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean available;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
