package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.CarRepository;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.DTO.CarDTO;
import enigma.car_rent.utils.specification.CarSpecification;
import enigma.car_rent.utils.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;

    @Override
    public Car create(CarDTO request) {
        Brand brand = brandService.getOne(request.getBrand_id());
        Car newCar = new Car();
        newCar.setBrand(brand);
        newCar.setName(request.getName());
        newCar.setAvailable(request.getAvailable());
        newCar.setPrice(request.getPrice());
        Car result = carRepository.save(newCar);
        return result;
    }

    @Override
    public Page<Car> getAll(Pageable pageable, String name, Boolean available) {
        Specification<Car> spec = CarSpecification.getSpecification(name, available);
        return carRepository.findAll(spec, pageable);
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("car with id " + id + " not found"));
    }

    @Override
    public Car update(Integer id, CarDTO request) {
        Car updateCar = this.getOne(id);
        Brand brand = brandService.getOne(request.getBrand_id());
        updateCar.setBrand(brand);
        updateCar.setName(request.getName());
        updateCar.setAvailable(request.getAvailable());
        updateCar.setPrice(request.getPrice());
        Car result = carRepository.save(updateCar);
        return result;
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
