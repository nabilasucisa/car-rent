package enigma.car_rent.service;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.utils.DTO.CarDTO;
import enigma.car_rent.utils.DTO.RentDTO;

import java.util.List;

public interface RentService {
    Rent create(RentDTO requset);
    List<Rent> getAll();
    Rent getOne(Integer id);
    Rent update(RentDTO request);
    void delete(Integer id);
}
