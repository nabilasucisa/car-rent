package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.repository.CarRepository;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.DTO.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;

    @Override
    public Car create(CarDTO requset) {
        Brand brand = brandService.getOne(requset.getBrand_id());
        Car newCar = new Car();
        newCar.setBrand(brand);
        newCar.setName(requset.getName());
        newCar.setAvailable(requset.getAvailable());
        newCar.setPrice(requset.getPrice());
        Car result = carRepository.save(newCar);
        return result;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.findById(id).orElse(null);
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
