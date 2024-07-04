package enigma.car_rent.service;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.utils.DTO.CarDTO;

import java.util.List;

public interface CarService {
    Car create(CarDTO request);
    List<Car> getAll();
    Car getOne(Integer id);
    Car update(Integer id, CarDTO request);
    void delete(Integer id);

}
