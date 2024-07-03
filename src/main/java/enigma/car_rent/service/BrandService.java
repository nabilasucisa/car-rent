package enigma.car_rent.service;

import enigma.car_rent.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    Brand create(Brand request);
    Page<Brand> getAll(Pageable pageable, String name);
    Brand getOne(Integer id);
    Brand update(Brand request);
    void delete(Integer id);
}
