package enigma.car_rent.utils.specification;

import enigma.car_rent.model.Rent;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RentSpecification {
    public static Specification<Rent> getSpecification(Boolean completed) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (completed != null) {
                predicates.add(criteriaBuilder.equal(root.get("completed"), completed));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
