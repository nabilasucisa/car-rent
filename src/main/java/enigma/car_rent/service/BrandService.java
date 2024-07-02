package enigma.car_rent.service;

import enigma.car_rent.model.Brand;

import java.util.List;

public interface BrandService {
    Brand create(Brand requset);
    List<Brand> getAll();
    Brand getOne(Integer id);
    Brand update(Brand request);
    void delete(Integer id);
}
