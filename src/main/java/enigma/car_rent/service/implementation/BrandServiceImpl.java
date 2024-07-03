package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.repository.BrandRepository;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.utils.specification.BrandSpecification;
import enigma.car_rent.utils.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand requset) {
        return brandRepository.save(requset);
    }

    @Override
    public Page<Brand> getAll(Pageable pageable, String name) {
        Specification<Brand> spec = BrandSpecification.getSpecification(name);
        return brandRepository.findAll(spec, pageable);
    }

    @Override
    public Brand getOne(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("brand with id " + id + " not found"));
    }

    @Override
    public Brand update(Brand request) {
        Brand brand = this.getOne(request.getId());
        brand.setName(request.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}
