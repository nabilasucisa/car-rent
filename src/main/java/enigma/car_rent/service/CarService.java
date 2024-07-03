package enigma.car_rent.service;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.utils.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    Car create(CarDTO requset);
    Page<Car> getAll(Pageable pageable, String name, Boolean available);
    Car getOne(Integer id);
    Car update(Integer id, CarDTO request);
    void delete(Integer id);

}
